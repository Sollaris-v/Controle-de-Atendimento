package com.sollarisv.controledeatendimentos.services;

import com.sollarisv.controledeatendimentos.dtos.AtendimentoDTO;
import com.sollarisv.controledeatendimentos.models.Atendimento;
import com.sollarisv.controledeatendimentos.repositories.AtendimentoRepository;
import com.sollarisv.controledeatendimentos.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtendimentoService
{

    @Autowired
    private AtendimentoRepository atendimentoRepository;

    public Atendimento insert(Atendimento atendimento)
    {
        return atendimentoRepository.insert(atendimento);
    }

    public List<Atendimento> findAll()
    {
        return atendimentoRepository.findAll();
    }

    public Atendimento findById(String id)
    {
        Optional<Atendimento> obj = atendimentoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Obejto não encontrado!"));
    }

    public Atendimento update(Atendimento obj)
    {
        Atendimento newObj = findById(obj.getId());
        updateData(newObj, obj);
        return atendimentoRepository.save(newObj);
    }

    public void delete(String id){
        findById(id);
        atendimentoRepository.deleteById(id);
    }




    private void updateData(Atendimento newObj, Atendimento obj)
    {
        newObj.setData(obj.getData());
        newObj.setValorPago(obj.getValorPago());
        newObj.setDebito(obj.getDebito());
        newObj.setCliente(obj.getCliente());
        newObj.setServico(obj.getServico());
    }

    public Atendimento fromDTO(AtendimentoDTO objDto)
    {
        return new Atendimento(objDto.getId(), objDto.getData(), objDto.getValorPago(), objDto.getDebito(), objDto.getCliente(), objDto.getServico());
    }
}
