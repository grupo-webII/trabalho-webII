<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 
GET: 
    id=(id do atendimento) 
POST: 
    id=(id do atendimento), 
    solution=(solucao para adicionar)
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
        <title>Descrição do atendimento - Funcionrio</title>
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
                            dos atendimentos em aberto
                        </a></li>
                    <li class="nav-item"><a class="nav-link" href="allsupportrequests">Listagem
                            dos atendimentos <span class="sr-only"> (atual)</span></a></li>
                    <li class="nav-item"><a class="nav-link" href="categories">Listagem
                            de categorias</a></li>
                    <li class="nav-item"><a class="nav-link" href="products">Listagem
                            de produtos</a></li>
                    <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/index.jsp"><b>Sair</b></a></li>
                </ul>
            </div>
        </nav>
        <div class="row">
            <div class="col-md-8 offset-md-2">
                <h1 class="mb-3 h1">Descrição do atendimento #1</h1>
                <div class="ml-0 pl-0 supportInfo container d-inline-flex">
                    <h4 class="mb-5 h4"><b><c:out value="${userdata.name} ${userdata.lastname}" /></b></h4>&nbsp;&nbsp;&nbsp;&nbsp;
                    <h4 class="mb-5 h4"><b><c:out value="| ${atendimento.data}" /></b></h4>&nbsp;&nbsp;&nbsp;&nbsp;
                    <h4 class="mb-5 h4" ><b><c:out value=" | Status:  ${atendimento.status}" /></b></h4>
                </div>
                <form action="" method="post" class="mb-5">
                    <div class="form-row">
                        <div class="form-group col-md-6 mb-3">
                            <select class="custom-select" disabled>
                                <option value="${atendimento.type.type_id}"><c:out value="${atendimento.type.name}" /></option>
                            </select>
                        </div>
                        <div class="form-group col-md-6 mb-3">
                            <select class="custom-select" disabled>
                                <option value="${atendimento.product.product_id}"><c:out value="${atendimento.product.name}" />  </option>
                            </select>
                        </div>
                        <div class="form-group mb-3">
                            <label class="mb-3" for="exampleFormControlTextarea1">Descrição detalhada do caso</label>
                            <textarea class="form-control" id="exampleFormControlTextarea1" value="${atendimento.description}"
                                      rows="3" disabled><c:out value="${atendimento.description}" /></textarea>
                        </div>
                        <div class="form-group mb-3">
                            <label class="mb-3" for="solution" style="font-weight: bold;"">Resolução</label>
                            <textarea class="form-control" id="exampleFormControlTextarea1" name="solution" 
                                      rows="3" required><c:out value="${atendimento.solution}" /></textarea>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-success">Enviar resolução</button>
                    <a href="main" class="btn btn-dark">Voltar</a>
                </form>
            </div>
        </div>
    </body>
</html>