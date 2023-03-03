package com.sollarisv.controledeatendimentos.repositories;


import com.sollarisv.controledeatendimentos.models.Servico;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends MongoRepository<Servico, String> {
}
