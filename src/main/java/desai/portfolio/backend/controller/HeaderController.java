package desai.portfolio.backend.controller;

import desai.portfolio.backend.dto.HeaderDto;
import desai.portfolio.backend.service.HeaderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/header")
@AllArgsConstructor
public class HeaderController {

    private HeaderService headerService;

    @PostMapping
    public ResponseEntity<HeaderDto> addHeader(@RequestBody HeaderDto headerDto){
        HeaderDto savedHeader = headerService.addHeader(headerDto);

        return new ResponseEntity<>(savedHeader, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<HeaderDto> getHeader(@PathVariable("id") Long headerId){
        HeaderDto headerDto = headerService.getHeader(headerId);

        return new ResponseEntity<>(headerDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<HeaderDto>> getAllHeader(){
        List<HeaderDto> header = headerService.getAllHeader();

        return ResponseEntity.ok(header);
    }

    @PutMapping("{id}")
    public ResponseEntity<HeaderDto> updateHeader(@RequestBody HeaderDto headerDto,
                                                @PathVariable("id") Long headerId){
        HeaderDto updateHeader = headerService.updateHeader(headerDto,headerId);

        return ResponseEntity.ok(updateHeader);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteHeader(@PathVariable("id") Long headerId){
        headerService.deleteHeader(headerId);

        return ResponseEntity.ok("About deleted successfully!");
    }
}
