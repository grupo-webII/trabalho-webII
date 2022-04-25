<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!--BEANS:
    categories: LIST de todas as cetegorias
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
<title>Categorias</title>
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
						de categorias<span class="sr-only"> (atual)</span></a></li>
				<li class="nav-item"><a class="nav-link" href="products.jsp">Listagem
						de produtos</a></li>
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/index.jsp"><b>Sair</b></a></li>
			</ul>
		</div>
	</nav>
	<main>
		<div class="row">
			<div class="col-md-8 offset-md-2">
				<h1 class="h1">Categorias</h1>
                                <a class="mb-5 btn btn-dark" href="newcategory.jsp" class="btn btn-dark">Adicionar nova</a>
				<table class="table table-hover">
					<thead>
						<tr>
							<th scope="col">Hash</th>
							<th scope="col">Nome</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th scope="row">1</th>
							<td>Maquiagem</td>
							<td><button type="button" class="btn btn-light"
									data-bs-toggle="modal" data-bs-target="#exampleModal">Remover</button>&nbsp;<a
								href="categorydetails.jsp"><button type="button"
										class="btn btn-light">
										<img src="${pageContext.request.contextPath}/images/eye-solid.svg" alt="Eye icon"
											width="20" height="auto" class="">
									</button></a>&nbsp;<a
								href="categorydetails.jsp"><button type="button"
										class="btn btn-light">
										<img src="${pageContext.request.contextPath}/images/pen-to-square-solid.svg" alt="Eye icon"
											width="20" height="auto" class="">
									</button></a></td>
						</tr>
						<tr>
							<th scope="row">2</th>
							<td>Maquiagem</td>
							<td><button type="button" class="btn btn-light"
									data-bs-toggle="modal" data-bs-target="#exampleModal">Remover</button>&nbsp;<a
								href="categorydetails.jsp"><button type="button" class="btn btn-light">
										<img src="${pageContext.request.contextPath}/images/eye-solid.svg" alt="Eye icon"
											width="20" height="auto" class="">
									</button></a>&nbsp;<a
								href="categorydetails.jsp"><button type="button"
										class="btn btn-light">
										<img src="${pageContext.request.contextPath}/images/pen-to-square-solid.svg" alt="Eye icon"
											width="20" height="auto" class="">
									</button></a></td>
						</tr>
						<tr>
							<th scope="row">3</th>
							<td>Maquiagem</td>
							<td><button type="button" class="btn btn-dark">Remover</button>&nbsp;<a
								href="categorydetails.jsp"><button type="button" class="btn btn-light">
										<img src="${pageContext.request.contextPath}/images/eye-solid.svg" alt="Eye icon"
											width="20" height="auto" class="">
									</button></a>&nbsp;<a
								href="categorydetails.jsp"><button type="button"
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