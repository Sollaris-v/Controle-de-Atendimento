package com.sollarisv.controledeatendimentos.dtos;

import com.sollarisv.controledeatendimentos.models.Cliente;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ClienteRefDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String id;
    private String nome;

    public ClienteRefDTO(Cliente obj)
    {
        id = obj.getId();
        nome = obj.getNome();
    }
}
