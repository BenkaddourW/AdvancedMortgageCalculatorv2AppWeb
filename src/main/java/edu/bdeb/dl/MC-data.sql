INSERT INTO Banque (nom, tauxAssuranceAnnuel, tauxInteretAnnuel)
VALUES
    ('Banque Nationale', 0.05, 9.65),
    ('BMO', 0.05, 4.94),
    ('Banque Royale du Canada', 0.05, 4.89),
    ('Desjardins', 0.05, 6.39);

INSERT INTO Produit (type, description)
VALUES
    -- Produits hypothécaires
    ('Mortgage', 'Prêt à taux fixe pour une durée de 1 an.'),
    ('Mortgage', 'Prêt à taux fixe pour une durée de 3 ans.'),
    ('Mortgage', 'Prêt à taux fixe pour une durée de 3 ans.'),
    ('Mortgage', 'Prêt à taux fixe pour une durée de 5 ans.'),
    -- Produits d\'assurance
    ('Insurance', 'Assurance vie à taux fixe.'),
    ('Insurance', 'Assurance maladie pour famille.'),
    -- Comptes d\'épargne
    ('Savings Account', 'Compte d\'épargne à intérêt élevé.'),
    ('Savings Account', 'Compte d\'épargne avec carte de débit.'),
    -- Comptes chèques
    ('Checking Account', 'Compte courant sans frais mensuels.'),
    ('Checking Account', 'Compte courant avec carte de crédit.');

INSERT INTO Banque_Produit (banque_id, produit_id)
VALUES
    -- Banque Nationale
    (1, 1), -- Mortgage (1 an)
    (1, 5), -- Insurance (vie)
    (1, 9), -- Checking Account (sans frais)

    -- BMO
    (2, 2), -- Mortgage (3 ans)
    (2, 6), -- Insurance (maladie)
    (2, 10), -- Checking Account (carte de crédit)

    -- Banque Royale du Canada
    (3, 3), -- Mortgage (3 ans)
    (3, 7), -- Savings Account (intérêt élevé)

    -- Desjardins
    (4, 4), -- Mortgage (5 ans)
    (4, 8); -- Savings Account (carte de débit)
