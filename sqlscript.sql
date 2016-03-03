CREATE TABLE Treningsokt (
  okt_id int unsigned AUTO_INCREMENT NOT NULL,
  dato date,
  varighet int,
  PRIMARY KEY (okt_id)
);

CREATE TABLE OvelserTreningsokt(
  okt_id_fk int unsigned NOT NULL,
  ovelse_id_fk int unsigned NOT NULL,
  FOREIGN KEY(okt_id_fk) REFERENCES Treningsokt(okt_id) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY(ovelse_id_fk) REFERENCES Ovelse(ovelse_id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Ovelse (
  ovelse_id int unsigned AUTO_INCREMENT NOT NULL,
  navn varchar(50),
  beskrivelse varchar(255),
  PRIMARY KEY (ovelse_id)
);

/* WEAK */
CREATE TABLE Notat (
  notat_id int unsigned not null,
  personlig_form varchar(255),
  presentasjon varchar(255),
  treningsformal varchar(255),
  tips varchar(255),
  PRIMARY KEY (notat_id) REFERENCES Treningsokt(okt_id) ON DELETE CASCADE
);

CREATE TABLE Resultat (
  resultat_id int unsigned AUTO_INCREMENT NOT NULL,
  ovelse_id_fk int unsigned NOT NULL,
  PRIMARY KEY(resultat_id),
  FOREIGN KEY(ovelse_id_fk) REFERENCES Ovelse(ovelse_id)
);

CREATE TABLE Maal (
  maal_id int unsigned AUTO_INCREMENT NOT NULL,
  innen_dato date,
  PRIMARY KEY(maal_id)
);

CREATE TABLE Kategori (
  kategori_id int unsigned AUTO_INCREMENT NOT NULL,
  type varchar(50),
  PRIMARY KEY(kategori_id),
);

CREATE TABLE KategoriTilhorer (
  overkategori_id int unsigned,
  kategori_id int unsigned,
  FOREIGN KEY(overkategori_id) REFERENCES Kategori(kategori_id) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY(kategori_id) REFERENCES Kategori(kategori_id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Mal (
  mal_id int unsigned AUTO_INCREMENT NOT NULL,
  navn varchar(50),
  ovelse_id_fk int unsigned,
  FOREIGN KEY(ovelse_id_fk) REFERENCES Ovelse(ovelse_id) ON UPDATE CASCADE
);

CREATE TABLE Ovelse_i_mal (
  overkategori_id int unsigned,
  kategori_id int unsigned,
  FOREIGN KEY(overkategori_id) REFERENCES Kategori(kategori_id) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY(kategori_id) REFERENCES Kategori(kategori_id) ON UPDATE CASCADE ON DELETE CASCADE
);
