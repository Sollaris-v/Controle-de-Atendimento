package com.sollarisv.controledeatendimentos.models;

import com.sollarisv.controledeatendimentos.dtos.ClienteRefDTO;
import com.sollarisv.controledeatendimentos.dtos.ServicoRefDTO;
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
    private ClienteRefDTO cliente;
    private ServicoRefDTO servico;
    //serviços



}
