package feature.service.program.week;

import feature.entity.bindings.IdTransitionModel;
import feature.entity.bindings.program.RemoveWeekModel;

public interface WeekService {

    void createWeek(IdTransitionModel idTransitionModel);
    void removeWeek(RemoveWeekModel removeWeekModel);
}
