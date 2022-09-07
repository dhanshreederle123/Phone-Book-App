package com.MonikaIT.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MonikaIT.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
