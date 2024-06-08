package desai.portfolio.backend.controller;

import desai.portfolio.backend.dto.FooterDto;
import desai.portfolio.backend.service.FooterService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/footer")
@AllArgsConstructor
public class FooterController {

    private FooterService footerService;

    @PostMapping
    public ResponseEntity<FooterDto> addFooter(@RequestBody FooterDto footerDto){
        FooterDto savedFooter = footerService.addFooter(footerDto);

        return new ResponseEntity<>(savedFooter, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<FooterDto> getFooter(@PathVariable("id") Long f_Id){
        FooterDto footerDto = footerService.getFooter(f_Id);

        return new ResponseEntity<>(footerDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<FooterDto>> getAllFooter(){
        List<FooterDto> footer = footerService.getAllFooter();

        return ResponseEntity.ok(footer);
    }

    @PutMapping("{id}")
    public ResponseEntity<FooterDto> updateFooter(@RequestBody FooterDto footerDto,
                                                @PathVariable("id") Long f_Id){
        FooterDto updateFooter = footerService.updateFooter(footerDto,f_Id);

        return ResponseEntity.ok(updateFooter);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteFooter(@PathVariable("id") Long f_Id){
        footerService.deleteFooter(f_Id);

        return ResponseEntity.ok("About deleted successfully!");
    }
}
