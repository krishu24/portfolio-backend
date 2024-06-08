package desai.portfolio.backend.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SubSkillDto {

    private Long sub_skill_id;
    private String sub_skill_name;
    private String sub_skill_logo;
    private String sub_skill_link;
    private Date sub_skill_date;
}
