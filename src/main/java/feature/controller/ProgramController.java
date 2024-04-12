package feature.controller;

import feature.entity.bindings.ProgramModel;
import feature.entity.bindings.RemoveProgramModel;
import feature.service.program.ProgramService;
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

    @PostMapping("/add")
    public ResponseEntity<?> addProgram(){
        programService.createProgram();
        return ResponseEntity.ok("Program created successfully.");
    }

    @PostMapping("/remove")
    public ResponseEntity<?> removeProgram(@RequestBody RemoveProgramModel removeProgram){
        programService.removeProgram(removeProgram.getId());
        return ResponseEntity.ok("Program removed successfully.");
    }




}
