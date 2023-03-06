package com.sollarisv.controledeatendimentos.dtos;


import com.sollarisv.controledeatendimentos.models.Servico;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ServicoRefDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String id;
    private String nome;
    private double valor;

    public ServicoRefDTO(Servico obj)
    {
        id = obj.getId();
        nome = obj.getNome();
        valor = obj.getValor();
    }
}
