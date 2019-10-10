CREATE TABLE pessoa(
codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(50) NOT NULL,
ativo BOOLEAN,
logradouro VARCHAR(50) NOT NULL,
numero VARCHAR(10) NOT NULL,
complemento VARCHAR(50),
bairro VARCHAR(50) NOT NULL,
cep VARCHAR(50) NOT NULL,
cidade VARCHAR(50) NOT NULL,
estado VARCHAR(50) NOT NULL

) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Gilson Francisco Bezerra', 'Rua Michel Besson',
 '210', 'casa', 'Jardim Silveira', '04892-030', 'São Paulo', 'São Paulo');
 INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Aurea Maria Silva Bezerra', 'Rua Michel Besson',
 '210', 'casa', 'Jardim Silveira', '04892-030', 'São Paulo', 'São Paulo');
 INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Larah Rihanne Silva Bezerra', 'Rua Michel Besson',
 '210', 'casa', 'Jardim Silveira', '04892-030', 'São Paulo', 'São Paulo');
 INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Aldo Pereira Silva', 'Rua Bernardo Calvo',
 '168', 'Antigo 13C', 'Jardim Silveira', '04892-050', 'São Paulo', 'São Paulo');
 INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Verônica Maria Pereira Silva', 'Rua Bernardo Calvo',
 '168', 'Antigo 13C', 'Jardim Silveira', '04892-050', 'São Paulo', 'São Paulo');
 INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Alex Pereira Silva', 'Rua Ricardo Vini',
 '150', 'casa', 'Jardim Silveira', '04892-090', 'São Paulo', 'São Paulo');
 INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Kezia Maximino', 'Rua Ricardo Vini',
 '150', 'casa', 'Jardim Silveira', '04892-090', 'São Paulo', 'São Paulo');

