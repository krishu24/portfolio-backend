package desai.portfolio.backend.service.Impl;

import desai.portfolio.backend.dto.FooterDto;
import desai.portfolio.backend.entity.Footer;
import desai.portfolio.backend.exception.ResourceNotFoundException;
import desai.portfolio.backend.repository.FooterRepository;
import desai.portfolio.backend.service.FooterService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FooterServiceImpl implements FooterService {

    private FooterRepository footerRepository;

    private ModelMapper modelMapper;

    @Override
    public FooterDto addFooter(FooterDto footerDto) {
        LocalDate currentDate = LocalDate.now();
        Date now= Date.valueOf(currentDate);
        footerDto.setF_date(now);
        Footer footer = modelMapper.map(footerDto, Footer.class);

        Footer savedFooter = footerRepository.save(footer);

        FooterDto savedFooterDto = modelMapper.map(savedFooter, FooterDto.class);

        return savedFooterDto;
    }

    @Override
    public FooterDto getFooter(Long h_id) {
        Footer footer = footerRepository.findById(h_id)
                .orElseThrow(()->
                        new ResourceNotFoundException("About not found with ID : "+ h_id));
        return modelMapper.map(footer, FooterDto.class);
    }

    @Override
    public List<FooterDto> getAllFooter() {

        List<Footer> abouts = footerRepository.findAll();

        return abouts.stream().map((header) ->
                modelMapper.map(header, FooterDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public FooterDto updateFooter(FooterDto footerDto, Long h_id) {
        LocalDate currentDate = LocalDate.now();
        Date now= Date.valueOf(currentDate);
        Footer footer = footerRepository.findById(h_id)
                .orElseThrow(() -> new ResourceNotFoundException("About not found with ID : "+ h_id));
        footer.setCopyright_info(footerDto.getCopyright_info());
        footer.setPrivacy_policy(footerDto.getPrivacy_policy());
        footer.setTerms(footerDto.getTerms());
        footer.setF_date(now);
        Footer updateFooter = footerRepository.save(footer);

        return modelMapper.map(updateFooter, FooterDto.class);
    }

    @Override
    public void deleteFooter(Long f_id) {
        Footer footer = footerRepository.findById(f_id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("About not found with ID : "+ f_id));
        footerRepository.deleteById(f_id);

    }
}
