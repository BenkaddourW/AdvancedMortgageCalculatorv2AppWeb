<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Résultats</title>
    <!-- Ajout de Bootstrap via le CDN -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-8 p-4 border rounded bg-white shadow-sm">
                <h1 class="text-center mb-4">Résultats</h1>
                
                <p class="lead">Nom de la banque : <strong>'${nomBanque}'</strong></p>
                
                <p class="lead">Taux d'assurance annuel : <strong>'${tauxAssuranceAnnuel}'</strong></p>
                
                <p class="lead">Taux d'intérêt annuel : <strong>'${tauxInteretAnnuel}'</strong></p>
                
                <div class="text-center">
                    <a href="index.html" class="btn btn-primary">Retour</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Inclusion de Bootstrap JS et des dépendances -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
