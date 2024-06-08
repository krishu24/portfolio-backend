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
public class AboutDto {

    private Long about_id;
    private String about_name;
    private String about_image;
    private String about_profession_description;
    private String about_motivation_description;
    private Date about_date;
}
