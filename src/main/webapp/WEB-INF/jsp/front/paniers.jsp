<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<body>
<h2>Liste Paniers</h2>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Date</th>
        <th>Client</th>
        <th>Produits</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="panier" items="${panierList}">
        <tr>
            <td>${panier.id}</td>
            <td>${panier.date}</td>
            <td>${panier.client.firstName} ${panier.client.lastName}</td>
            <td>
                <ul>
                    <c:forEach var="produit" items="${panier.produits}">
                        <li>${produit.name} - Stock: ${produit.stock}</li>
                    </c:forEach>
                </ul>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

    <h3>Ajouter un produit</h3>

    <label for="client">Sélectionner le Client :</label>
    <form:select path="clientId" id="client">
        <form:option value="" label="-- Choisir un client --" />
        <c:forEach var="client" items="${clientList}">
            <form:option value="${client.id}" label="${client.firstName} ${client.lastName}" />
        </c:forEach>
    </form:select>

    <br><br>

    <label for="produit">Sélectionner le Produit :</label>
    <form:select path="productId" id="produit">
        <form:option value="" label="-- Choisir un produit --" />
        <c:forEach var="product" items="${productList}">
            <form:option value="${product.ref}" label="${product.name} - Stock: ${product.stock}" />
        </c:forEach>
    </form:select>

    <br><br>

    <label for="quantity">Quantité :</label>
    <form:input path="quantity" type="number" min="1" />

    <br><br>

    <input type="submit" value="Ajouter au Panier" />
</body>
</html>

