package feature.entity.models.program;

import feature.entity.models.program.Program;
import feature.util.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "exercises")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Exercise extends BaseEntity {

    private String name;

    private Integer sets;

    private String reps;

    private Double kg;

    @ManyToOne
    @JoinColumn(name = "day_id")
    private Day day;

}
