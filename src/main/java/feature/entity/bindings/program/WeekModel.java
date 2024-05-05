package feature.entity.bindings.program;

import lombok.Data;

import java.util.List;

@Data
public class WeekModel {

    private Long id;

    private List<DayModel> days;
}
