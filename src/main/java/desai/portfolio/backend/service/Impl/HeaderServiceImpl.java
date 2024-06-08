package desai.portfolio.backend.service.Impl;

import desai.portfolio.backend.dto.HeaderDto;
import desai.portfolio.backend.entity.Header;
import desai.portfolio.backend.exception.ResourceNotFoundException;
import desai.portfolio.backend.repository.HeaderRepository;
import desai.portfolio.backend.service.HeaderService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HeaderServiceImpl implements HeaderService {

    private HeaderRepository headerRepository;

    private ModelMapper modelMapper;

    @Override
    public HeaderDto addHeader(HeaderDto headerDto) {
        LocalDate currentDate = LocalDate.now();
        Date now= Date.valueOf(currentDate);
        headerDto.setH_date(now);
        Header header = modelMapper.map(headerDto, Header.class);

        Header savedHeader = headerRepository.save(header);

        HeaderDto savedHeaderDto = modelMapper.map(savedHeader, HeaderDto.class);

        return savedHeaderDto;
    }

    @Override
    public HeaderDto getHeader(Long h_id) {
        Header header = headerRepository.findById(h_id)
                .orElseThrow(()->
                        new ResourceNotFoundException("About not found with ID : "+ h_id));
        return modelMapper.map(header, HeaderDto.class);
    }

    @Override
    public List<HeaderDto> getAllHeader() {

        List<Header> abouts = headerRepository.findAll();

        return abouts.stream().map((header) ->
                modelMapper.map(header, HeaderDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public HeaderDto updateHeader(HeaderDto headerDto, Long h_id) {
        LocalDate currentDate = LocalDate.now();
        Date now= Date.valueOf(currentDate);
        Header header = headerRepository.findById(h_id)
                .orElseThrow(() -> new ResourceNotFoundException("About not found with ID : "+ h_id));
        header.setLogo(headerDto.getLogo());
        header.setH_date(now);
        Header updateHeader = headerRepository.save(header);

        return modelMapper.map(updateHeader, HeaderDto.class);
    }

    @Override
    public void deleteHeader(Long id) {
        Header header = headerRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("About not found with ID : "+ id));
        headerRepository.deleteById(id);

    }
}
