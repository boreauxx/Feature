package feature.controller.program;

import feature.entity.bindings.IdTransitionModel;
import feature.entity.bindings.program.RemoveWeekModel;
import feature.service.program.week.WeekService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST}, allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/weeks")
@RequiredArgsConstructor
public class WeekController {

    private final WeekService weekService;

    @PostMapping("/add")
    public ResponseEntity<?> createWeek(@RequestBody IdTransitionModel idTransitionModel){
        this.weekService.createWeek(idTransitionModel);
        return ResponseEntity.ok("Week created successfully.");
    }

    @PostMapping("/remove")
    public ResponseEntity<?> removeWeek(@RequestBody RemoveWeekModel removeWeekModel){
        this.weekService.removeWeek(removeWeekModel);
        return ResponseEntity.ok(String.format("Week with ID: %d removed successfully.", removeWeekModel.getWeekId()));
    }
}
