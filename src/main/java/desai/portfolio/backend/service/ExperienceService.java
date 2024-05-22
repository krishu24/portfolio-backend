package desai.portfolio.backend.service;

import desai.portfolio.backend.dto.AboutDto;
import desai.portfolio.backend.dto.ExperienceDto;

import java.util.List;

public interface ExperienceService {

    ExperienceDto addExperience(ExperienceDto experienceDto);


    ExperienceDto getExperience(Long exp_id);

    List<ExperienceDto> getAllExperience();

    ExperienceDto updateExperience(ExperienceDto experienceDto,Long exp_id);

    void deleteExperience(Long exp_id);

}
