CREATE TABLE IF NOT EXISTS endereco (
    codigo INT PRIMARY KEY AUTO_INCREMENT,
    cep CHAR(9),
    rua VARCHAR(80) NOT NULL,
    numero CHAR(6) NOT NULL,
    complemento VARCHAR(30),
    bairro VARCHAR(80) NOT NULL,
    cidade VARCHAR(80) NOT NULL,
    estado CHAR(2),
    cliente_codigo INT,
    CONSTRAINT fk_cliente_endereco FOREIGN KEY(cliente_codigo) REFERENCES cliente(codigo)
)  ENGINE=INNODB;

