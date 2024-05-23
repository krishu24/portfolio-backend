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
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

    @OneToMany(mappedBy = "subSkill", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SubSkillType> subSkillTypes;

    @Column(nullable = false)
    private Date date;

}
