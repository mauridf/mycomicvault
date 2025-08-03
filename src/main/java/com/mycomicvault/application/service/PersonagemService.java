package com.mycomicvault.application.service;

import com.mycomicvault.domain.entity.Personagem;
import com.mycomicvault.domain.repository.PersonagemRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonagemService {
    private final PersonagemRepository personagemRepository;

    public PersonagemService(PersonagemRepository personagemRepository) {
        this.personagemRepository = personagemRepository;
    }

    public Page<Personagem> listarTodas(Pageable pageable) {
        return personagemRepository.findAll(pageable);
    }

    public Page<Personagem> buscarPorNome(String searchTerm, Pageable pageable) {
        return personagemRepository.search(searchTerm, pageable);
    }

    public Optional<Personagem> buscarPorId(UUID id) {
        return personagemRepository.findById(id);
    }

    public Personagem salvar(Personagem personagem) {
        return personagemRepository.save(personagem);
    }

    public void deletar(UUID id) {
        personagemRepository.deleteById(id);
    }
}
