package com.sollarisv.controledeatendimentos.services;

import com.sollarisv.controledeatendimentos.dtos.ServicoDTO;
import com.sollarisv.controledeatendimentos.models.Servico;
import com.sollarisv.controledeatendimentos.repositories.ServicoRepository;
import com.sollarisv.controledeatendimentos.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService
{

    @Autowired
    private ServicoRepository servicoRepository;

    public Servico insert(Servico servico)
    {
        return servicoRepository.insert(servico);
    }

    public List<Servico> findAll()
    {
        return servicoRepository.findAll();
    }

    public Servico findById(String id)
    {
        Optional<Servico> obj = servicoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Obejto não encontrado!"));
    }

    public Servico update(Servico obj)
    {
        Servico newObj = findById(obj.getId());
        updateData(newObj, obj);
        return servicoRepository.save(newObj);
    }

    public void delete(String id){
        findById(id);
        servicoRepository.deleteById(id);
    }




    private void updateData(Servico newObj, Servico obj)
    {
        newObj.setNome(obj.getNome());
        newObj.setValor(obj.getValor());
    }

    public Servico fromDTO(ServicoDTO objDto)
    {
        return new Servico(objDto.getId(), objDto.getNome(), objDto.getValor(), objDto.getDuracaoMed());
    }
}
