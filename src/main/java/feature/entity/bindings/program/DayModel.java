package feature.entity.bindings.program;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class DayModel {

    private Long id;

    private String name;

    private LocalDate date;

    private String muscleGroup;

    private List<ExerciseModel> exercises;
}
