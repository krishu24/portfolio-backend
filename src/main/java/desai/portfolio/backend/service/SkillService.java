package desai.portfolio.backend.service;

import desai.portfolio.backend.dto.SkillDto;
import desai.portfolio.backend.entity.Skill;

import java.util.List;

public interface SkillService {

    SkillDto addSkill(SkillDto skillDto);

    SkillDto updateSkill(SkillDto skillDto, Long skill_id);

    SkillDto getSkill(Long skill_id);

    void deleteSkill(Long skill_id);

    List<SkillDto> getAllSkills();

}
