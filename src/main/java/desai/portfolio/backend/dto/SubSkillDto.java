package desai.portfolio.backend.dto;

import desai.portfolio.backend.entity.Skill;
import desai.portfolio.backend.entity.SubSkillType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SubSkillDto {

    private Long id;
    private String name;
    private Skill skill;
    private List<SubSkillType> subSkillTypes;
    private Date date;
}
