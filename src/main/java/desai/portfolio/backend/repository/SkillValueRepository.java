package desai.portfolio.backend.repository;

import desai.portfolio.backend.entity.SubSkillType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillValueRepository extends JpaRepository<SubSkillType, Long> {
}
