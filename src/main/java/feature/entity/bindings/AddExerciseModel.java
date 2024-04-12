package feature.entity.bindings;

import lombok.Data;

@Data
public class AddExerciseModel {

    private String name;

    private Double kg;

    private Integer sets;

    private Long programId;
}
