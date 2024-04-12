package feature.controller;

import feature.exception.DuplicationUserInformationException;
import feature.jwt.payload.AuthenticationRequest;
import feature.jwt.payload.RegistrationRequest;
import feature.service.auth.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.POST}, allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody RegistrationRequest request)
            throws DuplicationUserInformationException {
        return authenticationService.register(request);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest request)
            throws BadCredentialsException, DisabledException, UsernameNotFoundException {
        return authenticationService.login(request);
    }
}
