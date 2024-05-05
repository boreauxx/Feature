package feature.controller.program;

import feature.entity.bindings.IdTransitionModel;
import feature.entity.bindings.program.AddProgramModel;
import feature.entity.bindings.program.ProgramModel;
import feature.service.program.program.ProgramService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST}, allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/programs")
@RequiredArgsConstructor
public class ProgramController {

    private final ProgramService programService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllPrograms(){
        List<ProgramModel> programs = programService.getAllPrograms();
        return ResponseEntity.ok(programs);
    }
    @GetMapping("/specific")
    public ResponseEntity<?> getSpecificProgram(@RequestParam Long id){
        ProgramModel programModel = programService.getSpecificProgram(id);
        return ResponseEntity.ok(programModel);
    }
    @PostMapping("/add")
    public ResponseEntity<?> addProgram(@RequestBody AddProgramModel addProgramModel){
        programService.createProgram(addProgramModel);
        return ResponseEntity.ok("Program created successfully.");
    }
    @PostMapping("/remove")
    public ResponseEntity<?> removeProgram(@RequestBody IdTransitionModel removeProgram){
        programService.removeProgram(removeProgram.getId());
        return ResponseEntity.ok(String.format("Program with ID: %d removed successfully.", removeProgram.getId()));
    }



}
