package feature.service.exercise;

import feature.entity.bindings.AddExerciseModel;

public interface ExerciseService {

    void addExercise(AddExerciseModel exerciseBindingModel);

    void deleteExercise(Long id);
}
