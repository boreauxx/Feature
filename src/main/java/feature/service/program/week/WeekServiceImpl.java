package feature.service.program.week;

import feature.entity.bindings.IdTransitionModel;
import feature.entity.bindings.program.RemoveWeekModel;
import feature.entity.models.program.Day;
import feature.entity.models.program.Program;
import feature.entity.models.program.Week;
import feature.repository.WeekRepository;
import feature.service.program.program.ProgramService;
import feature.service.program.day.DayService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class WeekServiceImpl implements WeekService {

    private final WeekRepository weekRepository;
    private final ProgramService programService;
    private final DayService dayService;

    @Override
    public void createWeek(IdTransitionModel idTransitionModel) {
        Week week = new Week();
        Program program = this.programService.findProgramById(idTransitionModel.getId());
        Week savedWeek = this.weekRepository.save(week);
        savedWeek.setDays(setBlankDays(savedWeek, program));
        savedWeek.setProgram(program);
        this.weekRepository.save(savedWeek);
    }
    @Override
    public void removeWeek(RemoveWeekModel removeWeekModel) {
        Program program = this.programService.findProgramById(removeWeekModel.getProgramId());
        Week week = this.weekRepository.findById(removeWeekModel.getWeekId()).orElseThrow(null);
        program.getWeeks().remove(week);
        this.programService.saveProgram(program);
        this.weekRepository.delete(week);
    }

    private List<Day> setBlankDays(Week week, Program program){
        if(program.getWeeks().size()<1){
            LocalDate currentDate = LocalDate.now();
            LocalDate startOfWeek = currentDate.with(java.time.temporal.TemporalAdjusters.previousOrSame(java.time.DayOfWeek.MONDAY));
            List<Day> days = new ArrayList<>();
            for(int i = 0; i <= 6; i ++ ){
                DayOfWeek dayOfWeek = startOfWeek.getDayOfWeek();
                String currentDay = dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault());
                Day day = new Day(currentDay, startOfWeek, "N/A", new ArrayList<>(), week);
                this.dayService.saveDay(day);
                days.add(day);
                startOfWeek = startOfWeek.plusDays(1);
            }
            return days;
        }
        else{
            Week lastWeek = program.getWeeks().get(program.getWeeks().size()-1);
            Day lastDay = lastWeek.getDays().get(6);
            LocalDate startOfWeek = lastDay.getDate().plusDays(1);
            List<Day> days = new ArrayList<>();
            for(int i = 0; i <= 6; i ++ ){
                DayOfWeek dayOfWeek = startOfWeek.getDayOfWeek();
                String currentDay = dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault());
                Day day = new Day(currentDay, startOfWeek, "N/A", new ArrayList<>(), week);
                this.dayService.saveDay(day);
                days.add(day);
                startOfWeek = startOfWeek.plusDays(1);
            }
            return days;
        }
    }

}



