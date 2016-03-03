CREATE TABLE Treningsokt (
  okt_id int unsigned AUTO_INCREMENT NOT NULL,
  dato date,
  varighet int,
  PRIMARY KEY (okt_id)
);

/* weak */
CREATE TABLE Notat (
  notat_id int unsigned not null PRIMARY KEY
  REFERENCES Treningsokt(okt_id) ON DELETE CASCADE ON UPDATE CASCADE,
  personlig_form int(1),
  presentasjon int(1),
  treningsformal varchar(255),
  tips varchar(255)
);

CREATE TABLE Ovelse (
  ovelse_id int unsigned AUTO_INCREMENT NOT NULL,
  kategori_id_fk int unsigned,
  navn varchar(50),
  beskrivelse varchar(255),
  PRIMARY KEY (ovelse_id)
  FOREIGN KEY kategori_id_fk REFERENCES Kategori(kategori_id) ON UPDATE CASCADE ON DELETE SET NULL
);

CREATE TABLE Resultat (
  resultat_id int unsigned AUTO_INCREMENT NOT NULL,
  ovelse_id_fk int unsigned NOT NULL,
  treningsokt_id_fk int unsigned NOT NULL,
  PRIMARY KEY(resultat_id),
  FOREIGN KEY(ovelse_id_fk) REFERENCES Ovelse(ovelse_id),
  FOREIGN KEY(treningsokt_id_fk) REFERENCES Treningsokt(okt_id)
);

CREATE TABLE Maal (
  maal_id int unsigned AUTO_INCREMENT NOT NULL,
  ovelse_id_fk int unsigned,
  innen_dato date,
  PRIMARY KEY(maal_id)
);

CREATE TABLE Kategori (
  kategori_id int unsigned AUTO_INCREMENT NOT NULL,
  type varchar(50),
  PRIMARY KEY(kategori_id)
);

CREATE TABLE Mal (
  mal_id int unsigned AUTO_INCREMENT NOT NULL,
  navn varchar(50),
  ovelse_id_fk int unsigned,
  maal_aktiv smallint,
  PRIMARY KEY(mal_id),
  FOREIGN KEY(ovelse_id_fk) REFERENCES Ovelse(ovelse_id) ON UPDATE CASCADE
);


/* -------------- SPLEISETABELLER -------------- */
CREATE TABLE Kan_erstatte_ovelse (
  ovelse_id_fk int unsigned NOT NULL,
  kan_erstatte_id_fk int unsigned NOT NULL,
  FOREIGN KEY(ovelse_id_fk) REFERENCES Ovelse(ovelse_id) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY(kan_erstatte_id_fk) REFERENCES Ovelse(ovelse_id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Kategori_tilhorer (
  overkategori_id_fk int unsigned NOT NULL,
  kategori_id_fk int unsigned NOT NULL,
  FOREIGN KEY(overkategori_id_fk) REFERENCES Kategori(kategori_id) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY(kategori_id_fk) REFERENCES Kategori(kategori_id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Ovelse_i_mal (
  mal_id_fk int unsigned,
  ovelse_id_fk int unsigned,
  FOREIGN KEY(mal_id_fk) REFERENCES Mal(mal_id) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY(ovelse_id_fk) REFERENCES Ovelse(ovelse_id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Ovelser_i_treningsokt(
  okt_id_fk int unsigned NOT NULL,
  ovelse_id_fk int unsigned NOT NULL,
  FOREIGN KEY(okt_id_fk) REFERENCES Treningsokt(okt_id) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY(ovelse_id_fk) REFERENCES Ovelse(ovelse_id) ON UPDATE CASCADE ON DELETE CASCADE
);


/* -------------- ARVETABELLER -------------- */
CREATE TABLE Utendorstrening (
  okt_id_fk int unsigned,
  vaerforhold varchar(255),
  temp decimal(3,1),
  FOREIGN KEY (okt_id_fk) REFERENCES Treningsokt(okt_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Innendorstrening (
  okt_id_fk int unsigned,
  ventilasjon varchar(255),
  ant_tilskuere int,
  FOREIGN KEY(okt_id_fk) REFERENCES Treningsokt(okt_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Styrke_kondisjon_til_resultat (
  resultat_id_fk int unsigned,
  belastning int,
  reps int,
  ant_sett int,
  FOREIGN KEY(resultat_id_fk) REFERENCES Resultat(resultat_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Utholdenhet_til_resultat (
  resultat_id_fk int unsigned,
  km decimal(10,2),
  tid int,
  FOREIGN KEY(resultat_id_fk) REFERENCES Resultat(resultat_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Styrke_kondisjon_til_maal (
  maal_id_fk int unsigned,
  belastning int,
  reps int,
  FOREIGN KEY(maal_id_fk) REFERENCES Maal(maal_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Utholdenhet_til_maal (
  maal_id_fk int unsigned,
  km decimal(10,2),
  tid int,
  FOREIGN KEY(maal_id_fk) REFERENCES Maal(maal_id) ON DELETE CASCADE ON UPDATE CASCADE
);
