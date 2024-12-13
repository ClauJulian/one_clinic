package com.claujulian.clinica.modelo;

import com.claujulian.clinica.dto.DatosActualizarMedico;
import com.claujulian.clinica.dto.DatosRegistroMedico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name="medicos")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String telefono;
    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;
    private String matricula;
    @Embedded
    private Direccion direccion;

    private boolean activo;



    public Medico(DatosRegistroMedico datosRegistroMedico){
        this.activo = true;
        this.nombre = datosRegistroMedico.nombre();
        this.telefono = datosRegistroMedico.telefono();
        this.especialidad = datosRegistroMedico.especialidad();
        this.matricula = datosRegistroMedico.matricula();
        this.direccion = new Direccion(datosRegistroMedico.direccion());
}

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public String getMatricula() {
        return matricula;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void actualizarDatos(DatosActualizarMedico datosActualizarMedico) {
        if(datosActualizarMedico.nombre() != null){
            this.nombre=datosActualizarMedico.nombre();
        }
        if(datosActualizarMedico.telefono() != null){
            this.telefono= datosActualizarMedico.telefono();
        }
        if(datosActualizarMedico.direccion() != null){
            this.direccion= direccion.actualizarDatos(datosActualizarMedico.direccion());
        }

    }

    public void desactivarMedico() {
        this.activo=false;
    }


}