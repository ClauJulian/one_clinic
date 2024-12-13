package com.claujulian.clinica.modelo;

import com.claujulian.clinica.dto.DatosActualizarPaciente;
import com.claujulian.clinica.dto.DatosRegistroPaciente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name ="pacientes")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of= "id")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    private String documentoIdentidad;
    private String telefono;
    private Boolean activo;

    @Embedded
    private Direccion direccion;

    public Paciente(DatosRegistroPaciente datos) {
        this.activo = true;
        this.nombre = datos.nombre();
        this.email = datos.email();
        this.telefono = datos.telefono();
        this.documentoIdentidad = datos.documento_identidad();
        this.direccion = new Direccion(datos.direccion());
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

   public String getTelefono() {
        return telefono;
    }

    public Long getId() {
        return id;
    }

    public Boolean getActivo() {
        return activo;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void desactivarPaciente() {
        this.activo = false;
    }

    public void atualizarInformacion(DatosActualizarPaciente datos) {
        if (datos.nombre() != null)
            this.nombre = datos.nombre();

        if (datos.telefono() != null)
            this.telefono = datos.telefono();

        if (datos.direccion() != null)
            direccion.actualizarDatos(datos.direccion());
    }
}
