package com.sollarisv.controledeatendimentos.dtos;

import com.sollarisv.controledeatendimentos.models.Servico;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class ServicoDTO implements Serializable
{
    private static final long serialVersionUID = 1L;


    private String id;
    private String nome;
    private double valor;
    private double duracaoMed;

    public ServicoDTO(Servico obj){
        id = obj.getId();
        nome = obj.getNome();
        valor = obj.getValor();
        duracaoMed = obj.getDuracaoMed();
    }


}
