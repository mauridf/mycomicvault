package com.mycomicvault.domain.repository;

import com.mycomicvault.domain.entity.Editora;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface EditoraRepository extends JpaRepository<Editora, UUID> {
    @Query("SELECT e FROM Editora e WHERE " +
            "LOWER(e.name) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(e.aliases) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(e.city) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(e.state) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    Page<Editora> search(@Param("searchTerm") String searchTerm, Pageable pageable);
}
