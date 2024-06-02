package desai.portfolio.backend.service.Impl;

import desai.portfolio.backend.dto.SubSkillTypeDto;
import desai.portfolio.backend.entity.SubSkillType;
import desai.portfolio.backend.exception.ResourceNotFoundException;
import desai.portfolio.backend.repository.SubSkillTypeRepository;
import desai.portfolio.backend.service.SubSkillTypeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class SubSkillTypeServiceImpl implements SubSkillTypeService {

    private SubSkillTypeRepository subSkillTypeRepository;

    private ModelMapper modelMapper;

    @Override
    public SubSkillTypeDto addSubSkillType(SubSkillTypeDto subSkillTypeDto) {
        LocalDate currentDate = LocalDate.now();
        Date now= Date.valueOf(currentDate);
        subSkillTypeDto.setDate(now);
        SubSkillType subSkillType = modelMapper.map(subSkillTypeDto, SubSkillType.class);

        SubSkillType savedSubSkillType = subSkillTypeRepository.save(subSkillType);

        SubSkillTypeDto savedSubSkillTypeDto = modelMapper.map(savedSubSkillType, SubSkillTypeDto.class);

        return savedSubSkillTypeDto;
    }

    @Override
    public SubSkillTypeDto updateSubSkillType(SubSkillTypeDto subSkillTypeDto, Long sub_skill_type_id) {
        LocalDate currentDate = LocalDate.now();
        Date now = Date.valueOf(currentDate);
        SubSkillType subSkillType = subSkillTypeRepository.findById(sub_skill_type_id)
                .orElseThrow(() -> new ResourceNotFoundException("SubSkillType not found with ID : " + sub_skill_type_id));
        subSkillType.setName(subSkillTypeDto.getName());
        subSkillType.setDate(now);
        SubSkillType updateSubSkillType = subSkillTypeRepository.save(subSkillType);

        return modelMapper.map(updateSubSkillType, SubSkillTypeDto.class);
    }


    @Override
    public SubSkillTypeDto getSubSkillType(Long id) {
        SubSkillType subSkillType = subSkillTypeRepository.findById(id)
                .orElseThrow(()->
                        new ResourceNotFoundException("SubSkillType not found with ID : "+ id));
        return modelMapper.map(subSkillType, SubSkillTypeDto.class);
    }

    @Override
    public void deleteSubSkillType(Long id) {
        SubSkillType subSkillType = subSkillTypeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("SubSkillType not found with ID : "+ id));
        subSkillTypeRepository.deleteById(id);
    }

    @Override
    public List<SubSkillTypeDto> getAllSubSkillTypes() {

        List<SubSkillType> subSkillTypes = subSkillTypeRepository.findAll();

        return subSkillTypes.stream().map((subSkillType) ->
                        modelMapper.map(subSkillType, SubSkillTypeDto.class))
                .collect(Collectors.toList());
    }
}
