package feature.service.program.program;

import feature.entity.bindings.program.AddProgramModel;
import feature.entity.bindings.program.ProgramModel;
import feature.entity.models.program.Program;
import feature.repository.ProgramRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProgramServiceImpl implements ProgramService {

    private final ProgramRepository programRepository;
    private final ModelMapper mapper;

    @Override
    public List<ProgramModel> getAllPrograms() {
        List<Program> programs = this.programRepository.findAll();
        List<ProgramModel> mappedPrograms = new ArrayList<>();
        for(Program program : programs){
            ProgramModel mapped = mapper.map(program, ProgramModel.class);
            mappedPrograms.add(mapped);
        }
        return mappedPrograms;
    }
    @Override
    public ProgramModel getSpecificProgram(Long id){
        Program program = this.findProgramById(id);
        return this.mapper.map(program, ProgramModel.class);
    }
    @Override
    public Program findProgramById(Long id) {
        return this.programRepository.findById(id).orElseThrow(null);
    }
    @Override
    public void createProgram(AddProgramModel addProgramModel) {
        Program program = this.mapper.map(addProgramModel, Program.class);
        program.setWeeks(new ArrayList<>());
        this.programRepository.save(program);
    }
    @Override
    public void removeProgram(Long id) {
        this.programRepository.deleteById(id);
    }

    @Override
    public void saveProgram(Program program) {
        this.programRepository.save(program);
    }

}
