package com.sollarisv.controledeatendimentos.dtos;

import com.sollarisv.controledeatendimentos.models.Atendimento;
import com.sollarisv.controledeatendimentos.models.Cliente;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class AtendimentoDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String id;
    private Date data;
    private double valorPago;
    private double debito;
    private ClienteRefDTO cliente;
    private ServicoRefDTO servico;


    public AtendimentoDTO()
    {

    }

    public AtendimentoDTO(Atendimento obj)
    {
       id = obj.getId();
       data = obj.getData();
       valorPago =  obj.getValorPago();
       debito = getDebito();
       cliente = getCliente();
       servico = getServico();

    }
}
