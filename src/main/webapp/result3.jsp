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

                <c:choose>
                    <c:when test="${not empty banques}">
                        <h2>Banques trouvées :</h2>
                        <ul class="list-group">
                            <c:forEach var="banque" items="${banques}">
                                <li class="list-group-item">
                                    <p><strong>Nom de la banque :</strong> ${banque.nom}</p>
                                    <p><strong>Taux d'assurance annuel :</strong> ${banque.tauxAssuranceAnnuel}%</p>
                                    <p><strong>Taux d'intérêt annuel :</strong> ${banque.tauxInteretAnnuel}%</p>
                                </li>
                            </c:forEach>
                        </ul>
                    </c:when>
                    <c:otherwise>
                        <p>Aucune banque avec ce type de produit n'existe.</p>
                    </c:otherwise>
                </c:choose>
                
                <div class="text-center mt-4">
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
