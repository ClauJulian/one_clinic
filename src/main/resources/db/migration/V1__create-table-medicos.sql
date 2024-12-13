create table medicos(
    id BIGSERIAL not null,
    nombre varchar(100) not null,
    matricula varchar(100) not null unique,
    especialidad varchar(100) not null,
    calle varchar(100) not null,
    numero varchar(20),
    localidad varchar(100) not null,
    provincia varchar(100) not null,

    primary key(id)

);