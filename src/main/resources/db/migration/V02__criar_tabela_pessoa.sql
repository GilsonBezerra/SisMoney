CREATE TABLE pessoa(
codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(50) NOT NULL,
logradouro VARCHAR(50) NOT NULL,
numero VARCHAR(10) NOT NULL,
complemento VARCHAR(50),
bairro VARCHAR(50) NOT NULL,
cep VARCHAR(50) NOT NULL,
cidade VARCHAR(50) NOT NULL,
estado VARCHAR(50) NOT NULL

) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Gilson', 'Rua Michel Besson',
 '210', 'casa', 'Jardim Silveira', '04892-030', 'São Paulo', 'São Paulo');

