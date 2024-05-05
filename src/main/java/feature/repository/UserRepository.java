package feature.repository;

import feature.entity.models.user.Role;
import feature.entity.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findFirstByEmail(String email);

    Optional<User> findFirstByUsername(String username);

    Optional<User> findFirstByRole(Role role);
}
