<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
    <c:when test="${!user.isAuthenticated}">
        <c:redirect url="/index.jsp" />
    </c:when>
    <c:when test="${!user.role.ROLE_CLIENTE}">
        <c:redirect url="/index.jsp" />
    </c:when>
</c:choose>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet"
              href="${pageContext.request.contextPath}/resources/bootstrap-5.1.3-dist/css/bootstrap.min.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/globals.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/index.css" />
        <link href="http://fonts.cdnfonts.com/css/helvetica-255"
              rel="stylesheet">
        <script src="${pageContext.request.contextPath}/resources/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/jquery-3.5.0.min.js"></script>
        <meta charset="UTF-8">
        <title>Solicitar atendimento</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light p-4 mb-5">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp"> <img
                    src="${pageContext.request.contextPath}/images/beibe-logo.png" alt="Logotipo BEIBE" width="200"
                    height="auto" class="p-2 d-inline-block align-text-center ml-3">
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse"
                    data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false"
                    aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active"><a class="nav-link" href="main">Meus
                            atendimentos </a></li>
                    <li class="nav-item"><a class="nav-link" href="updatedata">Atualizar
                            dados</a></li>
                    <li class="nav-item"><a class="nav-link" href="asksupport">Solicitar
                            atendimento <span class="sr-only">(atual)</span>
                        </a></li>
                    <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/index.jsp"><b>Sair</b></a></li>
                </ul>
            </div>
        </nav>
        <div class="row">
            <div class="col-md-8 offset-md-2">
                <h1 class="mb-5">Solicitar atendimento</h1>
                <form method="post" action="#" class="mb-5">
                    <div class="form-row">
                        <div class="form-group col-md-6 mb-3">
                            <select class="custom-select" name="type" >
                                <option selected>Tipo do atendimento</option>
                                <c:forEach var="tipo" items="${atendimentos}">
                                    <option value="${tipo.type_id}"><c:out value="${tipo.name}"/></option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group col-md-6 mb-3">
                            <select class="custom-select" name="product">
                                <option selected>Produto envolvido</option>
                                <c:forEach var="prod" items="${products}">
                                    <option value="${prod.product_id}"><c:out value="${prod.name}"/></option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group mb-3">
                            <label class="mb-3" for="description">Descreva
                                da maneira mais detalhada possível o seu caso</label>
                            <textarea name="description" class="form-control" id="exampleFormControlTextarea1"
                                      rows="3"></textarea>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-dark">Enviar</button>
                </form>
            </div>
        </div>
    </body>
</html>