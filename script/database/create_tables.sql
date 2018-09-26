--TEM DE CRIAR CADA TABELA DE UMA VEZ PARA EVITAR ERRO NO BANCO
-- Table   endereco-- -----------------------------------------------------
CREATE TABLE endereco (
   pk_id_endereco  SERIAL,
   rua             VARCHAR(100) NULL,
   numero          VARCHAR(10) NULL,
   complemento     VARCHAR(100) NULL,
   bairro          VARCHAR(45) NULL,
   cep             VARCHAR(8) NULL,
   cidade          VARCHAR(45) NULL,
   estado          VARCHAR(2) NULL);


-- -----------------------------------------------------
-- Table   cliente-- -----------------------------------------------------
CREATE TABLE cliente (
   pk_cpf_cliente    SERIAL,
   fk_id_endereco    INT NOT NULL,
   fk_cnpj_loja      VARCHAR(14) NOT NULL,
   nome_cliente      VARCHAR(100) NULL,
   telefone_cliente  VARCHAR(11) NULL,
   email_cliente     VARCHAR(100) NULL);


-- -----------------------------------------------------
-- Table   loja-- -----------------------------------------------------
CREATE TABLE loja (
   pk_cnpj_loja   VARCHAR(14) NOT NULL,
   senha_loja     TEXT NOT NULL,
   nome_loja      VARCHAR(100) NULL,
   telefone_loja  VARCHAR(11) NULL);

-- -----------------------------------------------------
-- Table   sorteio-- -----------------------------------------------------
CREATE TABLE sorteio (
   pk_id_sorteio SERIAL,
   fk_cnpj_loja             VARCHAR(14) NOT NULL,
   titulo                   VARCHAR(100) NULL,
   descricao                TEXT NULL,
   data_inicio              DATE NULL,
   data_fim                 DATE NULL,
   dia_sorteio              DATE NULL,
   premio_primeiro_sorteio  VARCHAR(45) NULL,
   premio_segundo_sorteio   VARCHAR(45) NULL,
   premio_terceiro_sorteio  VARCHAR(45) NULL);
  
-- -----------------------------------------------------
-- Table   cupom-- -----------------------------------------------------
CREATE TABLE cupom (
   pk_id_cupom    SERIAL,
   fk_cpf_cliente  INT NOT NULL,
   fk_id_sorteio  INT NOT NULL,
   fk_cnpj_loja   VARCHAR(14) NOT NULL);

-- -----------------------------------------------------
-- Table   resultado_sorteio-- -----------------------------------------------------
CREATE TABLE resultado_sorteio (
   pk_id_resultado_sorteio       SERIAL,
   fk_id_cupom_primeiro INT NOT NULL,
   fk_id_cupom_segundo INT ,
   fk_id_cupom_terceiro INT );


ALTER TABLE endereco add       
   PRIMARY KEY (pk_id_endereco);

ALTER TABLE cliente add     
    PRIMARY KEY (pk_cpf_cliente);

ALTER TABLE loja add    
    PRIMARY KEY (pk_cnpj_loja);

ALTER TABLE sorteio add   
    PRIMARY KEY (pk_id_sorteio);

ALTER TABLE cupom add     
     PRIMARY KEY (pk_id_cupom);

ALTER TABLE resultado_sorteio add 
     PRIMARY KEY (pk_id_resultado_sorteio);

ALTER TABLE cliente 
add CONSTRAINT fk_id_endereco 
FOREIGN KEY (fk_id_endereco) REFERENCES endereco (pk_id_endereco);

ALTER TABLE cliente 	
add CONSTRAINT fk_cnpj_loja  
 FOREIGN KEY (fk_cnpj_loja)   REFERENCES loja     (pk_cnpj_loja);

ALTER TABLE sorteio
 add CONSTRAINT fk_cnpj_loja   
FOREIGN KEY (fk_cnpj_loja)   REFERENCES loja (pk_cnpj_loja);

ALTER TABLE cupom 
add   CONSTRAINT fk_cpf_cliente  
FOREIGN KEY (fk_cpf_cliente)  REFERENCES cliente (pk_cpf_cliente);

ALTER TABLE cupom 
add   CONSTRAINT fk_id_sorteio  
FOREIGN KEY (fk_id_sorteio)  REFERENCES sorteio (pk_id_sorteio);

ALTER TABLE cupom 	
add   CONSTRAINT fk_cnpj_loja 
FOREIGN KEY (fk_cnpj_loja)   REFERENCES loja    (pk_cnpj_loja);

ALTER TABLE resultado_sorteio 
add CONSTRAINT fk_id_cupom_primeiro  
FOREIGN KEY (fk_id_cupom_primeiro) REFERENCES cupom (pk_id_cupom);

ALTER TABLE resultado_sorteio 
add CONSTRAINT fk_id_cupom_segundo  
FOREIGN KEY (fk_id_cupom_segundo) REFERENCES cupom (pk_id_cupom);

ALTER TABLE resultado_sorteio 
add CONSTRAINT fk_id_cupom_terceiro  
FOREIGN KEY (fk_id_cupom_terceiro) REFERENCES cupom (pk_id_cupom);
