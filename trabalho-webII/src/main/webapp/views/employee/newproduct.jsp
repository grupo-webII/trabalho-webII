<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!--
GET:
POST: 
    category: ID DA CATEGORIA DO PRODUTO
    name:
    description: 
    weight:
REQUEST BEANS:
    categories: todas as categorias disponiveis
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
<title>Adicionar Produto</title>
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
	<div class="row">
		<div class="col-md-8 offset-md-2">
			<h1 class="mb-3 h1">Adicionar produto</h1>
			<form action="main.jsp" class="mb-5">
				<div class="form-row">
                                    <div class="form-group col-md-6 mb-3">
						<label for="inputShortDescriptive">Nome do produto</label> <input
							type="text" class="form-control" id="inputShortDescriptive"
							required>
					</div>
					<div class="form-group col-md-6 mb-3">
                                            <label for="inputCategory">Categoria</label><br/>
						<select id="inputCategory" class="custom-select">
							<option value="2">Maquiagem</option>
							<option value="3">Teste</option>
							<option value="3">Teste</option>
							<option value="3">Teste</option>
						</select>
					</div>
					<div class="form-group mb-3">
						<label class="mb-3" for="exampleFormControlTextarea1">Descri��o detalhada do caso</label>
						<textarea class="form-control" id="exampleFormControlTextarea1"
							rows="3" required></textarea>
					</div>
                                        <div class="form-group col-md-6 mb-3">
						<label for="inputShortDescriptive">Peso</label> <input
							type="text" class="form-control" id="inputShortDescriptive"
							required>
					</div>
				</div>
                                <button type="submit" class="btn btn-success">Incluir produto</button>
                                <a href="products.jsp" class="btn btn-dark">Voltar</a>
			</form>
		</div>
	</div>
</body>
</html>