package desai.portfolio.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "projects")
public class Projects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long proj_id;

    @Column(nullable = false)
    private String proj_name;

    @Column(nullable = false)
    private String proj_short_description;

    @Column(nullable = false)
    private String proj_full_description;

    @Column(nullable = false)
    private String proj_link;

    @Column(nullable = false)
    private Date date;
}
