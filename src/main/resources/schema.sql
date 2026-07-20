CREATE TABLE remise (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        montant_min DOUBLE,
                        montant_max DOUBLE,
                        taux DOUBLE
);

CREATE TABLE transactions (
                              id BIGINT AUTO_INCREMENT PRIMARY KEY,
                              date TIMESTAMP,
                              montant_avant DOUBLE,
                              montant_apres DOUBLE,
                              remise_id BIGINT,
                              FOREIGN KEY (remise_id) REFERENCES remise(id)
);

CREATE TABLE utilisateurs (
                              id     BIGINT AUTO_INCREMENT PRIMARY KEY,
                              nom    VARCHAR(50),
                              prenom VARCHAR(50)
);