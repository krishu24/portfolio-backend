package desai.portfolio.backend.service.Impl;

import desai.portfolio.backend.dto.AboutDto;
import desai.portfolio.backend.dto.ExperienceDto;
import desai.portfolio.backend.entity.About;
import desai.portfolio.backend.entity.Experience;
import desai.portfolio.backend.exception.ResourceNotFoundException;
import desai.portfolio.backend.repository.ExperienceRepository;
import desai.portfolio.backend.service.ExperienceService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ExperienceServiceImpl implements ExperienceService {

    private ExperienceRepository experienceRepository;

    private ModelMapper modelMapper;


    @Override
    public ExperienceDto addExperience(ExperienceDto experienceDto) {
        LocalDate currentDate = LocalDate.now();
        Date now= Date.valueOf(currentDate);
        experienceDto.setDate(now);
        Experience experience = modelMapper.map(experienceDto, Experience.class);

        Experience savedExperience = experienceRepository.save(experience);

        ExperienceDto savedExperienceDto = modelMapper.map(savedExperience, ExperienceDto.class);

        return savedExperienceDto;
    }

    @Override
    public ExperienceDto getExperience(Long exp_id) {
        Experience experience = experienceRepository.findById(exp_id)
                .orElseThrow(()->
                        new ResourceNotFoundException("About not found with ID : "+ exp_id));
        return modelMapper.map(experience, ExperienceDto.class);
    }

    @Override
    public List<ExperienceDto> getAllExperience() {

        List<Experience> experiences = experienceRepository.findAll();

        return experiences.stream().map((experience) ->
                        modelMapper.map(experience, ExperienceDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ExperienceDto updateExperience(ExperienceDto experienceDto, Long exp_id) {
        LocalDate currentDate = LocalDate.now();
        Date now= Date.valueOf(currentDate);
        Experience experience = experienceRepository.findById(exp_id)
                .orElseThrow(() -> new ResourceNotFoundException("About not found with ID : "+ exp_id));
        experience.setName(experienceDto.getName());
        experience.setValue(experienceDto.getValue());
        experience.setDate(now);
        Experience updateExperience = experienceRepository.save(experience);

        return modelMapper.map(updateExperience, ExperienceDto.class);
    }

    @Override
    public void deleteExperience(Long exp_id) {
        Experience experience = experienceRepository.findById(exp_id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("About not found with ID : "+ exp_id));
        experienceRepository.deleteById(exp_id);

    }
}
