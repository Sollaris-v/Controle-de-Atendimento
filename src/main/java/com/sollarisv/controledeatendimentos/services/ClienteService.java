package com.sollarisv.controledeatendimentos.services;

import com.sollarisv.controledeatendimentos.dtos.ClienteDTO;
import com.sollarisv.controledeatendimentos.models.Cliente;
import com.sollarisv.controledeatendimentos.repositories.ClienteRepository;
import com.sollarisv.controledeatendimentos.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService
{

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente insert(Cliente cliente)
    {
        return clienteRepository.insert(cliente);
    }

    public List<Cliente> findAll()
    {
        return clienteRepository.findAll();
    }

    public Cliente findById(String id)
    {
        Optional<Cliente> obj = clienteRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Obejto não encontrado!"));
    }

    public Cliente update(Cliente obj)
    {
        Cliente newObj = findById(obj.getId());
        updateData(newObj, obj);
        return clienteRepository.save(newObj);
    }

    public void delete(String id){
        findById(id);
        clienteRepository.deleteById(id);
    }




    private void updateData(Cliente newObj, Cliente obj)
    {
        newObj.setNome(obj.getNome());
        newObj.setTelefone(obj.getTelefone());
        newObj.setEmail(obj.getEmail());
        newObj.setDebitoTotal(obj.getDebitoTotal());
    }

    public Cliente fromDTO(ClienteDTO objDto)
    {
        return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), objDto.getTelefone(), objDto.getDebitoTotal());
    }
}
