package com.sollarisv.controledeatendimentos.controllers;

import com.sollarisv.controledeatendimentos.dtos.AtendimentoDTO;
import com.sollarisv.controledeatendimentos.models.Atendimento;
import com.sollarisv.controledeatendimentos.services.AtendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/atendimento")
public class AtendimentoController
{

    @Autowired
    private AtendimentoService atendimentoService;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<AtendimentoDTO> findById(@PathVariable String id){
        Atendimento obj = atendimentoService.findById(id);
        return ResponseEntity.ok().body(new AtendimentoDTO(obj));
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<AtendimentoDTO>> findAll(){
        List<Atendimento> list = atendimentoService.findAll();
        List<AtendimentoDTO> listDto = list.stream().map(x -> new AtendimentoDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody AtendimentoDTO objDto){
        Atendimento obj = atendimentoService.fromDTO(objDto);
        obj = atendimentoService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id) {
        atendimentoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody AtendimentoDTO objDto, @PathVariable String id){
        Atendimento obj = atendimentoService.fromDTO(objDto);
        obj.setId(id);
        obj = atendimentoService.update(obj);
        return ResponseEntity.noContent().build();
    }
}
