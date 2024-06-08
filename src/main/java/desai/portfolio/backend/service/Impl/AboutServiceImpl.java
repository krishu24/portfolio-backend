package desai.portfolio.backend.service.Impl;

import desai.portfolio.backend.dto.AboutDto;
import desai.portfolio.backend.entity.About;
import desai.portfolio.backend.exception.ResourceNotFoundException;
import desai.portfolio.backend.repository.AboutRepository;
import desai.portfolio.backend.service.AboutService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AboutServiceImpl implements AboutService {

    private AboutRepository aboutRepository;

    private ModelMapper modelMapper;

    @Override
    public AboutDto addAbout(AboutDto aboutDto) {
        LocalDate currentDate = LocalDate.now();
        Date now= Date.valueOf(currentDate);
        aboutDto.setAbout_date(now);
        About about = modelMapper.map(aboutDto, About.class);

        About savedAbout = aboutRepository.save(about);

        AboutDto savedAboutDto = modelMapper.map(savedAbout, AboutDto.class);

        return savedAboutDto;
    }

    @Override
    public AboutDto getAbout(Long id) {
        About about = aboutRepository.findById(id)
                .orElseThrow(()->
                        new ResourceNotFoundException("About not found with ID : "+ id));
        return modelMapper.map(about, AboutDto.class);
    }

    @Override
    public List<AboutDto> getAllAbout() {

        List<About> abouts = aboutRepository.findAll();

        return abouts.stream().map((about) ->
                modelMapper.map(about, AboutDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public AboutDto updateAbout(AboutDto aboutDto, Long id) {
        LocalDate currentDate = LocalDate.now();
        Date now= Date.valueOf(currentDate);
        About about = aboutRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("About not found with ID : "+ id));
        about.setAbout_name(aboutDto.getAbout_name());
        about.setAbout_image(aboutDto.getAbout_image());
        about.setAbout_profession_description(aboutDto.getAbout_profession_description());
        about.setAbout_motivation_description(aboutDto.getAbout_motivation_description());
        about.setAbout_date(now);
        About updateAbout = aboutRepository.save(about);

        return modelMapper.map(updateAbout, AboutDto.class);
    }

    @Override
    public void deleteAbout(Long id) {
        About about = aboutRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("About not found with ID : "+ id));
        aboutRepository.deleteById(id);

    }
}
