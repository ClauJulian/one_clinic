package com.claujulian.clinica.repository;

import com.claujulian.clinica.dto.DatosDireccion;
import com.claujulian.clinica.dto.DatosRegistroMedico;
import com.claujulian.clinica.dto.DatosRegistroPaciente;
import com.claujulian.clinica.modelo.Especialidad;
import com.claujulian.clinica.modelo.Medico;
import com.claujulian.clinica.modelo.Paciente;
import com.claujulian.clinica.modelo.consulta.Consulta;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.DayOfWeek;
import java.time.LocalDate;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class MedicoRepositoryTest {

    @Autowired
    private EntityManager em;

    @Autowired
    private MedicoRepository repository;

    @Test
    @DisplayName("Deberia devolver null ya que el medico existe pero no esta disponible en esa fecha/hora")
    void elegirMedicoAleatorioDisponibleEnLaFechaEscenario1() {
        //given o arrange
        var lunesSiguienteALas10 = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY)).atTime(10,0);
        var medico =registrarMedico("Medico1", "medico@gmail.com", "12345", Especialidad.GINECOLOGIA);;
        var paciente =registrarPaciente("Paciente1", "paciente@gmail.com", "123789");;
        registrarConsulta(medico, paciente, lunesSiguienteALas10);
        //when o act
        var medicoLibre = repository.elegirMedicoAleatorioDisponibleEnLaFecha(Especialidad.GINECOLOGIA, lunesSiguienteALas10);
        //then o assert
        assertThat(medicoLibre).isNull();
    }

    @Test
    @DisplayName("Deberia devolver medico cuando el medico buscado esta disponible en esa fecha")
    void elegirMedicoAleatorioDisponibleEnLaFechaEscenario2() {
        //given o arrange
        var lunesSiguienteALas10 = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY)).atTime(10,0);
        var medico = registrarMedico("Medico1", "medico@gmail.com", "12345", Especialidad.GINECOLOGIA);
        //when o act
        var medicoLibre = repository.elegirMedicoAleatorioDisponibleEnLaFecha(Especialidad.GINECOLOGIA, lunesSiguienteALas10);
        //then o assert
        assertThat(medicoLibre).isEqualTo(medico);
    }




    private void registrarConsulta(Medico medico, Paciente paciente, LocalDateTime fecha) {
        em.persist(new Consulta(null, medico, paciente, fecha, null));
    }

    private Medico registrarMedico(String nombre, String email, String documento, Especialidad especialidad) {
        var medico = new Medico(datosMedico(nombre, email, documento, especialidad));
        em.persist(medico);
        return medico;
    }

    private Paciente registrarPaciente(String nombre, String email, String documento) {
        var paciente = new Paciente(datosPaciente(nombre, email, documento));
        em.persist(paciente);
        return paciente;
    }

    private DatosRegistroMedico datosMedico(String nombre, String matricula, String telefono, Especialidad especialidad) {
        return new DatosRegistroMedico(
                nombre,
                matricula,
                "8989483493",
                especialidad,
                datosDireccion()
        );
    }

    private DatosRegistroPaciente datosPaciente(String nombre, String email, String documento_identidad) {
        return new DatosRegistroPaciente(
                nombre,
                email,
                "1234564",
                documento_identidad,
                datosDireccion()
        );
    }

    private DatosDireccion datosDireccion() {
        return new DatosDireccion(
                "calle x",
                "distrito y",
                "ciudad z",
                "123"
        );
    }
}