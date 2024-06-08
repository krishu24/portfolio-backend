package desai.portfolio.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectsDto {

    private Long proj_id;
    private String proj_name;
    private String proj_short_description;
    private String proj_full_description;
    private String proj_link;
    private Date date;
}
