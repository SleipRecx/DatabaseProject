CREATE TABLE Treningsokt (
  oktID int unsigned AUTO_INCREMENT NOT NULL,
  dato date,
  varighet int,
  PRIMARY KEY (oktID),
);

CREATE TABLE OvelserTreningsokt(
  oktID_fk int unsigned NOT NULL,
  ovelseID_fk int unsigned NOT NULL,
  FOREIGN KEY(oktID_fk) REFERENCES Treningsokt(oktID) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY(ovelseID_fk) REFERENCES Ovelse(id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Ovelse (
  id int unsigned AUTO_INCREMENT NOT NULL,
  navn varchar(50),
  beskrivelse varchar(255),
  PRIMARY KEY (id),
);
