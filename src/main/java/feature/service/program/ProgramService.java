package feature.service.program;

import feature.entity.bindings.ProgramModel;
import feature.entity.models.Program;

import java.util.List;

public interface ProgramService {

    List<ProgramModel> getAllPrograms();

    void createProgram();

    void removeProgram(Long id);

    Program findById(Long id);

    void saveProgram(Program program);
}
