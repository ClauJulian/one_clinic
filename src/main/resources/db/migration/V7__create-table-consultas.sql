CREATE TABLE consultas(
    id BIGSERIAL not null,
    medico_id BIGINT not null,
    paciente_id BIGINT not null,
    fecha TIMESTAMP not null,
    PRIMARY KEY (id),
    CONSTRAINT fk_consultas_medico_id FOREIGN KEY(medico_id) REFERENCES medicos(id),
    CONSTRAINT fk_consultas_paciente_id FOREIGN KEY(paciente_id) REFERENCES pacientes(id)
);