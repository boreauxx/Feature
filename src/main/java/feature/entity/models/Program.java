package feature.entity.models;

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

    private Integer days;

    @ManyToMany
    @JoinTable(
            name = "programs_exercises",
            joinColumns = @JoinColumn(name = "program_id"),
            inverseJoinColumns = @JoinColumn(name = "exercise_id")
    )
    private List<Exercise> exercises;
}
