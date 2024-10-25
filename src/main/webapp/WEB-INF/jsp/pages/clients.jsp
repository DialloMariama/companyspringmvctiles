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
                        <h5 class="card-title">Liste des clients</h5>
                        <table class="table table-striped table-hover">
                            <thead>
                            <tr>
                                <th>Prénom</th>
                                <th>Nom</th>
                                <th>Email</th>
                                <th>Téléphone</th>
                                <th>Adresse</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${clientList}" var="client">
                                <tr>
                                    <td>${client.firstName}</td>
                                    <td>${client.lastName}</td>
                                    <td>${client.email}</td>
                                    <td>${client.tel}</td>
                                    <td>${client.address}</td>
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
                        <h5 class="card-title">Ajout d'un client</h5>
                        <form action="clients" method="post">
                            <div class="mb-3">
                                <label for="inputFirstName" class="form-label">Prénom</label>
                                <input type="text" name="firstName" class="form-control" id="inputFirstName" required>
                            </div>
                            <div class="mb-3">
                                <label for="inputLastName" class="form-label">Nom</label>
                                <input type="text" name="lastName" class="form-control" id="inputLastName" required>
                            </div>
                            <div class="mb-3">
                                <label for="inputEmail" class="form-label">Email</label>
                                <input type="email" name="email" class="form-control" id="inputEmail" required>
                            </div>
                            <div class="mb-3">
                                <label for="inputTel" class="form-label">Téléphone</label>
                                <input type="text" name="tel" class="form-control" id="inputTel" required>
                            </div>
                            <div class="mb-3">
                                <label for="inputAddress" class="form-label">Adresse</label>
                                <input type="text" name="address" class="form-control" id="inputAddress">
                            </div>
                            <button type="submit" class="btn btn-primary">Ajouter Client</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
