package feature.service.auth;

import feature.entity.enums.UserRole;
import feature.entity.models.User;
import feature.exception.DuplicationUserInformationException;
import feature.jwt.TokenUtil;
import feature.jwt.payload.AuthenticationRequest;
import feature.jwt.payload.AuthenticationResponse;
import feature.jwt.payload.RegistrationRequest;
import feature.repository.RoleRepository;
import feature.repository.UserRepository;
import feature.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import static feature.jwt.SecurityConstants.TOKEN_PREFIX;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final TokenUtil tokenUtil;
    private final ModelMapper mapper;

    @Override
    public ResponseEntity<?> register(@RequestBody RegistrationRequest request) {
        try {
            if (usernameExists(request.getUsername())) {
                throw new DuplicationUserInformationException("Username taken.", HttpStatus.CONFLICT);
            }
            if (emailExists(request.getEmail())) {
                throw new DuplicationUserInformationException("Email registered.", HttpStatus.CONFLICT);
            }
            createUser(request);
            return login(new AuthenticationRequest(request.getUsername(), request.getPassword()));
        } catch (DuplicationUserInformationException ex) {
            return ResponseEntity.status(ex.getStatus()).body(ex.getMessage());
        }
    }

    @Override
    public void createUser(RegistrationRequest request) {
        User user = mapper.map(request, User.class);
        user.setPassword(new BCryptPasswordEncoder().encode(request.getPassword()));
        user.setRole(this.roleRepository.findByName(UserRole.USER));
        this.userRepository.save(user);
    }

    @Override
    public boolean emailExists(String email) {
        return this.userRepository.findFirstByEmail(email).isPresent();
    }

    @Override
    public boolean usernameExists(String username) {
        return this.userRepository.findFirstByUsername(username).isPresent();
    }

    @Override
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest request){
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = tokenUtil.createToken(authentication);
            return ResponseEntity.ok(new AuthenticationResponse(token)) ;
        }
        catch(BadCredentialsException exception) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password.");
        }
    }
}
