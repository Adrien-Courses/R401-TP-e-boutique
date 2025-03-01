<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Mon panier</title>
    <meta charset="UTF-8">
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        .message {
            color: green;
            font-weight: bold;
        }
        .erreur {
            color: red;
            font-weight: bold;
        }
        .total {
            font-weight: bold;
            text-align: right;
        }
    </style>
</head>
<body>
    <h1>Mon panier</h1>

    <c:choose>
        <c:when test="${empty sessionScope.panier or empty sessionScope.panier.articles}">
            <p>Votre panier est vide.</p>
        </c:when>
        <c:otherwise>
            <table>
                <thead>
                    <tr>
                        <th>Produit</th>
                        <th>Prix unitaire</th>
                        <th>Quantité</th>
                        <th>Sous-total</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="article" items="${sessionScope.panier.articles}">
                        <tr>
                            <td>${article.nom}</td>
                            <td><fmt:formatNumber value="${article.prix}" type="currency" currencySymbol="€" /></td>
                            <td>${article.quantite}</td>
                            <td><fmt:formatNumber value="${article.sousTotal}" type="currency" currencySymbol="€" /></td>
                            <td>
                                <form action="${pageContext.request.contextPath}/supprimerArticle" method="post">
                                    <input type="hidden" name="id" value="${article.id}">
                                    <input type="submit" value="Supprimer">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="3" class="total">Total :</td>
                        <td colspan="2"><fmt:formatNumber value="${sessionScope.panier.total}" type="currency" currencySymbol="€" /></td>
                    </tr>
                </tfoot>
            </table>
            
        </c:otherwise>
    </c:choose>
    
    <div style="margin-top: 20px;">
        <a href="${pageContext.request.contextPath}/catalogue">Continuer mes achats</a>
    </div>
</body>
</html>