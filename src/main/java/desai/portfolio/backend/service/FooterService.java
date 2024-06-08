package desai.portfolio.backend.service;

import desai.portfolio.backend.dto.FooterDto;

import java.util.List;

public interface FooterService {

    FooterDto addFooter(FooterDto footerDto);

    FooterDto getFooter(Long id);

    List<FooterDto> getAllFooter();

    FooterDto updateFooter(FooterDto footerDto,Long id);

    void deleteFooter(Long id);

}
