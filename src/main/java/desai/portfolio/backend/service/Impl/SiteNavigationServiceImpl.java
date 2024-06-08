package desai.portfolio.backend.service.Impl;

import desai.portfolio.backend.dto.SiteNavigationDto;
import desai.portfolio.backend.entity.SiteNavigation;
import desai.portfolio.backend.exception.ResourceNotFoundException;
import desai.portfolio.backend.repository.SiteNavigationRepository;
import desai.portfolio.backend.service.SiteNavigationService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SiteNavigationServiceImpl implements SiteNavigationService {

    private SiteNavigationRepository siteNavigationRepository;

    private ModelMapper modelMapper;

    @Override
    public SiteNavigationDto addSiteNavigation(SiteNavigationDto siteNavigationDto) {
        LocalDate currentDate = LocalDate.now();
        Date now= Date.valueOf(currentDate);
        siteNavigationDto.setPage_date(now);
        SiteNavigation siteNavigation = modelMapper.map(siteNavigationDto, SiteNavigation.class);

        SiteNavigation savedSiteNavigation = siteNavigationRepository.save(siteNavigation);

        SiteNavigationDto savedSiteNavigationDto = modelMapper.map(savedSiteNavigation, SiteNavigationDto.class);

        return savedSiteNavigationDto;
    }

    @Override
    public SiteNavigationDto getSiteNavigation(Long page_id) {
        SiteNavigation siteNavigation = siteNavigationRepository.findById(page_id)
                .orElseThrow(()->
                        new ResourceNotFoundException("About not found with ID : "+ page_id));
        return modelMapper.map(siteNavigation, SiteNavigationDto.class);
    }

    @Override
    public List<SiteNavigationDto> getAllSiteNavigation() {

        List<SiteNavigation> siteNavigation = siteNavigationRepository.findAll();

        return siteNavigation.stream().map((siteNavigate) ->
                modelMapper.map(siteNavigate, SiteNavigationDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public SiteNavigationDto updateSiteNavigation(SiteNavigationDto siteNavigationDto, Long page_id) {
        LocalDate currentDate = LocalDate.now();
        Date now= Date.valueOf(currentDate);
        SiteNavigation siteNavigation = siteNavigationRepository.findById(page_id)
                .orElseThrow(() -> new ResourceNotFoundException("About not found with ID : "+ page_id));
        siteNavigation.setPage_name(siteNavigationDto.getPage_name());
        siteNavigation.setPage_link(siteNavigationDto.getPage_link());
        siteNavigation.setPage_date(now);
        SiteNavigation updateSiteNavigation = siteNavigationRepository.save(siteNavigation);

        return modelMapper.map(updateSiteNavigation, SiteNavigationDto.class);
    }

    @Override
    public void deleteSiteNavigation(Long page_id) {
        SiteNavigation siteNavigation = siteNavigationRepository.findById(page_id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("About not found with ID : "+ page_id));
        siteNavigationRepository.deleteById(page_id);

    }
}
