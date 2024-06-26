package feature.service.user;

import org.springframework.security.core.userdetails.UserDetailsService;
import feature.entity.models.user.User;

public interface UserService {

    UserDetailsService userDetailsService();

    User findByUsername(String username);

    User findById(Long id);


}
