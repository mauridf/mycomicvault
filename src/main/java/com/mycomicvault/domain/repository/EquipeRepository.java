package com.mycomicvault.domain.repository;

import com.mycomicvault.domain.entity.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface EquipeRepository extends JpaRepository<Equipe, UUID> {}
