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
public class ContactDto {

    private Long c_id;
    private String address;
    private String email;
    private String github;
    private String linkedin;
    private Date c_date;
}
