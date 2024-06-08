package desai.portfolio.backend.repository;

import desai.portfolio.backend.entity.About;
import desai.portfolio.backend.entity.Projects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectsRepository extends JpaRepository<Projects, Long> {

}
