package feature.service.exercise;

import feature.entity.bindings.AddExerciseModel;
import feature.entity.models.Exercise;
import feature.entity.models.Program;
import feature.repository.ExerciseRepository;
import feature.service.program.ProgramService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class ExerciseServiceImpl implements ExerciseService{

    private final ExerciseRepository exerciseRepository;
    private final ModelMapper mapper;
    private final ProgramService programService;

    @Override
    public void addExercise(AddExerciseModel addExercise) {
        Exercise exercise = mapper.map(addExercise, Exercise.class);
        exercise.setPrograms(new ArrayList<>());
        this.exerciseRepository.save(exercise);
        Program program = programService.findById(addExercise.getProgramId());
        program.getExercises().add(exercise);
        programService.saveProgram(program);
    }

    @Override
    public void deleteExercise(Long id) {
        this.exerciseRepository.deleteById(id);
    }
}
