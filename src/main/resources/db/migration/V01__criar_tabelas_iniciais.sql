-- Table: condicao_selecao

-- DROP TABLE condicao_selecao;

CREATE TABLE condicao_selecao
(
  id bigserial NOT NULL,
  reside_area_risco_insalubre boolean,
  opcao_empreendimento boolean,
  apf_empreendimento character varying(9),
  tipo_deficiencia character varying(1) NOT NULL,
  doenca_cronica_incapacitante boolean,
  data_inicio_residencia_municipio date,
  beneficio_social boolean,
  situacao_rua_com_acompanhamento boolean,
  residencia_alugada boolean,
  valor_aluguel double precision,
  recebe_aluguel_social boolean,
  data_cadastro_habitacional_anterior date,
  atendida_maria_da_penha boolean,
  situacao_coabitacional_involuntaria boolean,
  CONSTRAINT pk_condicao_selecao PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE condicao_selecao
  OWNER TO sicahab;
  
  -- Table: criterios_adicionais_autorizados_snh

-- DROP TABLE criterios_adicionais_autorizados_snh;

CREATE TABLE criterios_adicionais_autorizados_snh
(
  id bigserial NOT NULL,
  codigo_autorizacao character varying(8) NOT NULL,
  resultado_enquadramento_familia boolean NOT NULL,
  grupo_familiar_id bigint,
  CONSTRAINT pk_criterios_adicionais_autorizados_snh PRIMARY KEY (id),
  CONSTRAINT fk_criteriosadicionaisautorizadossnh_grupofamiliar_id FOREIGN KEY (grupo_familiar_id)
      REFERENCES grupo_familiar (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE criterios_adicionais_autorizados_snh
  OWNER TO sicahab;
  
-- Table: documento_identificao

-- DROP TABLE documento_identificao;

CREATE TABLE documento_identificao
(
  id bigserial NOT NULL,
  tipo_documento_identificao character varying(3) NOT NULL,
  numero character varying(15) NOT NULL,
  orgao_expedicao character varying(5) NOT NULL,
  uf_emissor character varying(2),
  data_expedicao date NOT NULL,
  CONSTRAINT pk_documento_identificao PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE documento_identificao
  OWNER TO sicahab;
  
-- Table: empreendimento

-- DROP TABLE empreendimento;

CREATE TABLE empreendimento
(
  id bigserial NOT NULL,
  nome character varying(255) NOT NULL,
  tipo_empreendimento character varying(255),
  quantidade_unidades integer,
  previsao_entrega date,
  indicacao_empreendimento_id bigint,
  programa_id bigint,
  CONSTRAINT pk_empreendimento PRIMARY KEY (id),
  CONSTRAINT fk_empreendimento_indicacaoempreendimento_id FOREIGN KEY (indicacao_empreendimento_id)
      REFERENCES indicacao_empreendimento (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_empreendimento_programa_id FOREIGN KEY (programa_id)
      REFERENCES programa (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT empreendimento_indicacao_empreendimento_id_key UNIQUE (indicacao_empreendimento_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE empreendimento
  OWNER TO sicahab;

-- Table: envio_xml

-- DROP TABLE envio_xml;

CREATE TABLE envio_xml
(
  id bigserial NOT NULL,
  versao_leiaute_xml character varying(255) NOT NULL,
  codigo_municipio character varying(7) NOT NULL,
  cnpj_prefeitura character varying(14),
  data_geracao date NOT NULL,
  hora_geracao timestamp without time zone NOT NULL,
  xml bytea,
  xml_content_type character varying(255),
  CONSTRAINT pk_envio_xml PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE envio_xml
  OWNER TO sicahab;

-- Table: grupo_familiar
    public String getCodigoAtualizacao() {
        return codigoAtualizacao;
    }

    public void setCodigoAtualizacao(String codigoAtualizacao) {
        this.codigoAtualizacao = codigoAtualizacao;
    }
-- DROP TABLE grupo_familiar;

CREATE TABLE grupo_familiar
(
  id bigserial NOT NULL,
  codigo_atualizacao character varying(1),
  motivo_exclusao character varying(100),
  nis_titular character varying(11),
  pessoa_id bigint,
  CONSTRAINT pk_grupo_familiar PRIMARY KEY (id),
  CONSTRAINT fk_grupofamiliar_pessoa_id FOREIGN KEY (pessoa_id)
      REFERENCES pessoa (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT grupo_familiar_pessoa_id_key UNIQUE (pessoa_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE grupo_familiar
  OWNER TO sicahab;


-- Table: indicacao_empreendimento

-- DROP TABLE indicacao_empreendimento;

CREATE TABLE indicacao_empreendimento
(
  id bigserial NOT NULL,
  codigo_apf_empreendimento character varying(9) NOT NULL,
  CONSTRAINT pk_indicacao_empreendimento PRIMARY KEY (id)
)    public String getCodigoAtualizacao() {
        return codigoAtualizacao;
    }

    public void setCodigoAtualizacao(String codigoAtualizacao) {
        this.codigoAtualizacao = codigoAtualizacao;
    }
WITH (
  OIDS=FALSE
);
ALTER TABLE indicacao_empreendimento
  OWNER TO sicahab;

-- Table: indicados

-- DROP TABLE indicados;

CREATE TABLE indicados
(
  id bigserial NOT NULL,
  nis_titular character varying(11) NOT NULL,
  codigo_atualizacao character varying(1) NOT NULL,
  motivo_indicacao character varying(1) NOT NULL,
  indicacao_empreendimento_id bigint,
  CONSTRAINT pk_indicados PRIMARY KEY (id),
  CONSTRAINT fk_indicados_indicacaoempreendimento_id FOREIGN KEY (indicacao_empreendimento_id)
      REFERENCES indicacao_empreendimento (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE indicados
  OWNER TO sicahab;


-- Table: nacionalidade

-- DROP TABLE nacionalidade;

CREATE TABLE nacionalidade
(
  id bigserial NOT NULL,
  codigo_pais character varying(3),
  nome_nacionalidade character varying(255),
  codigo_iso_alpha_3 character varying(3),
  CONSTRAINT pk_nacionalidade PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE nacionalidade
  OWNER TO sicahab;


-- Table: participante

-- DROP TABLE participante;

CREATE TABLE participante
(
  id bigserial NOT NULL,
  nis_participante character varying(11) NOT NULL,
  papel_participante character varying(2) NOT NULL,
  grupo_familiar_id bigint,
  CONSTRAINT pk_participante PRIMARY KEY (id),
  CONSTRAINT fk_participante_grupofamiliar_id FOREIGN KEY (grupo_familiar_id)
      REFERENCES grupo_familiar (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE participante
  OWNER TO sicahab;


-- Table: pessoa

-- DROP TABLE pessoa;

CREATE TABLE pessoa
(
  id bigserial NOT NULL,
  data_cadastro timestamp without time zone NOT NULL,
  codigo_atualizacao character varying(1) NOT NULL,
  nis character varying(11) NOT NULL,
  nome character varying(255) NOT NULL,
  cpf character varying(11),
  data_nascimento date NOT NULL,
  sexo character varying(1) NOT NULL,
  naturalidade character varying(7),
  estado_civil integer NOT NULL,
  data_casamento date,
  renda_declarada double precision NOT NULL,
  email character varying(255),
  ocupacao character varying(255) NOT NULL,
  nome_mae character varying(70),
  data_nascimento_mae date,
  nacionalidade_id bigint,
  condicao_selecao_id bigint,
  documento_identificao_id bigint,
  telefone_mae_id bigint,
  CONSTRAINT pk_pessoa PRIMARY KEY (id),
  CONSTRAINT fk_pessoa_condicaoselecao_id FOREIGN KEY (condicao_selecao_id)
      REFERENCES condicao_selecao (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_pessoa_documentoidentificao_id FOREIGN KEY (documento_identificao_id)
      REFERENCES documento_identificao (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_pessoa_nacionalidade_id FOREIGN KEY (nacionalidade_id)
      REFERENCES nacionalidade (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_pessoa_telefonemae_id FOREIGN KEY (telefone_mae_id)
      REFERENCES telefone_mae (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT pessoa_condicao_selecao_id_key UNIQUE (condicao_selecao_id),
  CONSTRAINT pessoa_documento_identificao_id_key UNIQUE (documento_identificao_id),
  CONSTRAINT pessoa_nacionalidade_id_key UNIQUE (nacionalidade_id),
  CONSTRAINT pessoa_telefone_mae_id_key UNIQUE (telefone_mae_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE pessoa
  OWNER TO sicahab;

-- Table: pessoa_empreendimento

-- DROP TABLE pessoa_empreendimento;

CREATE TABLE pessoa_empreendimento
(
  empreendimentos_id bigint NOT NULL,
  pessoas_id bigint NOT NULL,
  CONSTRAINT pessoa_empreendimento_pkey PRIMARY KEY (pessoas_id, empreendimentos_id),
  CONSTRAINT fk_pessoa_empreendimento_empreendimentos_id FOREIGN KEY (empreendimentos_id)
      REFERENCES empreendimento (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_pessoa_empreendimento_pessoas_id FOREIGN KEY (pessoas_id)
      REFERENCES pessoa (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE pessoa_empreendimento
  OWNER TO sicahab;

  
-- Table: programa

-- DROP TABLE programa;

CREATE TABLE programa
(
  id bigserial NOT NULL,
  nome character varying(255),
  sigla character varying(255),
  CONSTRAINT pk_programa PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE programa
  OWNER TO sicahab;

  
-- Table: retorno_xml

-- DROP TABLE retorno_xml;

CREATE TABLE retorno_xml
(
  id bigserial NOT NULL,
  versao_leiaute_xml character varying(255) NOT NULL,
  codigo_municipio character varying(7) NOT NULL,
  cnpj_prefeitura character varying(14),
  data_geracao date NOT NULL,
  hora_geracao timestamp without time zone NOT NULL,
  xml bytea,
  xml_content_type character varying(255),
  CONSTRAINT pk_retorno_xml PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE retorno_xml
  OWNER TO sicahab;

  
-- Table: telefone

-- DROP TABLE telefone;

CREATE TABLE telefone
(
  id bigserial NOT NULL,
  ddd character varying(3),
  numero character varying(9),
  ramal character varying(4),
  tipo_celular character varying(255),
  pessoa_id bigint,
  CONSTRAINT pk_telefone PRIMARY KEY (id),
  CONSTRAINT fk_telefone_pessoa_id FOREIGN KEY (pessoa_id)
      REFERENCES pessoa (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE telefone
  OWNER TO sicahab;

  
-- Table: telefone_mae

-- DROP TABLE telefone_mae;

CREATE TABLE telefone_mae
(
  id bigserial NOT NULL,
  ddd character varying(2) NOT NULL,
  numero character varying(9) NOT NULL,
  CONSTRAINT pk_telefone_mae PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE telefone_mae
  OWNER TO sicahab;


