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
@Table(name = "site_navigation")
public class SiteNavigation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long page_id;

    @Column(nullable = false)
    private String page_name;

    @Column(nullable = false)
    private String page_link;

    @Column(nullable = false)
    private Date page_date;
}
