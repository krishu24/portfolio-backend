package desai.portfolio.backend.service.Impl;

import desai.portfolio.backend.dto.ContactDto;
import desai.portfolio.backend.entity.Contact;
import desai.portfolio.backend.exception.ResourceNotFoundException;
import desai.portfolio.backend.repository.ContactRepository;
import desai.portfolio.backend.service.ContactService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ContactServiceImpl implements ContactService {

    private ContactRepository ContactRepository;
    private ModelMapper modelMapper;

    @Override
    public ContactDto addContact(ContactDto contactDto) {
        LocalDate currentDate = LocalDate.now();
        Date now= Date.valueOf(currentDate);
        contactDto.setC_date(now);
        Contact contact = modelMapper.map(contactDto, Contact.class);

        Contact savedContact = ContactRepository.save(contact);

        ContactDto savedContactDto = modelMapper.map(savedContact, ContactDto.class);

        return savedContactDto;
    }

    @Override
    public ContactDto getContact(Long cid) {
        Contact contact = ContactRepository.findById(cid)
                .orElseThrow(()->
                        new ResourceNotFoundException("Contact not found with ID : "+ cid));
        return modelMapper.map(contact, ContactDto.class);
    }

    @Override
    public List<ContactDto> getAllContact() {

        List<Contact> contacts = ContactRepository.findAll();

        return contacts.stream().map((cont) ->
                modelMapper.map(cont, ContactDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ContactDto updateContact(ContactDto ContactDto, Long cid) {
        LocalDate currentDate = LocalDate.now();
        Date now= Date.valueOf(currentDate);
        Contact contact = ContactRepository.findById(cid)
                .orElseThrow(() -> new ResourceNotFoundException("Contact not found with ID : "+ cid));
        contact.setAddress(ContactDto.getAddress());
        contact.setEmail(ContactDto.getEmail());
        contact.setGithub(ContactDto.getGithub());
        contact.setLinkedin(ContactDto.getLinkedin());
        contact.setC_date(now);
        Contact updateContact = ContactRepository.save(contact);

        return modelMapper.map(updateContact, ContactDto.class);
    }

    @Override
    public void deleteContact(Long cid) {
        Contact contact = ContactRepository.findById(cid)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Contact not found with ID : "+ cid));
        ContactRepository.deleteById(cid);

    }
}
