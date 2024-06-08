package desai.portfolio.backend.service;

import desai.portfolio.backend.dto.HeaderDto;

import java.util.List;

public interface HeaderService {

    HeaderDto addHeader(HeaderDto headerDto);

    HeaderDto getHeader(Long id);

    List<HeaderDto> getAllHeader();

    HeaderDto updateHeader(HeaderDto headerDto,Long id);

    void deleteHeader(Long id);

}
