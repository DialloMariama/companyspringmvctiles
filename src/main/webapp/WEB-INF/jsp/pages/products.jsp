<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 04/10/2024
  Time: 19:28
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
                        <h5 class="card-title">Liste Produits</h5>
                        <table class="table table-striped table-hover">
                            <thead>
                            <tr>
                                <th>Reference</th>
                                <th>Nom</th>
                                <th>Stock</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${productList}" var="product">
                                <tr>
                                    <td>${product.ref}</td>
                                    <td>${product.name}</td>
                                    <td>${product.stock}</td>
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
                        <h5 class="card-title">Ajout Produit</h5>
                        <form action="products" method="post">
                            <div class="mb-3">
                                <label for="inputRef" class="form-label">Reference</label>
                                <input type="text" name="ref" class="form-control" id="inputRef">
                            </div>
                            <div class="mb-3">
                                <label for="inputName" class="form-label">Nom</label>
                                <input type="text" name="name" class="form-control" id="inputName">
                            </div>
                            <div class="mb-3">
                                <label for="inputStock" class="form-label">Stock</label>
                                <input type="number" name="stock" class="form-control" id="inputStock">
                            </div>
                            <button type="submit" class="btn btn-primary">Ajouter Produit</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
