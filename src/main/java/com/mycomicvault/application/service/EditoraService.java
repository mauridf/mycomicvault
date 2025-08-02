package com.mycomicvault.application.service;

import com.mycomicvault.domain.entity.Editora;
import com.mycomicvault.domain.repository.EditoraRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EditoraService {

    private final EditoraRepository editoraRepository;

    public EditoraService(EditoraRepository editoraRepository) {
        this.editoraRepository = editoraRepository;
    }

    public Page<Editora> listarTodas(Pageable pageable) {
        return editoraRepository.findAll(pageable);
    }

    public Page<Editora> buscarPorNome(String searchTerm, Pageable pageable) {
        return editoraRepository.search(searchTerm, pageable);
    }

    public Optional<Editora> buscarPorId(UUID id) {
        return editoraRepository.findById(id);
    }

    public Editora salvar(Editora editora) {
        return editoraRepository.save(editora);
    }

    public void deletar(UUID id) {
        editoraRepository.deleteById(id);
    }
}
