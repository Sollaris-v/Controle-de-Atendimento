package com.sollarisv.controledeatendimentos.controllers;


import com.sollarisv.controledeatendimentos.dtos.ServicoDTO;
import com.sollarisv.controledeatendimentos.models.Servico;
import com.sollarisv.controledeatendimentos.services.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/servico")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ServicoDTO> findById(@PathVariable String id)
    {
        Servico obj = servicoService.findById(id);
        return ResponseEntity.ok().body(new ServicoDTO(obj));
    }

    @GetMapping
    public ResponseEntity<List<ServicoDTO>> findAll()
    {
        List<Servico> list = servicoService.findAll();
        List<ServicoDTO> listDto = list.stream().map(x -> new ServicoDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody ServicoDTO objDto)
    {
        Servico obj = servicoService.fromDTO(objDto);
        obj = servicoService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable String id)
    {
        servicoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody ServicoDTO objDto, @PathVariable String id){
        Servico obj = servicoService.fromDTO(objDto);
        obj.setId(id);
        obj = servicoService.update(obj);
        return ResponseEntity.noContent().build();
    }


}
