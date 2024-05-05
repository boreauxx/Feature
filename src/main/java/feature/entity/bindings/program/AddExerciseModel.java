package feature.entity.bindings.program;

import lombok.Data;

@Data
public class AddExerciseModel {

    private String name;

    private Double kg;

    private Integer sets;

    private String reps;

    private String date;
}
