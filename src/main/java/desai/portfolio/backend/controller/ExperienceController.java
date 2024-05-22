package desai.portfolio.backend.controller;

import desai.portfolio.backend.dto.AboutDto;
import desai.portfolio.backend.dto.ExperienceDto;
import desai.portfolio.backend.service.ExperienceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/experience")
@AllArgsConstructor
public class ExperienceController {

    private ExperienceService experienceService;
    @PostMapping
    public ResponseEntity<ExperienceDto> addExperience(@RequestBody ExperienceDto experienceDto) {
        ExperienceDto savedExperience = experienceService.addExperience(experienceDto);

        return new ResponseEntity<>(savedExperience, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ExperienceDto> getExperience(@PathVariable("id") Long exp_id){
        ExperienceDto experienceDto = experienceService.getExperience(exp_id);

        return new ResponseEntity<>(experienceDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ExperienceDto>> getAllExperience() {
        List<ExperienceDto> experiences = experienceService.getAllExperience();

        return ResponseEntity.ok(experiences);
    }
    @PutMapping
    public ResponseEntity<ExperienceDto> updateExperience(@RequestBody ExperienceDto experienceDto,
                                                          @PathVariable("id") Long exp_id){
        ExperienceDto updateExperience = experienceService.updateExperience(experienceDto, exp_id);

        return ResponseEntity.ok(updateExperience);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteExperience(@PathVariable("id") Long exp_id) {
        experienceService.deleteExperience(exp_id);

        return ResponseEntity.ok("Experience deleted successfully!");
    }
}
