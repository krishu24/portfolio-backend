package desai.portfolio.backend.service.Impl;

import desai.portfolio.backend.dto.SubSkillDto;
import desai.portfolio.backend.entity.SubSkill;
import desai.portfolio.backend.exception.ResourceNotFoundException;
import desai.portfolio.backend.repository.SubSkillRepository;
import desai.portfolio.backend.service.SubSkillService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class SubSkillServiceImpl implements SubSkillService {
    private SubSkillRepository subSkillRepository;

    private ModelMapper modelMapper;

    @Override
    public SubSkillDto addSubSkill(SubSkillDto subSkillDto) {
        LocalDate currentDate = LocalDate.now();
        Date now= Date.valueOf(currentDate);
        subSkillDto.setDate(now);
        SubSkill subSkill = modelMapper.map(subSkillDto, SubSkill.class);

        SubSkill savedSubSkill = subSkillRepository.save(subSkill);

        SubSkillDto savedSubSkillDto = modelMapper.map(savedSubSkill, SubSkillDto.class);

        return savedSubSkillDto;
    }

    @Override
    public SubSkillDto updateSubSkill(SubSkillDto subSkillDto, Long sub_skill_id) {
        LocalDate currentDate = LocalDate.now();
        Date now = Date.valueOf(currentDate);
        SubSkill subSkill = subSkillRepository.findById(sub_skill_id)
                .orElseThrow(() -> new ResourceNotFoundException("SubSkill not found with ID : " + sub_skill_id));
        subSkill.setName(subSkillDto.getName());
        subSkill.setDate(now);
        SubSkill updateSubSkill = subSkillRepository.save(subSkill);

        return modelMapper.map(updateSubSkill, SubSkillDto.class);
    }

    @Override
    public SubSkillDto getSubSkill(Long sub_skill_id) {
        SubSkill subSkill = subSkillRepository.findById(sub_skill_id)
                .orElseThrow(()->
                        new ResourceNotFoundException("SubSkill not found with ID : "+ sub_skill_id));
        return modelMapper.map(subSkill, SubSkillDto.class);
    }

    @Override
    public void deleteSubSkill(Long sub_skill_id) {
        SubSkill subSkill = subSkillRepository.findById(sub_skill_id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("SubSkill not found with ID : "+ sub_skill_id));
        subSkillRepository.deleteById(sub_skill_id);
    }

    @Override
    public List<SubSkillDto> getAllSubSkills() {

        List<SubSkill> subSkills = subSkillRepository.findAll();

        return subSkills.stream().map((subSkill) ->
                        modelMapper.map(subSkill, SubSkillDto.class))
                .collect(Collectors.toList());
    }
}
