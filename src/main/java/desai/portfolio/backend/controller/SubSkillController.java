package desai.portfolio.backend.controller;

import desai.portfolio.backend.dto.SubSkillDto;
import desai.portfolio.backend.service.SubSkillService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/sub-skill")
@AllArgsConstructor
public class SubSkillController {

    private SubSkillService subSkillService;


    @PostMapping
    public ResponseEntity<SubSkillDto> addSubSkill(@RequestBody SubSkillDto subSkillDto){
        SubSkillDto savedSubSkill = subSkillService.addSubSkill(subSkillDto);

        return new ResponseEntity<>(savedSubSkill, HttpStatus.CREATED);
    }

    @GetMapping("/{sub_skill_id}")
    public ResponseEntity<SubSkillDto> getSubSkill(@PathVariable("sub_skill_id") Long subSkillId){
        SubSkillDto subSkillDto = subSkillService.getSubSkill(subSkillId);

        return new ResponseEntity<>(subSkillDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SubSkillDto>> getAllSubSkills(){
        List<SubSkillDto> subSkills = subSkillService.getAllSubSkills();

        return ResponseEntity.ok(subSkills);
    }

    @PutMapping("/{sub_skill_id}")
    public ResponseEntity<SubSkillDto> updateSubSkill(@RequestBody SubSkillDto subSkillDto,
                                                @PathVariable("sub_skill_id") Long subSkillId){
        SubSkillDto updateSkill = subSkillService.updateSubSkill(subSkillDto,subSkillId);

        return ResponseEntity.ok(updateSkill);
    }

    @DeleteMapping("/{sub_skill_id}")
    public ResponseEntity<String> deleteSubSkill(@PathVariable("sub_skill_id") Long subSkillId){
        subSkillService.deleteSubSkill(subSkillId);

        return ResponseEntity.ok("SubSkill deleted successfully!");
    }
}

