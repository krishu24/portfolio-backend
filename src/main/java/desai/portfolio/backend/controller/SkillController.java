package desai.portfolio.backend.controller;

import desai.portfolio.backend.dto.SkillDto;
import desai.portfolio.backend.service.SkillService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/skill")
@AllArgsConstructor
public class SkillController {

    private SkillService skillService;


    @PostMapping
    public ResponseEntity<SkillDto> addSkill(@RequestBody SkillDto skillDto){
        SkillDto savedSkill = skillService.addSkill(skillDto);

        return new ResponseEntity<>(savedSkill, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<SkillDto> getSkill(@PathVariable("id") Long SkillId){
        SkillDto skillDto = skillService.getSkill(SkillId);

        return new ResponseEntity<>(skillDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SkillDto>> getAllSkill(){
        List<SkillDto> skills = skillService.getAllSkills();

        return ResponseEntity.ok(skills);
    }

    @PutMapping("{id}")
    public ResponseEntity<SkillDto> updateSkill(@RequestBody SkillDto skillDto,
                                                @PathVariable("id") Long skillId){
        SkillDto updateSkill = skillService.updateSkill(skillDto,skillId);

        return ResponseEntity.ok(updateSkill);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSkill(@PathVariable("id") Long skillId){
        skillService.deleteSkill(skillId);

        return ResponseEntity.ok("Skill deleted successfully!");
    }
}

