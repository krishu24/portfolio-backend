package desai.portfolio.backend.repository;

import desai.portfolio.backend.entity.About;
import desai.portfolio.backend.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceRepository  extends JpaRepository<Experience, Long> {
}
