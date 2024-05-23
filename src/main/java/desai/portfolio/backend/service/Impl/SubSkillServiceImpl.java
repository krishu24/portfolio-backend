package desai.portfolio.backend.service.Impl;

import desai.portfolio.backend.dto.SkillDto;
import desai.portfolio.backend.dto.SubSkillDto;
import desai.portfolio.backend.entity.Skill;
import desai.portfolio.backend.entity.SubSkill;
import desai.portfolio.backend.exception.ResourceNotFoundException;
import desai.portfolio.backend.repository.SkillRepository;
import desai.portfolio.backend.repository.SubSkillRepository;
import desai.portfolio.backend.service.SubSkillService;
import org.modelmapper.ModelMapper;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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
    public SubSkillDto updateSubSkill(SubSkillDto subSkillDto, Long id) {
        LocalDate currentDate = LocalDate.now();
        Date now = Date.valueOf(currentDate);
        SubSkill subSkill = subSkillRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SubSkill not found with ID : " + id));
        subSkill.setName(subSkillDto.getName());
        subSkill.setSkill(subSkillDto.getSkill());
        subSkill.setSubSkillTypes(subSkillDto.getSubSkillTypes());
        subSkill.setDate(now);
        SubSkill updateSubSkill = subSkillRepository.save(subSkill);

        return modelMapper.map(updateSubSkill, SubSkillDto.class);
    }

    @Override
    public SubSkillDto getSubSkill(Long id) {
        SubSkill subSkill = subSkillRepository.findById(id)
                .orElseThrow(()->
                        new ResourceNotFoundException("SubSkill not found with ID : "+ id));
        return modelMapper.map(subSkill, SubSkillDto.class);
    }

    @Override
    public void deleteSubSkill(Long id) {
        SubSkill subSkill = subSkillRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("SubSkill not found with ID : "+ id));
        subSkillRepository.deleteById(id);
    }

    @Override
    public List<SubSkillDto> getAllSubSkills() {

        List<SubSkill> subSkills = subSkillRepository.findAll();

        return subSkills.stream().map((subSkill) ->
                        modelMapper.map(subSkill, SubSkillDto.class))
                .collect(Collectors.toList());
    }
}
