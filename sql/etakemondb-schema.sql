drop database if exists etakemondb;
create database etakemondb;

use etakemondb;

CREATE TABLE etakemon (
    id INTEGER NOT NULL auto_increment,
    tipus ENUM ('director', 'professor', 'alumne') NOT NULL,
    nom VARCHAR(100) NOT NULL,
    descripcio VARCHAR(500) NOT NULL,
    puntuacio INTEGER NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE user (
    id INTEGER NOT NULL auto_increment,
    loginid VARCHAR(15) NOT NULL UNIQUE,
    password BINARY(16) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE relacionUserEtakemons (
	id INTEGER AUTO_INCREMENT NOT NULL,
	idUser INTEGER NOT NULL,
	idEtakemon INTEGER NOT NULL,
	FOREIGN KEY (idUser) REFERENCES user(id) on delete cascade,
	FOREIGN KEY (idEtakemon) REFERENCES etakemon(id) on delete cascade,
	PRIMARY KEY (id)
);


INSERT INTO etakemon (tipus, nom, descripcio, puntuacio) VALUES ("director", "lluis", "director de l'escola", "200");
INSERT INTO etakemon (tipus, nom, descripcio, puntuacio) VALUES ("professor", "Toni", "professor de DSA", "100");
INSERT INTO etakemon (tipus, nom, descripcio, puntuacio) VALUES ("alumne", "oriol", "alumne de la EETAC", "50");
INSERT INTO user (loginid, password) VALUES ("oriol", "1234");
