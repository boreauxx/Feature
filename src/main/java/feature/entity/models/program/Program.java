package feature.entity.models.program;

import feature.util.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "programs")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Program extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "program", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Week> weeks;

}
