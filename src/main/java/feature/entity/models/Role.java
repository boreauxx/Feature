package feature.entity.models;

import feature.entity.enums.UserRole;
import feature.util.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "roles")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Role extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private UserRole name;

    @OneToMany(mappedBy = "role")
    private List<User> users;
}
