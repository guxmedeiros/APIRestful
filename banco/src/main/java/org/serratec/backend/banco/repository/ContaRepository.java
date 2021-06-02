package org.serratec.backend.banco.repository;

import org.serratec.backend.banco.entity.ContaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<ContaEntity, Long> {

}
