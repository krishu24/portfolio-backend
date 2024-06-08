package desai.portfolio.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "footer")
public class Footer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long f_id;

    @Column(nullable = false)
    private String copyright_info;

    @Column(nullable = false)
    private String privacy_policy;

    @Column(nullable = false)
    private String terms;

    @Column(nullable = false)
    private Date f_date;
}
