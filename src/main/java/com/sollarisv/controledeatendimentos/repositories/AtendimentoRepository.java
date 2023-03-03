package com.sollarisv.controledeatendimentos.repositories;

import com.sollarisv.controledeatendimentos.models.Atendimento;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtendimentoRepository extends MongoRepository<Atendimento, String> {
}
