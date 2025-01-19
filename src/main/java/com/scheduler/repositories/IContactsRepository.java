package com.scheduler.repositories;

import com.scheduler.models.entities.Contact;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContactsRepository extends JpaRepository<Contact, Integer > {
  
  Optional<Contact> getContactsById(int contactId);
  
}
