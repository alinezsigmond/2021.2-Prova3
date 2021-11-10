package com.example.code.controller;

import com.example.code.models.Contact;
import com.example.code.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/contatos")
public class ContactController {
    private final ContactService service;

    @Autowired
    public ContactController(ContactService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> createEspecie(@RequestBody Contact contact) throws Exception {
        try{
            Contact saved = service.create(contact);
            return new ResponseEntity<>(saved, null, HttpStatus.CREATED);

        }
        catch(Exception ex){
            throw new Exception(ex);
        }
    }

    @GetMapping
    public ResponseEntity<?> findAll() throws Exception{
        try{
            List<Contact> found = service.findAll();
            if(!found.isEmpty()){
                return new ResponseEntity<>(found, null, HttpStatus.OK);
            } else return new ResponseEntity<>(found, null, HttpStatus.NO_CONTENT);
        }
        catch(Exception ex){
            throw new Exception(ex);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) throws Exception {
        try{
            Contact found = service.findById(id);
            if(found != null) return new ResponseEntity<>(found, null, HttpStatus.OK);
            else return new ResponseEntity<>( null, null, HttpStatus.NOT_FOUND);
        }
        catch(Exception ex){
            throw new Exception(ex);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Contact contact) throws Exception {
        try{
            if(service.findById(id) != null) {
                contact.setId(id);
                return new ResponseEntity<>( service.update(contact), null, HttpStatus.OK);
            } else return new ResponseEntity<>( null, null, HttpStatus.NOT_FOUND);

        }
        catch(Exception ex){
            throw new Exception(ex);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
        try{
            if(service.findById(id) != null) {
                service.delete(id);
                return new ResponseEntity<>(null, null, HttpStatus.OK);
            } else return new ResponseEntity<>( null, null, HttpStatus.NOT_FOUND);
        }
        catch(Exception ex){
            throw new Exception(ex);
        }
    }
}
