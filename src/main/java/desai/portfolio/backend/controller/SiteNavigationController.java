package desai.portfolio.backend.controller;

import desai.portfolio.backend.dto.SiteNavigationDto;
import desai.portfolio.backend.service.SiteNavigationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/site-navigation")
@AllArgsConstructor
public class SiteNavigationController {

    private SiteNavigationService siteNavigationService;

    @PostMapping
    public ResponseEntity<SiteNavigationDto> addSiteNavigation(@RequestBody SiteNavigationDto siteNavigationDto){
        SiteNavigationDto savedSiteNavigation = siteNavigationService.addSiteNavigation(siteNavigationDto);

        return new ResponseEntity<>(savedSiteNavigation, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<SiteNavigationDto> getSiteNavigation(@PathVariable("id") Long page_Id){
        SiteNavigationDto siteNavigationDto = siteNavigationService.getSiteNavigation(page_Id);

        return new ResponseEntity<>(siteNavigationDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SiteNavigationDto>> getAllSiteNavigation(){
        List<SiteNavigationDto> siteNavigation = siteNavigationService.getAllSiteNavigation();

        return ResponseEntity.ok(siteNavigation);
    }

    @PutMapping("{id}")
    public ResponseEntity<SiteNavigationDto> updateSiteNavigation(@RequestBody SiteNavigationDto siteNavigationDto,
                                                @PathVariable("id") Long page_Id){
        SiteNavigationDto updateSiteNavigation = siteNavigationService.updateSiteNavigation(siteNavigationDto,page_Id);

        return ResponseEntity.ok(updateSiteNavigation);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSiteNavigation(@PathVariable("id") Long page_Id){
        siteNavigationService.deleteSiteNavigation(page_Id);

        return ResponseEntity.ok("SiteNavigation deleted successfully!");
    }
}
