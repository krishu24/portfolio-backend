package desai.portfolio.backend.service;

import desai.portfolio.backend.dto.SubSkillTypeDto;

import java.util.List;

public interface SubSkillTypeService {

    SubSkillTypeDto addSubSkillType(SubSkillTypeDto subSkillTypeDto);

    SubSkillTypeDto updateSubSkillType(SubSkillTypeDto subSkillTypeDto, Long id);

    SubSkillTypeDto getSubSkillType(Long id);

    void deleteSubSkillType(Long id);

    List<SubSkillTypeDto> getAllSubSkillTypes();
}
