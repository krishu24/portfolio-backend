package desai.portfolio.backend.service;

import desai.portfolio.backend.entity.SkillValue;

import java.util.List;

public interface SkillValueService {

    SkillValue saveValue(SkillValue value);

    SkillValue updateValue(Long id, SkillValue value);

    SkillValue getValueById(Long id);

    void deleteValue(Long id);

    List<SkillValue> getAllValues();
}