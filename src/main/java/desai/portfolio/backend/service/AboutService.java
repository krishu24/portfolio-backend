package desai.portfolio.backend.service;

import desai.portfolio.backend.dto.AboutDto;

import java.util.List;

public interface AboutService {

    AboutDto addAbout(AboutDto aboutDto);

    AboutDto getAbout(Long id);

    List<AboutDto> getAllAbout();

    AboutDto updateAbout(AboutDto aboutDto,Long id);

    void deleteAbout(Long id);

}
