package com.mycomicvault.domain.repository;

import com.mycomicvault.domain.entity.HQ;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface HQRepository extends JpaRepository<HQ, UUID> {}
