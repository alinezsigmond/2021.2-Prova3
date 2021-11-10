package com.example.code.util;

import com.example.code.models.Contact;
import org.springframework.stereotype.Component;

@Component
public class ContactCreator {

    public static Contact createContact() {
        return new Contact("Sidney Magal", "amantelatino@hotmail.com", "69 999 666 999");
    }
}
