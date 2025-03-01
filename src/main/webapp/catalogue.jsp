<!DOCTYPE html>
<html>
<head>
    <title>Catalogue de produits</title>
    <meta charset="UTF-8">
    <style>
        .produit {
            border: 1px solid #ddd;
            padding: 10px;
            margin: 10px;
            float: left;
            width: 200px;
        }
        .message {
            color: green;
            font-weight: bold;
        }
        .erreur {
            color: red;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <h1>Catalogue de produits</h1>
    
    <div>
        <a href="${pageContext.request.contextPath}/afficherPanier">
            Voir mon panier 
            <c:if test="${not empty sessionScope.panier}">
                (${sessionScope.panier.nombreArticles} article(s))
            </c:if>
        </a>
    </div>
    
    <!-- Liste des produits (normalement, ces données proviendraient d'une base de données) -->
    <div class="produit">
        <h3>Smartphone XYZ</h3>
        <p>Prix: 599.99 euro</p>
        <form action="${pageContext.request.contextPath}/ajouterAuPanier" method="post">
            <input type="hidden" name="id" value="1">
            <input type="hidden" name="nom" value="Smartphone XYZ">
            <input type="hidden" name="prix" value="599.99">
            <input type="submit" value="Ajouter au panier">
        </form>
    </div>
    
    <div class="produit">
        <h3>Ordinateur portable ABC</h3>
        <p>Prix: 899.99 euro</p>
        <form action="${pageContext.request.contextPath}/ajouterAuPanier" method="post">
            <input type="hidden" name="id" value="2">
            <input type="hidden" name="nom" value="Ordinateur portable ABC">
            <input type="hidden" name="prix" value="899.99">
            <input type="submit" value="Ajouter au panier">
        </form>
    </div>
    
    <div class="produit">
        <h3>Casque audio DEF</h3>
        <p>Prix: 129.99 euro</p>
        <form action="${pageContext.request.contextPath}/ajouterAuPanier" method="post">
            <input type="hidden" name="id" value="3">
            <input type="hidden" name="nom" value="Casque audio DEF">
            <input type="hidden" name="prix" value="129.99">
            <input type="submit" value="Ajouter au panier">
        </form>
    </div>
</body>
</html>