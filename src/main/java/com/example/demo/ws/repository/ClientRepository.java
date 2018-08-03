package com.example.demo.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.ws.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
