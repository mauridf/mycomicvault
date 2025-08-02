package com.mycomicvault.application.service;

import com.mycomicvault.domain.entity.Personagem;
import com.mycomicvault.domain.repository.PersonagemRepository;
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

    public List<Personagem> listarTodas() {
        return personagemRepository.findAll();
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
