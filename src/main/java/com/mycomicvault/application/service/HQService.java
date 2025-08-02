package com.mycomicvault.application.service;

import com.mycomicvault.domain.entity.HQ;
import com.mycomicvault.domain.repository.HQRepository;
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

    public List<HQ> listarTodas() {
        return hqRepository.findAll();
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

