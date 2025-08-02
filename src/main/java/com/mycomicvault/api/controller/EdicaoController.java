package com.mycomicvault.api.controller;

import com.mycomicvault.api.dto.EdicaoDTO;
import com.mycomicvault.api.mapper.EdicaoMapper;
import com.mycomicvault.application.service.EdicaoService;
import com.mycomicvault.domain.entity.Edicao;
import com.mycomicvault.application.service.FileStorageService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/edicoes")
public class EdicaoController {

    private final EdicaoService edicaoService;
    private final FileStorageService fileStorageService;

    public EdicaoController(EdicaoService edicaoService, FileStorageService fileStorageService) {
        this.edicaoService = edicaoService;
        this.fileStorageService = fileStorageService;
    }

    @GetMapping
    public ResponseEntity<List<EdicaoDTO>> listar() {
        List<EdicaoDTO> dtos = edicaoService.listarTodas()
                .stream()
                .map(EdicaoMapper::toDTO)
                .toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EdicaoDTO> buscarPorId(@PathVariable UUID id) {
        return edicaoService.buscarPorId(id)
                .map(EdicaoMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EdicaoDTO> criar(@RequestBody EdicaoDTO dto) {
        Edicao entidade = EdicaoMapper.toEntity(dto);
        Edicao salva = edicaoService.salvar(entidade);
        return new ResponseEntity<>(EdicaoMapper.toDTO(salva), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EdicaoDTO> atualizar(@PathVariable UUID id, @RequestBody EdicaoDTO dto) {
        return edicaoService.buscarPorId(id).map(existing -> {
            Edicao entidadeAtualizada = EdicaoMapper.toEntity(dto);
            entidadeAtualizada.setId(id);
            Edicao salva = edicaoService.salvar(entidadeAtualizada);
            return ResponseEntity.ok(EdicaoMapper.toDTO(salva));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@PathVariable UUID id) {
        return edicaoService.buscarPorId(id).map(existing -> {
            edicaoService.deletar(id);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/upload-capa")
    public ResponseEntity<String> uploadCapa(@RequestParam("file") MultipartFile file) {
        try {
            String urlCapa = fileStorageService.salvarCapa(file);
            return ResponseEntity.ok(urlCapa);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Erro ao salvar imagem: " + e.getMessage());
        }
    }
}
