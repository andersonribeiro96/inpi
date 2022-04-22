package com.inpi.verify.repository;

import com.inpi.verify.domain.Processo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessoEntityRepository extends JpaRepository<Processo, String> {
}