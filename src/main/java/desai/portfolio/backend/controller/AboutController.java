package desai.portfolio.backend.controller;

import desai.portfolio.backend.dto.AboutDto;
import desai.portfolio.backend.service.AboutService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/about")
@AllArgsConstructor
public class AboutController {

    private AboutService aboutService;

    @PostMapping
    public ResponseEntity<AboutDto> addAbout(@RequestBody AboutDto aboutDto){
        AboutDto savedAbout = aboutService.addAbout(aboutDto);

        return new ResponseEntity<>(savedAbout, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<AboutDto> getAbout(@PathVariable("id") Long aboutId){
        AboutDto aboutDto = aboutService.getAbout(aboutId);

        return new ResponseEntity<>(aboutDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AboutDto>> getAllAbout(){
        List<AboutDto> abouts = aboutService.getAllAbout();

        return ResponseEntity.ok(abouts);
    }

    @PutMapping("{id}")
    public ResponseEntity<AboutDto> updateAbout(@RequestBody AboutDto aboutDto,
                                                @PathVariable("id") Long aboutId){
        AboutDto updateAbout = aboutService.updateAbout(aboutDto,aboutId);

        return ResponseEntity.ok(updateAbout);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAbout(@PathVariable("id") Long aboutId){
        aboutService.deleteAbout(aboutId);

        return ResponseEntity.ok("Todo deleted successfully!");
    }
}
