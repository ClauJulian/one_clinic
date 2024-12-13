alter table pacientes add column activo BOOLEAN;

update pacientes set activo = true;

ALTER TABLE pacientes
ALTER COLUMN activo SET NOT NULL;