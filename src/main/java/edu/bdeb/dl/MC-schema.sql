-- Table pour la banque
-- Table pour les banques
-- Table Banque
CREATE TABLE Banque (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    tauxAssuranceAnnuel FLOAT NOT NULL,
    tauxInteretAnnuel FLOAT NOT NULL
);

-- Table Produit
CREATE TABLE Produit (
    id INT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(255) NOT NULL,
    description TEXT NOT NULL
);

-- Table d'association pour la relation many-to-many
CREATE TABLE Banque_Produit (
    banque_id INT NOT NULL,
    produit_id INT NOT NULL,
    PRIMARY KEY (banque_id, produit_id),
    FOREIGN KEY (banque_id) REFERENCES Banque(id) ON DELETE CASCADE,
    FOREIGN KEY (produit_id) REFERENCES Produit(id) ON DELETE CASCADE
);
