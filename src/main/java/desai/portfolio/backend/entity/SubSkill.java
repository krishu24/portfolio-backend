package desai.portfolio.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sub_skill")
public class SubSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sub_skill_id;

    @Column(nullable = false)
    private String sub_skill_name;

    @Column(nullable = false)
    private String sub_skill_logo;

    @Column(nullable = false)
    private String sub_skill_link;

    @Column(nullable = false)
    private Date sub_skill_date;

}
