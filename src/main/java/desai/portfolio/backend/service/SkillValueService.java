package desai.portfolio.backend.service;

import desai.portfolio.backend.dto.SkillValueDto;
import desai.portfolio.backend.entity.SubSkillType;

import java.util.List;

public interface SkillValueService{

    SkillValueDto addValue(SkillValueDto skillvalueDto);

    SkillValueDto updateValue(SkillValueDto skillvalueDto, Long id);

    SkillValueDto getValue(Long id);

}