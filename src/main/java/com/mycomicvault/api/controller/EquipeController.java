package com.mycomicvault.api.controller;

import com.mycomicvault.api.dto.EquipeDTO;
import com.mycomicvault.api.mapper.EquipeMapper;
import com.mycomicvault.application.service.EquipeService;
import com.mycomicvault.domain.entity.Equipe;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/equipes")
public class EquipeController {

    private final EquipeService equipeService;

    public EquipeController(EquipeService equipeService) {
        this.equipeService = equipeService;
    }

    @GetMapping
    public ResponseEntity<List<EquipeDTO>> listar() {
        List<EquipeDTO> dtos = equipeService.listarTodas()
                .stream()
                .map(EquipeMapper::toDTO)
                .toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipeDTO> buscarPorId(@PathVariable UUID id) {
        return equipeService.buscarPorId(id)
                .map(EquipeMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EquipeDTO> criar(@RequestBody EquipeDTO dto) {
        Equipe entidade = EquipeMapper.toEntity(dto);
        Equipe salva = equipeService.salvar(entidade);
        return new ResponseEntity<>(EquipeMapper.toDTO(salva), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipeDTO> atualizar(@PathVariable UUID id, @RequestBody EquipeDTO dto) {
        return equipeService.buscarPorId(id).map(existing -> {
            Equipe entidadeAtualizada = EquipeMapper.toEntity(dto);
            entidadeAtualizada.setId(id);
            Equipe salva = equipeService.salvar(entidadeAtualizada);
            return ResponseEntity.ok(EquipeMapper.toDTO(salva));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@PathVariable UUID id) {
        return equipeService.buscarPorId(id).map(existing -> {
            equipeService.deletar(id);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
