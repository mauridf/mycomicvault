package com.mycomicvault.application.service;

import com.mycomicvault.domain.entity.Equipe;
import com.mycomicvault.domain.entity.HQ;
import com.mycomicvault.domain.repository.HQRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class HQService {
    private final HQRepository hqRepository;

    public HQService(HQRepository hqRepository) {
        this.hqRepository = hqRepository;
    }

    public Page<HQ> listarTodas(Pageable pageable) {
        return hqRepository.findAll(pageable);
    }

    public Page<HQ> buscarPorNome(String searchTerm, Pageable pageable) {
        return hqRepository.search(searchTerm, pageable);
    }

    public Optional<HQ> buscarPorId(UUID id) {
        return hqRepository.findById(id);
    }

    public HQ salvar(HQ hq) {
        return hqRepository.save(hq);
    }

    public void deletar(UUID id) {
        hqRepository.deleteById(id);
    }
}

