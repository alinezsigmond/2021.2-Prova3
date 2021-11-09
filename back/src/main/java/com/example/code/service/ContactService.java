package com.example.code.service;

import com.example.code.models.Contact;
import com.example.code.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    private final ContactRepository repository;

    @Autowired
    public ContactService(ContactRepository repository) {
        this.repository = repository;
    }

    public Contact create(Contact contact) {
        Optional<Contact> emailFound = repository.findByEmailIgnoreCase(contact.getEmail());
        Optional<Contact> phoneFound = repository.findByPhone(contact.getPhone());

        if (emailFound.isPresent() || phoneFound.isPresent()) {
            throw new RuntimeException("Contato já cadastrado");
        } else {
            return repository.save(contact);
        }
    }

    public List<Contact> findAll() {
        return repository.findAll();
    }

    public Contact findById(Long id) {
        Optional<Contact> found = repository.findById(id);

        if(found.isPresent()) return found.get();
        else return null;
    }

    public Contact update(Contact contact) {
        return repository.save(contact);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
