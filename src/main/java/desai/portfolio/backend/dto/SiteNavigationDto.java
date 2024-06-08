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
public class SiteNavigationDto {

    private Long page_id;
    private String page_name;
    private String page_link;
    private Date page_date;
}
