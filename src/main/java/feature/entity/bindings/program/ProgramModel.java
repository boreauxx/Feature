package feature.entity.bindings.program;

import lombok.Data;

import java.util.List;

@Data
public class ProgramModel {

    private Long id;

    private String name;

    private List<WeekModel> weeks;

}
