package com.claujulian.clinica.dto;

import com.claujulian.clinica.modelo.Medico;

public record DatosListadoMedico(
        Long id,
        String nombre,
        String especialidad,
        String matricula)
{

    public DatosListadoMedico(Medico medico) {
        this(medico.getId(),medico.getNombre(),medico.getEspecialidad().toString(),medico.getMatricula());
    }
}
