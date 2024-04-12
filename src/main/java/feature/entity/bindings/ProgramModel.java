package feature.entity.bindings;

import lombok.Data;

import java.util.List;

@Data
public class ProgramModel {

    private Long id;

    private String name;

    private Integer days;

    private List<ExerciseModel> exercises;

}
