package desai.portfolio.backend.service;

import desai.portfolio.backend.dto.SkillDto;

import java.util.List;

public interface SkillService {

    SkillDto addSkill(SkillDto skillDto);

    SkillDto updateSkill(SkillDto skillDto, Long id);

    SkillDto getSkill(Long id);

    void deleteSkill(Long id);

    List<SkillDto> getAllSkills();
}
