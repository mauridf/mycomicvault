package com.mycomicvault.application.service;

import com.mycomicvault.domain.entity.Equipe;
import com.mycomicvault.domain.repository.EquipeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class EquipeService {
    private final EquipeRepository equipeRepository;

    public EquipeService(EquipeRepository equipeRepository) {
        this.equipeRepository = equipeRepository;
    }

    public Page<Equipe> listarTodas(Pageable pageable) {
        return equipeRepository.findAll(pageable);
    }

    public Page<Equipe> buscarPorNome(String searchTerm, Pageable pageable) {
        return equipeRepository.search(searchTerm, pageable);
    }

    public Optional<Equipe> buscarPorId(UUID id) {
        return equipeRepository.findById(id);
    }

    public Equipe salvar(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    public void deletar(UUID id) {
        equipeRepository.deleteById(id);
    }
}
