package desai.portfolio.backend.service;

import desai.portfolio.backend.dto.SubSkillDto;

import java.util.List;

public interface SubSkillService {

    SubSkillDto addSubSkill(SubSkillDto subSkillDto);
    SubSkillDto updateSubSkill(SubSkillDto subSkillDto, Long id);
    SubSkillDto getSubSkill(Long id);
    void deleteSubSkill(Long id);
    List<SubSkillDto> getAllSubSkills();
}

