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

    private Long id;
    private String name;
    private String image;
    private String profession_description;
    private String motivation_description;
    private Date date;
}
