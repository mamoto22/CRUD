SELECT * FROM sitedeviagems.usuarios;



CREATE TABLE destinoIda 
( 
 iddestinoIda INT PRIMARY KEY AUTO_INCREMENT,  
 nomeDestino VARCHAR(255),  
 dataVoo DATE,  
 horarioEmbarque TIME,  
 descricaoPassagem VARCHAR(255),  
 idCliente INT  
);






CREATE TABLE Cliente 
( 
 idCliente INT PRIMARY KEY AUTO_INCREMENT,  
 nomeCliente VARCHAR(255),  
 cpfCliente VARCHAR(13),  
 enderecoCliente VARCHAR(255),  
 telefoneCliente VARCHAR(15),  
 idLoginCadastro INT(255)  
);




CREATE TABLE destinoVolta 
( 
 iddestinoVolta INT PRIMARY KEY AUTO_INCREMENT,  
 descricaoPassagem VARCHAR(255),  
 nomeDestino VARCHAR(255),  
 horarioEmbarque DATETIME,  
 dataVoo DATE,  
 iddestinoIda INT
);


CREATE TABLE login_cadastro 
( 
 senhaUsuario VARCHAR(255),  
 idUsuario INT PRIMARY KEY AUTO_INCREMENT,  
 cpfUsuario VARCHAR(13),  
 userNameUsuario VARCHAR(255),  
 telefoneUsuario VARCHAR(15)  
);



ALTER TABLE destinoIda ADD FOREIGN KEY (idCliente) REFERENCES Cliente (idCliente);
ALTER TABLE Cliente ADD FOREIGN KEY (idLoginCadastro) REFERENCES login_cadastro (idUsuario);
ALTER TABLE destinoVolta ADD FOREIGN KEY (iddestinoIda) REFERENCES destinoIda (iddestinoIda);
