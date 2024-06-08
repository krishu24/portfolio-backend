package desai.portfolio.backend.service;

import desai.portfolio.backend.dto.SiteNavigationDto;

import java.util.List;

public interface SiteNavigationService {

    SiteNavigationDto addSiteNavigation(SiteNavigationDto siteNavigationDto);

    SiteNavigationDto getSiteNavigation(Long page_id);

    List<SiteNavigationDto> getAllSiteNavigation();

    SiteNavigationDto updateSiteNavigation(SiteNavigationDto siteNavigationDto,Long page_id);

    void deleteSiteNavigation(Long page_id);

}
