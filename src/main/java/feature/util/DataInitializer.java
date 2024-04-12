package feature.util;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import feature.entity.enums.UserRole;
import feature.entity.models.Role;
import feature.entity.models.User;
import feature.repository.RoleRepository;
import feature.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    @Override
    public void run(String... args) throws Exception {
        if(this.roleRepository.count()<1) {
            Role userRole = new Role(UserRole.USER, new ArrayList<>());
            Role moderatorRole = new Role(UserRole.MODERATOR, new ArrayList<>());
            Role adminRole = new Role(UserRole.ADMIN, new ArrayList<>());
            this.roleRepository.saveAll(List.of(userRole, moderatorRole, adminRole));
        }
        if(this.userRepository.findFirstByRole(this.roleRepository.findByName(UserRole.ADMIN)).isEmpty()){
            User user = new User("admin", encoder.encode("admin"),
                    "admin@abv.bg", this.roleRepository.findByName(UserRole.ADMIN));
            this.userRepository.save(user);
        }
    }
}
