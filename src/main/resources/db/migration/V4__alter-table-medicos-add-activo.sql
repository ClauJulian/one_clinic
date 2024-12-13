alter table medicos add column activo BOOLEAN;

update medicos set activo = true;

ALTER TABLE medicos
ALTER COLUMN activo SET NOT NULL;