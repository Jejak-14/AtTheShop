CREATE DATABASE Attheshop;
USE Attheshop;

CREATE TABLE Kunder(
Id INT(7) AUTO_INCREMENT PRIMARY KEY,
Navn VARCHAR(80),
Nummer INT(8) UNIQUE KEY,
Email VARCHAR(100) UNIQUE KEY,
PW VARCHAR(40)
);

INSERT INTO Kunder (Navn, Nummer, Email, PW)
VALUES ("Kasper Wogelius",60186460,"kawog17@student.sdu.dk","Testhest123");
INSERT INTO Kunder (Navn, Nummer, Email, PW)
VALUES ("Anders Gaarsdal",51419698,"angaa19@student.sdu.dk","Lucifer666");
INSERT INTO Kunder (Navn, Nummer, Email, PW)
VALUES ("Michelle Larsen",21480127,"micch15@student.sdu.dk","Hestpige123");
INSERT INTO Kunder (Navn, Nummer, Email, PW)
VALUES ("Jens Hugo Jakobsen",29126199,"jejak14@student.sdu.dk","Titties123");
INSERT INTO Kunder (Navn, Nummer, Email, PW)
VALUES ("Nickolai Petersen",21199409,"nipet18@student.sdu.dk","Vestegnen18");

CREATE TABLE Biler(
Ejer VARCHAR(100),
Nummerplade VARCHAR(7) PRIMARY KEY,
Stelnummer VARCHAR(36) UNIQUE KEY,
Make VARCHAR(25),
Model VARCHAR(30),
Aargang INT(4),
Farve VARCHAR (20)
);

INSERT INTO Biler
VALUES("jejak14@student.sdu.dk", "AX51020","WF0UXXLTRUFU71973","Ford","KA",2015,"Roed");
INSERT INTO Biler
VALUES("nipet18@student.sdu.dk", "YB48945","TMBBE61Z762247037","Skoda","Octavia",2006,"Sort");
INSERT INTO Biler
VALUES("micch15@student.sdu.dk", "BG53923","JTDKG10C10N306504","Toyota","Aygo",2008,"Sort");
INSERT INTO Biler
VALUES("angaa19@student.sdu.dk", "ZL46749","JTDKG10CX0N293283","Toyota","Aygo",2008,"Roed");
INSERT INTO Biler
VALUES("micch15@student.sdu.dk", "CG43121","VF34H9HZHAS241390","Peugeot","308",2009,"Graa");
INSERT INTO Biler
VALUES("nipet18@student.sdu.dk", "VESTEGN","SIA3526DFSG326234","Porsche","911",2020,"Pink");
INSERT INTO Biler
VALUES("kawog17@student.sdu.dk", "POLOPWR","6N-2-168468765987","Volkswagen","Polo 6N2 16v",1998,"Hvid");

CREATE TABLE Ordre(
Ordrenummer INT(8) AUTO_INCREMENT PRIMARY KEY,
Pris INT(15),
Nummerplade VARCHAR(7),
Aendringer TEXT,
Besked TEXT,
Ordrestatus VARCHAR(15)
);

INSERT INTO Ordre (Pris, Nummerplade, Aendringer, Besked, Ordrestatus)
VALUES(42595,"VESTEGN","Garrett Turbo montering","Accepteret","Afsluttet");
INSERT INTO Ordre (Pris, Nummerplade, Aendringer, Besked, Ordrestatus)
VALUES(29758,"POLOPWR","Ny undervogn og bremseskiver","Accepteret","Aktiv");