package desai.portfolio.backend.service.Impl;

import desai.portfolio.backend.dto.ProjectsDto;
import desai.portfolio.backend.entity.Projects;
import desai.portfolio.backend.exception.ResourceNotFoundException;
import desai.portfolio.backend.repository.ProjectsRepository;
import desai.portfolio.backend.service.ProjectsService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProjectsServiceImpl implements ProjectsService {

    private ProjectsRepository ProjectsRepository;
    private ModelMapper modelMapper;

    @Override
    public ProjectsDto addProjects(ProjectsDto projectsDto) {
        LocalDate currentDate = LocalDate.now();
        Date now= Date.valueOf(currentDate);
        projectsDto.setDate(now);
        Projects projects = modelMapper.map(projectsDto, Projects.class);

        Projects savedProjects = ProjectsRepository.save(projects);

        ProjectsDto savedProjectsDto = modelMapper.map(savedProjects, ProjectsDto.class);

        return savedProjectsDto;
    }

    @Override
    public ProjectsDto getProjects(Long proj_id) {
        Projects projects = ProjectsRepository.findById(proj_id)
                .orElseThrow(()->
                        new ResourceNotFoundException("Projects not found with ID : "+ proj_id));
        return modelMapper.map(projects, ProjectsDto.class);
    }

    @Override
    public List<ProjectsDto> getAllProjects() {

        List<Projects> projects = ProjectsRepository.findAll();

        return projects.stream().map((project) ->
                modelMapper.map(project, ProjectsDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProjectsDto updateProjects(ProjectsDto projectsDto, Long proj_id) {
        LocalDate currentDate = LocalDate.now();
        Date now= Date.valueOf(currentDate);
        Projects projects = ProjectsRepository.findById(proj_id)
                .orElseThrow(() -> new ResourceNotFoundException("Projects not found with ID : "+ proj_id));
        projects.setProj_name(projectsDto.getProj_name());
        projects.setProj_short_description(projectsDto.getProj_short_description());
        projects.setProj_full_description(projectsDto.getProj_full_description());
        projects.setProj_link(projectsDto.getProj_link());
        projects.setDate(now);
        Projects updateProjects = ProjectsRepository.save(projects);

        return modelMapper.map(updateProjects, ProjectsDto.class);
    }

    @Override
    public void deleteProjects(Long id) {
        Projects projects = ProjectsRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Projects not found with ID : "+ id));
        ProjectsRepository.deleteById(id);

    }
}
