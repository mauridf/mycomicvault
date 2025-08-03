package com.mycomicvault.api.controller;

import com.mycomicvault.api.dto.EditoraDTO;
import com.mycomicvault.api.mapper.EditoraMapper;
import com.mycomicvault.application.service.EditoraService;
import com.mycomicvault.domain.entity.Editora;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/editoras")
public class EditoraController {

    private final EditoraService editoraService;

    public EditoraController(EditoraService editoraService) {
        this.editoraService = editoraService;
    }

    @GetMapping
    public ResponseEntity<Page<EditoraDTO>> listar(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sort,
            @RequestParam(defaultValue = "") String search) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        Page<Editora> editoras;

        if (search.isEmpty()) {
            editoras = editoraService.listarTodas(pageable);
        } else {
            editoras = editoraService.buscarPorNome(search, pageable);
        }

        Page<EditoraDTO> dtos = editoras.map(EditoraMapper::toDTO);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EditoraDTO> buscarPorId(@PathVariable UUID id) {
        return editoraService.buscarPorId(id)
                .map(EditoraMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EditoraDTO> criar(@RequestBody EditoraDTO dto) {
        Editora entidade = EditoraMapper.toEntity(dto);
        Editora salva = editoraService.salvar(entidade);
        return new ResponseEntity<>(EditoraMapper.toDTO(salva), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EditoraDTO> atualizar(@PathVariable UUID id, @RequestBody EditoraDTO dto) {
        return editoraService.buscarPorId(id).map(existing -> {
            Editora entidadeAtualizada = EditoraMapper.toEntity(dto);
            entidadeAtualizada.setId(id); // mantemos o ID original
            Editora salva = editoraService.salvar(entidadeAtualizada);
            return ResponseEntity.ok(EditoraMapper.toDTO(salva));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@PathVariable UUID id) {
        return editoraService.buscarPorId(id).map(existing -> {
            editoraService.deletar(id);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
