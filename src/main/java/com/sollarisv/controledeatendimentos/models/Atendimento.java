package com.sollarisv.controledeatendimentos.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;


@Data
@AllArgsConstructor
@Document(collection = "atendimento")
public class Atendimento implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private Date data;
    private double valorPago;
    private double debito;
    //cliente
    //serviços



}
