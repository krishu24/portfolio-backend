package desai.portfolio.backend.controller;

import desai.portfolio.backend.dto.ProjectsDto;
import desai.portfolio.backend.service.ProjectsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/projects")
@AllArgsConstructor
public class ProjectsController {

    private ProjectsService ProjectsService;

    @PostMapping
    public ResponseEntity<ProjectsDto> addProjects(@RequestBody ProjectsDto ProjectsDto){
        ProjectsDto savedProjects = ProjectsService.addProjects(ProjectsDto);

        return new ResponseEntity<>(savedProjects, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProjectsDto> getProjects(@PathVariable("id") Long proj_id){
        ProjectsDto ProjectsDto = ProjectsService.getProjects(proj_id);

        return new ResponseEntity<>(ProjectsDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProjectsDto>> getAllProjects(){
        List<ProjectsDto> projects = ProjectsService.getAllProjects();

        return ResponseEntity.ok(projects);
    }

    @PutMapping("{id}")
    public ResponseEntity<ProjectsDto> updateProjects(@RequestBody ProjectsDto ProjectsDto,
                                                @PathVariable("id") Long proj_id){
        ProjectsDto updateProjects = ProjectsService.updateProjects(ProjectsDto, proj_id);

        return ResponseEntity.ok(updateProjects);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProjects(@PathVariable("id") Long proj_id){
        ProjectsService.deleteProjects(proj_id);

        return ResponseEntity.ok("Project deleted successfully!");
    }
}
