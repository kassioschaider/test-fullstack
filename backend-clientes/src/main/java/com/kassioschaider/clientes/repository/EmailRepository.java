package com.kassioschaider.clientes.repository;

import com.kassioschaider.clientes.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {}
