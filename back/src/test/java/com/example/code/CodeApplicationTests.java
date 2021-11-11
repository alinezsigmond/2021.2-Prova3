package com.example.code;

import com.example.code.controller.ContactController;
import com.example.code.exceptions.ResourceAlreadyExistsException;
import com.example.code.models.Contact;
import com.example.code.repository.ContactRepository;
import com.example.code.service.ContactService;
import com.example.code.util.ContactCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class CodeApplicationTests {

    @InjectMocks
    private ContactService service;

    @Mock
    private ContactRepository repository;

    @BeforeEach
    void setUp() {
        when(repository.save(ArgumentMatchers.isA(Contact.class)))
                .thenReturn(ContactCreator.createContact());
    }

    @Test
    void shouldNotSaveDouble() {
        when(repository.findByPhone(ArgumentMatchers.anyString()))
                .thenReturn(Optional.of(ContactCreator.createContact()));

        Assertions.assertThatExceptionOfType(ResourceAlreadyExistsException.class)
                .isThrownBy(() -> service.create(ContactCreator.createContact()));
    }

    @Test
    public void shouldCreateContact() throws Exception {
        Contact createdContact = service.create(ContactCreator.createContact());

        assertThat(createdContact).isNotNull();
        assertThat("Sidney Magal").isEqualTo(createdContact.getName());
        assertThat("amantelatino@hotmail.com").isEqualTo(createdContact.getEmail());
        assertThat("69 999 666 999").isEqualTo(createdContact.getPhone());
    }
}
