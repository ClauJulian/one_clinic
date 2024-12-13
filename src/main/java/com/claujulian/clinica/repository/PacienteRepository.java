package com.claujulian.clinica.repository;

import com.claujulian.clinica.modelo.Paciente;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente,Long> {
    Page<Paciente> findByActivoTrue(Pageable paginacion);

    @Query("""
            select p.activo from Paciente p
            where
            p.id = :idPaciente
            """)
    Boolean findActivoById(Long idPaciente);


}
