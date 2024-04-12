package feature.service.program;

import feature.entity.bindings.ProgramModel;
import feature.entity.models.Program;
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
    public void createProgram() {
        Program program = new Program("New Program", 90, new ArrayList<>());
        this.programRepository.save(program);
    }

    @Override
    public void removeProgram(Long id) {
        this.programRepository.deleteById(id);
    }

    @Override
    public Program findById(Long id) {
        return this.programRepository.findById(id).orElseThrow(null);
    }

    @Override
    public void saveProgram(Program program) {
        this.programRepository.save(program);
    }


}
