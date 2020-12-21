
DROP TABLE IF EXISTS "alumno";
CREATE TABLE public.alumno
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    nombre character varying(45) COLLATE pg_catalog."default" NOT NULL,
    apellidos character varying(45) COLLATE pg_catalog."default" NOT NULL,
    fecha_nacimiento date NOT NULL,
    fotografia text COLLATE pg_catalog."default" NOT NULL,
    actividad_marcial character varying(45) COLLATE pg_catalog."default" NOT NULL,
    grado_actividad_marcial character varying(45) COLLATE pg_catalog."default" NOT NULL,
    seguro_medico text COLLATE pg_catalog."default" NOT NULL,
    certificado_medico text COLLATE pg_catalog."default" NOT NULL,
    carta_responsiva text COLLATE pg_catalog."default" NOT NULL,
    usuario character varying(45) COLLATE pg_catalog."default",
    CONSTRAINT pk_usuario PRIMARY KEY (id),
    CONSTRAINT alumno_usuario_key UNIQUE (usuario)
)

DROP TABLE IF EXISTS "usuario";
CREATE TABLE "usuario" (
  "id" integer GENERATED ALWAYS AS IDENTITY NOT NULL,
  "nombre_usuario" varchar(45) NOT NULL UNIQUE,
  "password" varchar(45) NOT NULL,
  "tipo_usuario" integer NOT NULL,
  PRIMARY KEY ("id"),
  CONSTRAINT fk_usuario FOREIGN KEY (tipo_usuario)
        REFERENCES public.tipo_evento (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID,
  CONSTRAINT fk_usuario_alumno FOREIGN KEY (nombre_usuario)
        REFERENCES public.alumno (usuario) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID
);

DROP TABLE IF EXISTS "tipo_evento";

CREATE TABLE "tipo_evento" (
  "id" integer GENERATED ALWAYS AS IDENTITY NOT NULL,
  "nombre" varchar(45) NOT NULL,
  "descripcion" text NOT NULL,
  PRIMARY KEY ("id")
);

DROP TABLE IF EXISTS "evento";

CREATE TABLE public.evento
(
    costo integer NOT NULL,
    descripcion text COLLATE pg_catalog."default" NOT NULL,
    enlace_facebook text COLLATE pg_catalog."default" NOT NULL,
    fecha_fin date NOT NULL,
    fecha_inicio date NOT NULL,
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    nombre character varying COLLATE pg_catalog."default" NOT NULL,
    tipo_evento_id integer NOT NULL,
    CONSTRAINT evento_pkey PRIMARY KEY (id),
    CONSTRAINT evento_tipo_evento_id_key UNIQUE (tipo_evento_id),
    CONSTRAINT fk_evento_1 FOREIGN KEY (tipo_evento_id)
        REFERENCES public.tipo_evento (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS "alumno_has_evento";


CREATE TABLE public.alumno_has_evento
(
    alumno_id integer NOT NULL,
    evento_id integer NOT NULL,
    CONSTRAINT "fk_alumno_has_Evento_Evento1_idx" PRIMARY KEY (alumno_id, evento_id),
    CONSTRAINT "fk_alumno_has_Evento_Evento1" FOREIGN KEY (evento_id)
        REFERENCES public.evento (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT "fk_alumno_has_evento_Alumno" FOREIGN KEY (alumno_id)
        REFERENCES public.alumno (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);


CREATE TABLE public.tipo_usuario
(
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL,
    nombre_tipo_usuario varchar NOT NULL,
    descripcion text NOT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS "alumno_has_examen";

CREATE TABLE public.alumno_has_examen
(
    alumno_id integer NOT NULL,
    examen_id integer NOT NULL,
    CONSTRAINT pk_destinatario PRIMARY KEY (alumno_id, examen_id),
    CONSTRAINT fk_alumno_has_examen_alumno FOREIGN KEY (alumno_id)
        REFERENCES public.alumno (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT fk_alumno_has_examen_examen1 FOREIGN KEY (examen_id)
        REFERENCES public.examen (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS "examen";

CREATE TABLE public.examen
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    nombre character varying(45) COLLATE pg_catalog."default" NOT NULL,
    tipo character varying(45) COLLATE pg_catalog."default" NOT NULL,
    fecha_hora date NOT NULL,
    costo numeric(7,2) NOT NULL,
    enlace_facebook text COLLATE pg_catalog."default" NOT NULL,
    solicitud_examen text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT pk_examen PRIMARY KEY (id)
)



