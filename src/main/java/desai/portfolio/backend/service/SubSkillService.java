package desai.portfolio.backend.service;

import desai.portfolio.backend.dto.SubSkillDto;

import java.util.List;

public interface SubSkillService {

    SubSkillDto addSubSkill(SubSkillDto subSkillDto);
    SubSkillDto updateSubSkill(SubSkillDto subSkillDto, Long sub_skill_id);
    SubSkillDto getSubSkill(Long sub_skill_id);
    void deleteSubSkill(Long sub_skill_id);
    List<SubSkillDto> getAllSubSkills();
}

