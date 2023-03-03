package com.sollarisv.controledeatendimentos.repositories;

import com.sollarisv.controledeatendimentos.models.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String> {
}
