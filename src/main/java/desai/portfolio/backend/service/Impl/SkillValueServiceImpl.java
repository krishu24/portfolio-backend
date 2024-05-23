package desai.portfolio.backend.service.Impl;

import desai.portfolio.backend.dto.SkillValueDto;
import desai.portfolio.backend.dto.SubSkillDto;
import desai.portfolio.backend.entity.SkillValue;
import desai.portfolio.backend.entity.SubSkill;
import desai.portfolio.backend.exception.ResourceNotFoundException;
import desai.portfolio.backend.repository.SkillValueRepository;
import desai.portfolio.backend.service.SkillValueService;
import org.modelmapper.ModelMapper;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class SkillValueServiceImpl implements SkillValueService {

    private SkillValueRepository skillValueRepository;

    private ModelMapper modelMapper;

    @Override
    public SkillValueDto addValue(SkillValueDto skillValueDto) {
        LocalDate currentDate = LocalDate.now();
        Date now= Date.valueOf(currentDate);
        skillValueDto.setDate(now);
        SkillValue skillValue = modelMapper.map(skillValueDto, SkillValue.class);

        SkillValue savedSkillValue = skillValueRepository.save(skillValue);

        SkillValueDto savedSkillValueDto = modelMapper.map(savedSkillValue, SkillValueDto.class);

        return savedSkillValueDto;
    }

    @Override
    public SkillValueDto updateValue(SkillValueDto skillvalueDto, Long id) {
        LocalDate currentDate = LocalDate.now();
        Date now = Date.valueOf(currentDate);
        SkillValue skillvalue = (SkillValue) skillValueRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SubSkill not found with ID : " + id));
        skillvalue.setValue(skillvalueDto.getValue());
        skillvalue.setSubSkillType(skillvalueDto.getSubSkillType());
        skillvalue.setDate(now);
        SkillValue updateSkillValue = skillValueRepository.save(skillvalue);

        return modelMapper.map(updateSkillValue, SkillValueDto.class);
    }

    @Override
    public SkillValueDto getValue(Long id) {
        SkillValue skillValue = (SkillValue) skillValueRepository.findById(id)
                .orElseThrow(()->
                        new ResourceNotFoundException("SkillValue not found with ID : "+ id));
        return modelMapper.map(skillValue, SkillValueDto.class);
    }

}
