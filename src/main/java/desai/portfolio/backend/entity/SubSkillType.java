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
@Table(name = "sub_skill_type")
public class SubSkillType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sub_skill_type_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Date date;
}
