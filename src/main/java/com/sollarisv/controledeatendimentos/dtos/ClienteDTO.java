package com.sollarisv.controledeatendimentos.dtos;

import com.sollarisv.controledeatendimentos.models.Cliente;
import lombok.Data;

import java.io.Serializable;

@Data
public class ClienteDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String id;
    private String nome;
    private String telefone;
    private String email;
    private double debitoTotal;

    public ClienteDTO()
    {

    }

    public ClienteDTO(Cliente obj)
    {
       id = obj.getId();
       nome = obj.getNome();
       telefone = obj.getTelefone();
       email = obj.getEmail();
       debitoTotal = obj.getDebitoTotal();
    }
}
