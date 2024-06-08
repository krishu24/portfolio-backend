package desai.portfolio.backend.controller;

import desai.portfolio.backend.dto.ContactDto;
import desai.portfolio.backend.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/contact")
@AllArgsConstructor
public class ContactController {

    private ContactService ContactService;

    @PostMapping
    public ResponseEntity<ContactDto> addContact(@RequestBody ContactDto contactDto){
        ContactDto savedContact = ContactService.addContact(contactDto);

        return new ResponseEntity<>(savedContact, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ContactDto> getContact(@PathVariable("id") Long c_id){
        ContactDto contactDto = ContactService.getContact(c_id);

        return new ResponseEntity<>(contactDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ContactDto>> getAllContact(){
        List<ContactDto> contacts = ContactService.getAllContact();

        return ResponseEntity.ok(contacts);
    }

    @PutMapping("{id}")
    public ResponseEntity<ContactDto> updateContact(@RequestBody ContactDto contactDto,
                                                @PathVariable("id") Long c_id){
        ContactDto updateContact = ContactService.updateContact(contactDto,c_id);

        return ResponseEntity.ok(updateContact);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteContact(@PathVariable("id") Long c_id){
        ContactService.deleteContact(c_id);

        return ResponseEntity.ok("Contact deleted successfully!");
    }
}
