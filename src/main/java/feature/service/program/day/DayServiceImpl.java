package feature.service.program.day;

import feature.entity.bindings.program.AddDayGroup;
import feature.entity.bindings.program.AddExerciseModel;
import feature.entity.bindings.program.RemoveExerciseModel;
import feature.entity.models.program.Day;
import feature.entity.models.program.Exercise;
import feature.repository.DayRepository;
import feature.repository.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class DayServiceImpl implements DayService {

    private final ModelMapper mapper;
    private final DayRepository dayRepository;
    private final ExerciseRepository exerciseRepository;

    @Override
    public void addExercise(AddExerciseModel addExerciseModel) {
        LocalDate date = LocalDate.parse(addExerciseModel.getDate());
        Day day = this.dayRepository.findFirstByDate(date).orElseThrow(null);
        if(day!=null){
            Exercise exercise = this.mapper.map(addExerciseModel, Exercise.class);
            exercise.setDay(day);
            Exercise savedExercise = this.exerciseRepository.save(exercise);
            day.getExercises().add(savedExercise);
            this.dayRepository.save(day);
        }
    }
    @Override
    public void removeExercise(RemoveExerciseModel removeExerciseModel) {
        Day day = this.dayRepository.findById(removeExerciseModel.getDayId()).orElseThrow(null);
        Exercise exercise = this.exerciseRepository.findById(removeExerciseModel.getExerciseId()).orElseThrow(null);
        day.getExercises().remove(exercise);
        this.dayRepository.save(day);
        this.exerciseRepository.delete(exercise);
    }
    @Override
    public void saveDay(Day day){
        this.dayRepository.save(day);
    }
    @Override
    public void setMuscleGroup(AddDayGroup addDayGroup) {
        Day day = this.dayRepository.findById(addDayGroup.getDayId()).orElseThrow(null);
        day.setMuscleGroup(addDayGroup.getMuscleGroup());
        this.dayRepository.save(day);
    }
}
