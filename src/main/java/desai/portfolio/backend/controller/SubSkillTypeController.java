package desai.portfolio.backend.controller;

import desai.portfolio.backend.dto.SubSkillTypeDto;
import desai.portfolio.backend.service.SubSkillTypeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/sub-skill-type")
@AllArgsConstructor
public class SubSkillTypeController {

    private SubSkillTypeService subSkillTypeService;


    @PostMapping
    public ResponseEntity<SubSkillTypeDto> addSubSkillType(@RequestBody SubSkillTypeDto subSkillTypeDto){
        SubSkillTypeDto savedSubSkillType = subSkillTypeService.addSubSkillType(subSkillTypeDto);

        return new ResponseEntity<>(savedSubSkillType, HttpStatus.CREATED);
    }

    @GetMapping("/{sub_skill_type_id}")
    public ResponseEntity<SubSkillTypeDto> getSubSkillType(@PathVariable("sub_skill_type_id") Long subSkillTypeId){
        SubSkillTypeDto subSkillTypeDto = subSkillTypeService.getSubSkillType(subSkillTypeId);

        return new ResponseEntity<>(subSkillTypeDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SubSkillTypeDto>> getAllSubSkillTypes(){
        List<SubSkillTypeDto> subSkillTypes = subSkillTypeService.getAllSubSkillTypes();

        return ResponseEntity.ok(subSkillTypes);
    }

    @PutMapping("/{sub_skill_type_id}")
    public ResponseEntity<SubSkillTypeDto> updateSubSkillType(@RequestBody SubSkillTypeDto subSkillTypeDto,
                                                @PathVariable("sub_skill_type_id") Long subSkillTypeId){
        SubSkillTypeDto updateSubSkillType = subSkillTypeService.updateSubSkillType(subSkillTypeDto,subSkillTypeId);

        return ResponseEntity.ok(updateSubSkillType);
    }

    @DeleteMapping("/{sub_skill_type_id}")
    public ResponseEntity<String> deleteSubSkillType(@PathVariable("sub_skill_type_id") Long subSkillTypeId){
        subSkillTypeService.deleteSubSkillType(subSkillTypeId);

        return ResponseEntity.ok("Sub Skill deleted successfully!");
    }
}
