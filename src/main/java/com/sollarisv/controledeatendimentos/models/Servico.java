package com.sollarisv.controledeatendimentos.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Document(collection = "servico")
public class Servico implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String nome;
    private double valor;
    private double duracaoMed;

}
