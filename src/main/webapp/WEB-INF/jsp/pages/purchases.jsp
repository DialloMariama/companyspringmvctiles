<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 04/10/2024
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div>
    <jsp:include page="welcome.jsp" />
    <div class="container mt-5">
        <div class="row">
            <div class="col-sm-6">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Liste des achats</h5>
                        <table class="table table-striped table-hover">
                            <thead>
                            <tr>
                                <th>Id</th>
                                <th>Produit</th>
                                <th>Quantité</th>
                                <th>Date</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${purchasesList}" var="purchase">
                                <tr>
                                    <td>${purchase.id}</td>
                                    <td>${purchase.product.name}</td>
                                    <td>${purchase.quantity}</td>
                                    <td>${purchase.dateP}</td>
                                </tr>
                            </c:forEach>
                            </tbody>


                        </table>
                    </div>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Ajout d'un achat</h5>
                        <form action="purchases" method="post">
                            <div class="mb-3">
                                <label for="inputProduct" class="form-label">Produit</label>
                                <select name="productRef" class="form-control" id="inputProduct" required>
                                    <c:forEach items="${productList}" var="product">
                                        <option value="${product.ref}">${product.ref} - ${product.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="mb-3">
                                <label for="inputQuantity" class="form-label">Quantité</label>
                                <input type="number" name="quantity" class="form-control" id="inputQuantity" required>
                            </div>
                            <button type="submit" class="btn btn-primary">Enregistrer</button>
                        </form>


                    </div>
                </div>
            </div>
        </div>

    </div>

</div>
