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
public class FooterDto {

    private Long f_id;
    private String copyright_info;
    private String privacy_policy;
    private String terms;
    private Date f_date;
}
