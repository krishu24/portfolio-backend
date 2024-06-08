package desai.portfolio.backend.service;

import desai.portfolio.backend.dto.ContactDto;

import java.util.List;

public interface ContactService {

    ContactDto addContact(ContactDto contactDto);

    ContactDto getContact(Long cid);

    List<ContactDto> getAllContact();

    ContactDto updateContact(ContactDto contactDto,Long cid);

    void deleteContact(Long id);

}
