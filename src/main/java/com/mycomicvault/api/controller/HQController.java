package com.mycomicvault.api.controller;

import com.mycomicvault.api.dto.EquipeDTO;
import com.mycomicvault.api.dto.HQDTO;
import com.mycomicvault.api.mapper.EquipeMapper;
import com.mycomicvault.api.mapper.HQMapper;
import com.mycomicvault.application.service.HQService;
import com.mycomicvault.domain.entity.Equipe;
import com.mycomicvault.domain.entity.HQ;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/hqs")
public class HQController {

    private final HQService hqService;

    public HQController(HQService hqService) {
        this.hqService = hqService;
    }

    @GetMapping
    public ResponseEntity<Page<HQDTO>> listar(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sort,
            @RequestParam(defaultValue = "") String search) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        Page<HQ> hqs;

        if (search.isEmpty()) {
            hqs = hqService.listarTodas(pageable);
        } else {
            hqs = hqService.buscarPorNome(search, pageable);
        }

        Page<HQDTO> dtos = hqs.map(HQMapper::toDTO);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HQDTO> buscarPorId(@PathVariable UUID id) {
        return hqService.buscarPorId(id)
                .map(HQMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<HQDTO> criar(@RequestBody HQDTO dto) {
        HQ entidade = HQMapper.toEntity(dto);
        HQ salva = hqService.salvar(entidade);
        return new ResponseEntity<>(HQMapper.toDTO(salva), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HQDTO> atualizar(@PathVariable UUID id, @RequestBody HQDTO dto) {
        return hqService.buscarPorId(id).map(existing -> {
            HQ entidadeAtualizada = HQMapper.toEntity(dto);
            entidadeAtualizada.setId(id);
            HQ salva = hqService.salvar(entidadeAtualizada);
            return ResponseEntity.ok(HQMapper.toDTO(salva));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@PathVariable UUID id) {
        return hqService.buscarPorId(id).map(existing -> {
            hqService.deletar(id);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
