package feature.service.user;

import feature.entity.models.User;
import feature.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public UserDetailsService userDetailsService() {
        return username -> userRepository.findFirstByUsername(username)
                .orElseThrow( () -> new UsernameNotFoundException("Username doesn't exist."));
    }

    @Override
    public User findByUsername(String username) {
        return this.userRepository.findFirstByUsername(username).orElseThrow(null);
    }

    @Override
    public User findById(Long id) {
        return this.userRepository.findById(id).orElseThrow(null);
    }

}
