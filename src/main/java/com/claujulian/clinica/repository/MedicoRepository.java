package com.claujulian.clinica.repository;

import com.claujulian.clinica.modelo.Especialidad;
import com.claujulian.clinica.modelo.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;


public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findByActivoTrue(Pageable paginacion);

    @Query("""
            SELECT m FROM Medico m
            WHERE
            m.especialidad = :especialidad
            AND
            m.activo = true
            AND
            m.id not in(
                SELECT c.medico.id FROM Consulta c
                WHERE
                c.fecha = :fecha
                and
                c.motivoCancelamiento is null
            )
            ORDER BY random()
            LIMIT 1
            """)
    Medico elegirMedicoAleatorioDisponibleEnLaFecha(Especialidad especialidad, LocalDateTime fecha);

    @Query("""
            select m.activo from Medico m
            where
            m.id = :idMedico
            """)
    Boolean findActivoById(Long idMedico);
}
