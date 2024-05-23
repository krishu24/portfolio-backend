package desai.portfolio.backend.service.Impl;

import desai.portfolio.backend.dto.SkillDto;
import desai.portfolio.backend.entity.Skill;
import desai.portfolio.backend.exception.ResourceNotFoundException;
import desai.portfolio.backend.repository.SkillRepository;
import desai.portfolio.backend.service.SkillService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SkillServiceImpl implements SkillService {
    private SkillRepository skillRepository;

    private ModelMapper modelMapper;


    @Override
    public SkillDto addSkill(SkillDto skillDto) {
        LocalDate currentDate = LocalDate.now();
        Date now= Date.valueOf(currentDate);
        skillDto.setDate(now);
        Skill skill = modelMapper.map(skillDto, Skill.class);

        Skill savedSkill = skillRepository.save(skill);

        SkillDto savedSkillDto = modelMapper.map(savedSkill, SkillDto.class);

        return savedSkillDto;
    }

    @Override
    public SkillDto updateSkill(SkillDto skillDto, Long id) {
        LocalDate currentDate = LocalDate.now();
        Date now = Date.valueOf(currentDate);
        Skill skill = skillRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Skill not found with ID : " + id));
        skill.setName(skillDto.getName());
        skill.setSubSkills(skillDto.getSubSkills());
        skill.setDate(now);
        Skill updateSkill = skillRepository.save(skill);

        return modelMapper.map(updateSkill, SkillDto.class);
    }


    @Override
    public SkillDto getSkill(Long id) {
        Skill skill = skillRepository.findById(id)
                .orElseThrow(()->
                        new ResourceNotFoundException("Skill not found with ID : "+ id));
        return modelMapper.map(skill, SkillDto.class);
    }

    @Override
    public void deleteSkill(Long id) {
        Skill skill = skillRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Skill not found with ID : "+ id));
        skillRepository.deleteById(id);
    }

    @Override
    public List<SkillDto> getAllSkills() {

        List<Skill> skills = skillRepository.findAll();

        return skills.stream().map((skill) ->
                        modelMapper.map(skill, SkillDto.class))
                .collect(Collectors.toList());
    }
}
