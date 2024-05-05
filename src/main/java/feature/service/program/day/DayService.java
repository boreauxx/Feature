package feature.service.program.day;

import feature.entity.bindings.program.AddDayGroup;
import feature.entity.bindings.program.AddExerciseModel;
import feature.entity.bindings.program.RemoveExerciseModel;
import feature.entity.models.program.Day;

public interface DayService {

    void addExercise(AddExerciseModel addExerciseModel);
    void removeExercise(RemoveExerciseModel removeExerciseModel);
    void saveDay(Day day);
    void setMuscleGroup(AddDayGroup addDayGroup);
}
