package desai.portfolio.backend.service;

import desai.portfolio.backend.dto.ProjectsDto;

import java.util.List;

public interface ProjectsService {

    ProjectsDto addProjects(ProjectsDto ProjectsDto);

    ProjectsDto getProjects(Long proj_id);

    List<ProjectsDto> getAllProjects();

    ProjectsDto updateProjects(ProjectsDto ProjectsDto,Long proj_id);

    void deleteProjects(Long proj_id);

}
