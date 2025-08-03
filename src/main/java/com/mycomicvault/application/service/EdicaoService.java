package com.mycomicvault.application.service;

import com.mycomicvault.domain.entity.Edicao;
import com.mycomicvault.domain.repository.EdicaoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EdicaoService {
    private final EdicaoRepository edicaoRepository;

    public EdicaoService(EdicaoRepository edicaoRepository) {
        this.edicaoRepository = edicaoRepository;
    }

    public Page<Edicao> listarTodas(Pageable pageable) {
        return edicaoRepository.findAll(pageable);
    }

    public Page<Edicao> buscarPorNome(String searchTerm, Pageable pageable) {
        return edicaoRepository.search(searchTerm, pageable);
    }

    public Optional<Edicao> buscarPorId(UUID id) {
        return edicaoRepository.findById(id);
    }

    public Edicao salvar(Edicao edicao) {
        return edicaoRepository.save(edicao);
    }

    public void deletar(UUID id) {
        edicaoRepository.deleteById(id);
    }
}
