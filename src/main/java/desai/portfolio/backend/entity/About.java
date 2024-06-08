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
@Table(name = "about")
public class About {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long about_id;

    @Column(nullable = false)
    private String about_name;

    @Column(nullable = false)
    private String about_image;

    @Column(nullable = false)
    private String about_profession_description;

    @Column(nullable = false)
    private String about_motivation_description;

    @Column(nullable = false)
    private Date about_date;
}
