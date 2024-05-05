package feature.controller.program;

import feature.entity.bindings.program.AddDayGroup;
import feature.entity.bindings.program.AddExerciseModel;
import feature.entity.bindings.program.RemoveExerciseModel;
import feature.service.program.day.DayService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST}, allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/days")
@RequiredArgsConstructor
public class DayController {

    private final DayService dayService;
    @PostMapping("/set-name")
    public ResponseEntity<?> setMuscleGroup(@RequestBody AddDayGroup addDayGroup) {
        this.dayService.setMuscleGroup(addDayGroup);
        return ResponseEntity.ok(String.format("Muscle group with name: %s set for day with ID: %d",addDayGroup.getMuscleGroup(), addDayGroup.getDayId()));
    }

    @PostMapping("/exercise/add")
    public ResponseEntity<?> addExercise(@RequestBody AddExerciseModel addExerciseModel){
        this.dayService.addExercise(addExerciseModel);
        return ResponseEntity.ok("Exercise added successfully.");
    }

    @PostMapping("/exercise/remove")
    public ResponseEntity<?> removeExercise(@RequestBody RemoveExerciseModel removeExerciseModel){
        this.dayService.removeExercise(removeExerciseModel);
        return ResponseEntity.ok(String.format("Exercise with ID: %d removed successfully.", removeExerciseModel.getExerciseId()));
    }
}
