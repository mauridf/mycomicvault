package com.mycomicvault.api.controller;

import com.mycomicvault.api.dto.PersonagemDTO;
import com.mycomicvault.api.mapper.PersonagemMapper;
import com.mycomicvault.application.service.PersonagemService;
import com.mycomicvault.domain.entity.Personagem;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/personagens")
public class PersonagemController {

    private final PersonagemService personagemService;

    public PersonagemController(PersonagemService personagemService) {
        this.personagemService = personagemService;
    }

    @GetMapping
    public ResponseEntity<List<PersonagemDTO>> listar() {
        List<PersonagemDTO> dtos = personagemService.listarTodas()
                .stream()
                .map(PersonagemMapper::toDTO)
                .toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonagemDTO> buscarPorId(@PathVariable UUID id) {
        return personagemService.buscarPorId(id)
                .map(PersonagemMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PersonagemDTO> criar(@RequestBody PersonagemDTO dto) {
        Personagem entidade = PersonagemMapper.toEntity(dto);
        Personagem salva = personagemService.salvar(entidade);
        return new ResponseEntity<>(PersonagemMapper.toDTO(salva), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonagemDTO> atualizar(@PathVariable UUID id, @RequestBody PersonagemDTO dto) {
        return personagemService.buscarPorId(id).map(existing -> {
            Personagem entidadeAtualizada = PersonagemMapper.toEntity(dto);
            entidadeAtualizada.setId(id);
            Personagem salva = personagemService.salvar(entidadeAtualizada);
            return ResponseEntity.ok(PersonagemMapper.toDTO(salva));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@PathVariable UUID id) {
        return personagemService.buscarPorId(id).map(existing -> {
            personagemService.deletar(id);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
