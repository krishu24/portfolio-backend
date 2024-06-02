package desai.portfolio.backend.service;

import desai.portfolio.backend.dto.SkillValueDto;

import java.util.List;

public interface SkillValueService{

    SkillValueDto addSkillValue(SkillValueDto skillvalueDto);

    SkillValueDto updateSkillValue(SkillValueDto skillvalueDto, Long id);

    SkillValueDto getSkillValue(Long id);

    List<SkillValueDto> getAllSkillValues();
    void deleteSkillValue(Long id);

}