package desai.portfolio.backend.service.Impl;

import desai.portfolio.backend.dto.SubSkillTypeDto;
import desai.portfolio.backend.entity.SubSkillType;
import desai.portfolio.backend.repository.SubSkillTypeRepository;
import desai.portfolio.backend.service.SubSkillTypeService;
import org.modelmapper.ModelMapper;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

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
    public SubSkillTypeDto updateSubSkillType(SubSkillTypeDto subSkillTypeDto, Long id) {
        return null;
    }

    @Override
    public SubSkillTypeDto getSubSkillType(Long id) {
        return null;
    }

    @Override
    public void deleteSubSkillType(Long id) {

    }

    @Override
    public List<SubSkillTypeDto> getAllSubSkillTypes() {
        return null;
    }
}
