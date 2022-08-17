package com.MonikaIT.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MonikaIT.Entity.Contact;

public interface ContactRepository extends JpaRepository<Contact,Integer>  {

}
