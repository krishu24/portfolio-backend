package desai.portfolio.backend.controller;

import desai.portfolio.backend.dto.SkillValueDto;
import desai.portfolio.backend.service.SkillValueService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/skill-value")
@AllArgsConstructor
public class SkillValueController {

    private SkillValueService skillValueService;


    @PostMapping
    public ResponseEntity<SkillValueDto> addSkillValue(@RequestBody SkillValueDto skillValueDto){
        SkillValueDto savedSkillValue = skillValueService.addSkillValue(skillValueDto);

        return new ResponseEntity<>(savedSkillValue, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkillValueDto> getSkillValue(@PathVariable("id") Long SkillValueId){
        SkillValueDto skillValueDto = skillValueService.getSkillValue(SkillValueId);

        return new ResponseEntity<>(skillValueDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SkillValueDto>> getAllSkillValue(){
        List<SkillValueDto> skillValues = skillValueService.getAllSkillValues();

        return ResponseEntity.ok(skillValues);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SkillValueDto> updateSkillValue(@RequestBody SkillValueDto skillValueDto,
                                                @PathVariable("id") Long skillValueId){
        SkillValueDto updateSkillValue = skillValueService.updateSkillValue(skillValueDto,skillValueId);

        return ResponseEntity.ok(updateSkillValue);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSkillValue(@PathVariable("id") Long skillValueId){
        skillValueService.deleteSkillValue(skillValueId);

        return ResponseEntity.ok("SkillValue deleted successfully!");
    }
}
