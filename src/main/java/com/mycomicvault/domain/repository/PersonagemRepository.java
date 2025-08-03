package com.mycomicvault.domain.repository;

import com.mycomicvault.domain.entity.Personagem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface PersonagemRepository extends JpaRepository<Personagem, UUID> {
    @Query("SELECT e FROM Personagem e WHERE " +
            "LOWER(e.name) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(e.aliases) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(e.gender) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    Page<Personagem> search(@Param("searchTerm") String searchTerm, Pageable pageable);
}

