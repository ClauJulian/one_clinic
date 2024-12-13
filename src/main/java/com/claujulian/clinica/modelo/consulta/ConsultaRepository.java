package com.claujulian.clinica.modelo.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    Boolean existsByMedicoIdAndFechaAndMotivoCancelamientoIsNull(Long idMedico, LocalDateTime fecha);
    Boolean existsByPacienteIdAndMotivoCancelamientoIsNullAndFechaBetween(Long idPaciente,
                                                                          LocalDateTime primerHorario,
                                                                          LocalDateTime ultimoHorario);


}
