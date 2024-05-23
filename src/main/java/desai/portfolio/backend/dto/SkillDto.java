package desai.portfolio.backend.dto;

import desai.portfolio.backend.entity.SubSkill;
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
public class SkillDto {

    private Long id;
    private String name;
    private List<SubSkill> subSkills;
    private Date date;
}
