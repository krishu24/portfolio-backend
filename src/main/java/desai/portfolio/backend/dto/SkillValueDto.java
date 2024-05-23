package desai.portfolio.backend.dto;

import desai.portfolio.backend.entity.SubSkillType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SkillValueDto {

    private Long id;
    private String value;
    private SubSkillType subSkillType;
    private Date date;
}
