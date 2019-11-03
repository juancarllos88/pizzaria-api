CREATE SCHEMA pizzaria;


CREATE TABLE pizzaria.t_tamanho
(
  id SERIAL NOT NULL,
  tipo varchar(20) NOT NULL,
  valor numeric(19,2),
  tempo bigint,
  PRIMARY KEY (id)
);

CREATE TABLE pizzaria.t_sabor
(
  id SERIAL NOT NULL,
  nome varchar(50) NOT NULL,
  tempo bigint,
  PRIMARY KEY (id)
);


CREATE TABLE pizzaria.t_adicional
(
  id SERIAL NOT NULL,
  nome varchar(50) NOT NULL,
  valor numeric(19,2),
  tempo bigint,
  PRIMARY KEY (id)
);


CREATE TABLE pizzaria.t_pizza
(
  id SERIAL NOT NULL,
  id_sabor bigint NOT NULL,
  id_tamanho bigint NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_t_pizza_id_sabor FOREIGN KEY (id_sabor) REFERENCES pizzaria.t_sabor (id),
  CONSTRAINT fk_t_pizza_id_tamanho FOREIGN KEY (id_tamanho) REFERENCES pizzaria.t_tamanho (id)
);


CREATE TABLE pizzaria.t_pizza_adicional
(
  id_pizza bigint NOT NULL,
  id_adicional bigint NOT NULL,
  CONSTRAINT pk_pizza_adicional PRIMARY KEY (id_pizza, id_adicional),
  CONSTRAINT fk_t_pa_pizza FOREIGN KEY (id_pizza) REFERENCES pizzaria.t_pizza (id),
  CONSTRAINT fk_t_pa_adicional FOREIGN KEY (id_adicional) REFERENCES pizzaria.t_adicional (id)
);

CREATE TABLE pizzaria.t_pedido(
  id SERIAL NOT NULL,
  id_pizza bigint NOT NULL,
  valor numeric(19,2),
  tempo bigint,
  PRIMARY KEY (id),
  CONSTRAINT fk_t_pedido_id_pizza FOREIGN KEY (id_pizza) REFERENCES pizzaria.t_pizza (id)
);
