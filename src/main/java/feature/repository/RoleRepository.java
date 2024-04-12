package feature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import feature.entity.enums.UserRole;
import feature.entity.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(UserRole name);
}
