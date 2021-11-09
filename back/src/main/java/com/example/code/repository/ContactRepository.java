package com.example.code.repository;

import com.example.code.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    Optional<Contact> findByEmailIgnoreCase(String email);
    Optional<Contact> findByPhone(String phone);
}
