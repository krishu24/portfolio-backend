package desai.portfolio.backend.service;

import desai.portfolio.backend.dto.SubSkillTypeDto;

import java.util.List;

public interface SubSkillTypeService {

    SubSkillTypeDto addSubSkillType(SubSkillTypeDto subSkillTypeDto);

    SubSkillTypeDto updateSubSkillType(SubSkillTypeDto subSkillTypeDto, Long sub_skill_type_id);

    SubSkillTypeDto getSubSkillType(Long sub_skill_type_id);

    void deleteSubSkillType(Long sub_skill_type_id);

    List<SubSkillTypeDto> getAllSubSkillTypes();
}
