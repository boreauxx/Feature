package feature.entity.bindings.program;

import lombok.Data;

@Data
public class ExerciseModel {

    private Long id;

    private String name;

    private Double kg;

    private Integer sets;

    private String reps;
}
