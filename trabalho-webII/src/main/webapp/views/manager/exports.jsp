<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
    <c:when test="${!user.isAuthenticated}">
        <c:redirect url="/index.jsp" />
    </c:when>
    <c:when test="${!user.role.ROLE_GERENTE}">
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
        <title>Relat�rios</title>
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
                    <li class="nav-item active"><a class="nav-link" href="main">Listagem
                            dos usu�rios
                        </a></li>
                    <li class="nav-item active"><a class="nav-link" href="openrequests">Listagem
                            dos atendimentos em aberto
                        </a></li>
                    <li class="nav-item"><a class="nav-link" href="allsupportrequests">Listagem
                            dos atendimentos</a></li>
                    <li class="nav-item"><a class="nav-link" href="exports.jsp">Relat�rios<span class="sr-only"> (atual)</span></a></li>
                    <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/logout"><b>Sair</b></a></li>
                </ul>
            </div>
        </nav>
        <main>
            <div class="row">
                <div class="col-md-8 offset-md-2">
                    <h1 class="mb-5 h1">Gerar relat�rios</h1>
                    <table class="table table-hover">
                        <tbody>
                            <tr>
                                <th scope="row">Relat�rio de funcion�rios</th>
                                <td></td>
                                <td><a
                                        href="supportdescription"><button type="button"
                                                                      class="btn btn-light">
                                            Gerar
                                        </button></a></td>
                            </tr>
                            <tr>
                                <th scope="row">Relat�rio de Produtos Mais Reclamados</th>
                                <td></td>
                                <td><a
                                        href="supportdescription"><button type="button"
                                                                      class="btn btn-light">
                                            Gerar
                                        </button></a></td>
                            </tr>
                            <tr>
                                <th scope="row">Relat�rio de Atendimentos em Aberto Por Data</th>
                                <td><label for="inputCategory">Data In�cio</label><br/>
                                    <input id="date" type="date"><br/><label for="inputCategory">Data Fim</label><br/>
                                    <input id="date" type="date">
                                </td>
                                <td><a
                                        href="supportdescription"><button type="button"
                                                                      class="btn btn-light">
                                            Gerar
                                        </button></a></td>
                            </tr>
                            <tr>
                                <th scope="row">Relat�rio de Reclama��es</th>
                                <td><label for="inputCategory">Categoria</label><br/>
                                    <select id="inputCategory" class="custom-select">
                                        <option value="2">Todas</option>
                                        <option value="3">Em aberto</option>
                                        <option value="3">Finalizadas</option>
                                    </select></td>
                                <td><a
                                        href="supportdescription"><button type="button"
                                                                      class="btn btn-light">
                                            Gerar
                                        </button></a></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </main>
    </body>
</html>