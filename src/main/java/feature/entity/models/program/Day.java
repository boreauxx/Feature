package feature.entity.models.program;

import feature.util.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "days")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Day extends BaseEntity {

    private String name;

    private LocalDate date;

    private String muscleGroup;

    @OneToMany(mappedBy = "day", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Exercise> exercises;

    @ManyToOne
    @JoinColumn(name = "week_id")
    private Week week;
}
