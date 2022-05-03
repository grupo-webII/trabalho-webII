<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!--
BEAN:
 atendimentos: todos os atendiimentos abertos
-->
<c:choose>
    <c:when test="${!user.isAuthenticated}">
        <c:redirect url="/index.jsp" />
    </c:when>
    <c:when test="${!user.role.ROLE_FUNC}">
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
        <title>Dashboard do Funcionário</title>
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
                            dos atendimentos em aberto<span class="sr-only"> (atual)</span>
                        </a></li>
                    <li class="nav-item"><a class="nav-link" href="allsupportrequests">Listagem
                            dos atendimentos</a></li>
                    <li class="nav-item"><a class="nav-link" href="categories">Listagem
                            de categorias</a></li>
                    <li class="nav-item"><a class="nav-link" href="products">Listagem
                            de produtos</a></li>
                    <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/logout"><b>Sair</b></a></li>
                </ul>
            </div>
        </nav>
        <main>
            <div class="row">
                <div class="col-md-8 offset-md-2">
                    <h1 class="mb-5 h1">Atendimentos em aberto</h1>
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col">Hash</th>
                                <th scope="col">Status</th>
                                <th scope="col">Cliente</th>
                                <th scope="col">Descrição</th>
                                <th scope="col">Data</th>
                                <th scope="col">Editar</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="atend" items="${atendimentos}">
                                <tr>
                                    <th scope="row"><c:out value="${atend.at_id}" /></th>
                                    <td ><c:out value="${atend.status}" /></td>
                                    <td><c:out value="${atend.client.email}" /></td>
                                    <td><c:out value="${atend.description}" /></td>
                                    <td><c:out value="${atend.data}" /></td>
                                    <td><a
                                            href="supportdescription?id=${atend.at_id}"><button type="button"
                                                                              class="btn btn-light">
                                                <img src="${pageContext.request.contextPath}/images/pen-to-square-solid.svg" alt="Pen icon"
                                                     width="20" height="auto" class="">
                                            </button></a></td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>

            <!-- Modal -->
            <div class="modal fade" id="exampleModal" tabindex="-1"
                 aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Tem certeza
                                que quer excluir este atendimento?</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                        </div>
                        <div class="modal-body">Este atendimento ainda nï¿½o foi
                            realizado pela empresa. Se decidir esperar, em breve algum de
                            nossos atendentes entrarï¿½ em contato.</div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-light"
                                    data-bs-dismiss="modal">Nï¿½o, vou aguardar</button>
                            <button type="button" class="btn btn-danger">Sim, excluir</button>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </body>
</html>