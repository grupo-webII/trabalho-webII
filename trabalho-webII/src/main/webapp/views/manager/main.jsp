<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <title>Dashboard do Gerente</title>
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
                            dos usuários<span class="sr-only"> (atual)</span>
                        </a></li>
                    <li class="nav-item active"><a class="nav-link" href="openrequests">Listagem
                            dos atendimentos em aberto
                        </a></li>
                    <li class="nav-item"><a class="nav-link" href="allsupportrequests">Listagem
                            dos atendimentos</a></li>
                    <li class="nav-item"><a class="nav-link" href="exports.jsp">Relatórios</a></li>
                    <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/logout"><b>Sair</b></a></li>
                </ul>
            </div>
        </nav>
        <main>
            <div class="row">
                <div class="col-md-8 offset-md-2">
                    <h1 class="h1">Usuários do sistema</h1>
                    <a class="mb-5 btn btn-dark" href="newuser" class="btn btn-dark">Adicionar novo</a>
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col">Hash</th>
                                <th scope="col">Tipo</th>
                                <th scope="col">Nome</th>
                                <th scope="col">E-mail</th>
                                <th scope="col">CPF</th>
                                <th scope="col">Ações</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="uzer" items="${fullusers}" >
                                <tr>
                                    <th scope="row"><c:out value="${uzer.user.user_id}" /></th>
                                    <td>
                                        <c:choose>
                                            <c:when test="${uzer.user.role.ROLE_GERENTE == true}">
                                                <c:out value="Gerente"/>
                                            </c:when>
                                            <c:when test="${uzer.user.role.ROLE_FUNC == true}">
                                                <c:out value="Funcionário"/>
                                            </c:when>
                                            <c:otherwise>
                                                <c:out value="Cliente"/>
                                            </c:otherwise>  
                                        </c:choose>
                                    </td>
                                    <td> <c:out value=" ${uzer.userData.name}"/></td>
                                    <td><c:out value="${uzer.user.email}" /></td>
                                    <td><c:out value="${uzer.userData.cpf}"/></td>
                                    <td>
                                        <a href="deleteUser?id=${uzer.user.user_id}" >
                                            <button type="button" class="btn btn-light"
                                                    >Remover
                                            </button>&nbsp;
                                        </a>



                                        <a
                                            href="userdetails?id=${uzer.user.user_id}"><button type="button"
                                                                                           class="btn btn-light">
                                                <img src="${pageContext.request.contextPath}/images/pen-to-square-solid.svg" alt="Eye icon"
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
                        <div class="modal-body">Este atendimento ainda n�o foi
                            realizado pela empresa. Se decidir esperar, em breve algum de
                            nossos atendentes entrar� em contato.</div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-light"
                                    data-bs-dismiss="modal">N�o, vou aguardar</button>
                            <button type="button" class="btn btn-danger">Sim, excluir</button>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </body>
</html>