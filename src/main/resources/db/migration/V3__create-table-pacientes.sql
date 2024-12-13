create table pacientes(
    id BIGSERIAL not null,
    nombre varchar(100) not null,
    email varchar(100) not null unique,
    documento_identidad varchar(14) not null unique,
    telefono varchar(20) not null,
    calle varchar(100) not null,
    numero varchar(20),
    localidad varchar(100) not null,
    provincia varchar(100) not null,

    primary key(id)

    )