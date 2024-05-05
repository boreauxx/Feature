package feature.service.program.program;

import feature.entity.bindings.IdTransitionModel;
import feature.entity.bindings.program.*;
import feature.entity.models.program.Program;

import java.util.List;

public interface ProgramService {

    List<ProgramModel> getAllPrograms();
    ProgramModel getSpecificProgram(Long id);
    Program findProgramById(Long id);
    void createProgram(AddProgramModel addProgramModel);
    void removeProgram(Long id);
    void saveProgram(Program program);

}
