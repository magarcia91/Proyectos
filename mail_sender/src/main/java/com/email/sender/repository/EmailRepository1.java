package com.email.sender.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.email.sender.model.Email1;

@Repository
public interface EmailRepository1 extends JpaRepository<Email1, Long> {

}
