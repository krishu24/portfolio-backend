package desai.portfolio.backend.service.Impl;

import desai.portfolio.backend.dto.SkillValueDto;
import desai.portfolio.backend.entity.SkillValue;
import desai.portfolio.backend.exception.ResourceNotFoundException;
import desai.portfolio.backend.repository.SkillValueRepository;
import desai.portfolio.backend.service.SkillValueService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class SkillValueServiceImpl implements SkillValueService {

    private SkillValueRepository skillValueRepository;

    private ModelMapper modelMapper;

    @Override
    public SkillValueDto addSkillValue(SkillValueDto skillValueDto) {
        LocalDate currentDate = LocalDate.now();
        Date now= Date.valueOf(currentDate);
        skillValueDto.setDate(now);
        SkillValue skillValue = modelMapper.map(skillValueDto, SkillValue.class);

        SkillValue savedSkillValue = skillValueRepository.save(skillValue);

        SkillValueDto savedSkillValueDto = modelMapper.map(savedSkillValue, SkillValueDto.class);

        return savedSkillValueDto;
    }

    @Override
    public SkillValueDto updateSkillValue(SkillValueDto skillvalueDto, Long id) {
        LocalDate currentDate = LocalDate.now();
        Date now = Date.valueOf(currentDate);
        SkillValue skillvalue = skillValueRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SubSkill not found with ID : " + id));
        skillvalue.setValue(skillvalueDto.getValue());
        skillvalue.setDate(now);
        SkillValue updateSkillValue = skillValueRepository.save(skillvalue);

        return modelMapper.map(updateSkillValue, SkillValueDto.class);
    }

    @Override
    public SkillValueDto getSkillValue(Long id) {
        SkillValue skillValue = skillValueRepository.findById(id)
                .orElseThrow(()->
                        new ResourceNotFoundException("SkillValue not found with ID : "+ id));
        return modelMapper.map(skillValue, SkillValueDto.class);
    }

    @Override
    public List<SkillValueDto> getAllSkillValues() {
        List<SkillValue> skillValues = skillValueRepository.findAll();

        return skillValues.stream().map((skillValue) ->
                        modelMapper.map(skillValue, SkillValueDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteSkillValue(Long id) {
        SkillValue skillValue = skillValueRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("SkillValue not found with ID : "+ id));
        skillValueRepository.deleteById(id);
    }

}
