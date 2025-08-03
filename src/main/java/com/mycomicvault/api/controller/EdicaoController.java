package com.mycomicvault.api.controller;

import com.mycomicvault.api.dto.EdicaoDTO;
import com.mycomicvault.api.dto.HQDTO;
import com.mycomicvault.api.mapper.EdicaoMapper;
import com.mycomicvault.api.mapper.HQMapper;
import com.mycomicvault.application.service.EdicaoService;
import com.mycomicvault.domain.entity.Edicao;
import com.mycomicvault.application.service.FileStorageService;
import com.mycomicvault.domain.entity.HQ;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public ResponseEntity<Page<EdicaoDTO>> listar(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sort,
            @RequestParam(defaultValue = "") String search) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        Page<Edicao> edicoes;

        if (search.isEmpty()) {
            edicoes = edicaoService.listarTodas(pageable);
        } else {
            edicoes = edicaoService.buscarPorNome(search, pageable);
        }

        Page<EdicaoDTO> dtos = edicoes.map(EdicaoMapper::toDTO);
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
