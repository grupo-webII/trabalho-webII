<%@ page language="java" contentType="text/html; UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!--
BEANS:
    allProducts: todos os produtos disponiveis
-->


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
        <title>Produtos</title>
    </head>
    <body>
        <c:forEach var="prod" items="${allProducts}">  
            <c:out value="${prod.product_id}"></c:out>
            <c:out value="${prod.category.name}"></c:out>
            <c:out value="${prod.name}"></c:out>
            <c:out value="${prod.description}"></c:out>
            <c:out value="${prod.weight}"></c:out>
        </c:forEach>
        <nav class="navbar navbar-expand-lg navbar-light bg-light p-4 mb-5">
            <a class="navbar-brand" href="../../index.jsp"> <img
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
                    <li class="nav-item active"><a class="nav-link" href="main.jsp">Listagem
                            dos atendimentos em aberto
                        </a></li>
                    <li class="nav-item"><a class="nav-link" href="allsupportrequests.jsp">Listagem
                            dos atendimentos</a></li>
                    <li class="nav-item"><a class="nav-link" href="categories.jsp">Listagem
                            de categorias</a></li>
                    <li class="nav-item"><a class="nav-link" href="products.jsp">Listagem
                            de produtos<span class="sr-only"> (atual)</span></a></li>
                    <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/index.jsp"><b>Sair</b></a></li>
                </ul>
            </div>
        </nav>
        <main>
            <div class="row">
                <div class="col-md-8 offset-md-2">
                    <h1 class="h1">Produtos</h1>
                    <a class="mb-5 btn btn-dark" href="newproduct.jsp" class="btn btn-dark">Adicionar novo</a>
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col">Hash</th>
                                <th scope="col">Nome</th>
                                <th scope="col">Categoria</th>
                                <th scope="col">Peso</th>
                                <th scope="col">Ações</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th scope="row">1</th>
                                <td>Pó Facial Mariazinha</td>
                                <td>Maquiagem</td>
                                <td>50g</td>
                                <td><button type="button" class="btn btn-light"
                                            data-bs-toggle="modal" data-bs-target="#exampleModal">Remover</button>&nbsp;<a
                                            href="productdetails.jsp"><button type="button"
                                                                      class="btn btn-light">
                                            <img src="${pageContext.request.contextPath}/images/eye-solid.svg" alt="Eye icon"
                                                 width="20" height="auto" class="">
                                        </button></a>&nbsp;<a
                                        href="productdetails.jsp"><button type="button"
                                                                      class="btn btn-light">
                                            <img src="${pageContext.request.contextPath}/images/pen-to-square-solid.svg" alt="Eye icon"
                                                 width="20" height="auto" class="">
                                        </button></a></td>
                            </tr>
                            <tr>
                                <th scope="row">2</th>
                                <td>Pó Facial Mariazinha</td>
                                <td>Maquiagem</td>
                                <td>50g</td>
                                <td><button type="button" class="btn btn-light"
                                            data-bs-toggle="modal" data-bs-target="#exampleModal">Remover</button>&nbsp;<a
                                            href="productdetails.jsp"><button type="button" class="btn btn-light">
                                            <img src="${pageContext.request.contextPath}/images/eye-solid.svg" alt="Eye icon"
                                                 width="20" height="auto" class="">
                                        </button></a>&nbsp;<a
                                        href="productdetails.jsp"><button type="button"
                                                                      class="btn btn-light">
                                            <img src="${pageContext.request.contextPath}/images/pen-to-square-solid.svg" alt="Eye icon"
                                                 width="20" height="auto" class="">
                                        </button></a></td>
                            </tr>
                            <tr>
                                <th scope="row">3</th>
                                <td>Pó Facial Mariazinha</td>
                                <td>Maquiagem</td>
                                <td>50g</td>
                                <td><button type="button" class="btn btn-dark">Remover</button>&nbsp;<a
                                        href="productdetails.jsp"><button type="button" class="btn btn-light">
                                            <img src="${pageContext.request.contextPath}/images/eye-solid.svg" alt="Eye icon"
                                                 width="20" height="auto" class="">
                                        </button></a>&nbsp;<a
                                        href="productdetails.jsp"><button type="button"
                                                                      class="btn btn-light">
                                            <img src="${pageContext.request.contextPath}/images/pen-to-square-solid.svg" alt="Eye icon"
                                                 width="20" height="auto" class="">
                                        </button></a></td>
                            </tr>
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
                        <div class="modal-body">Este atendimento ainda não foi
                            realizado pela empresa. Se decidir esperar, em breve algum de
                            nossos atendentes entrará em contato.</div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-light"
                                    data-bs-dismiss="modal">Não, vou aguardar</button>
                            <button type="button" class="btn btn-danger">Sim, excluir</button>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </body>
</html>