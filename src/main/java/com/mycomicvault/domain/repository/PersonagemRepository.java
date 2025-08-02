package com.mycomicvault.domain.repository;

import com.mycomicvault.domain.entity.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface PersonagemRepository extends JpaRepository<Personagem, UUID> {}
