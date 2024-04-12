package feature.controller;

import feature.entity.bindings.AddExerciseModel;
import feature.entity.bindings.ExerciseModel;
import feature.service.exercise.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST}, allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/exercises")
@RequiredArgsConstructor
public class ExerciseController {

    private final ExerciseService exerciseService;

    @PostMapping("/add")
    public ResponseEntity<?> addExercise(@RequestBody AddExerciseModel addExercise){
        exerciseService.addExercise(addExercise);
        return ResponseEntity.ok("Exercise created successfully.");
    }

    @PostMapping("/delete")
    public ResponseEntity<?> removeExercise(@RequestBody ExerciseModel exerciseModel){
        exerciseService.deleteExercise(exerciseModel.getId());
        return ResponseEntity.ok("Exercise deleted successfully.");
    }
//
//    @PostMapping("/edit")
//    public ResponseEntity<?> editExercise(@RequestBody ExerciseModel exerciseModel){
//        exerciseService.editExercise(exerciseModel);
//        return ResponseEntity.ok("Exercise edited successfully.");
//    }
}
