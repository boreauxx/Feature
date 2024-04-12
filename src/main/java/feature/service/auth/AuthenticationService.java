package feature.service.auth;

import feature.exception.DuplicationUserInformationException;
import feature.jwt.payload.AuthenticationRequest;
import feature.jwt.payload.AuthenticationResponse;
import feature.jwt.payload.RegistrationRequest;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {

    ResponseEntity<?> register(RegistrationRequest request) throws DuplicationUserInformationException;
    ResponseEntity<?> login(AuthenticationRequest request);
    void createUser(RegistrationRequest request);
    boolean emailExists(String email);
    boolean usernameExists(String username);


}
