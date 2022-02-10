<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="../../resources/bootstrap-5.1.3-dist/css/bootstrap.min.css" />
<link rel="stylesheet" href="../../styles/globals.css" />
<link rel="stylesheet" href="../../styles/index.css" />
<link href="http://fonts.cdnfonts.com/css/helvetica-255"
	rel="stylesheet">
<script src="../../resources/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
	integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<meta charset="ISO-8859-1">
<title>Dashboard do Cliente</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light p-4 mb-5">
		<a class="navbar-brand" href="../../index.jsp"> <img
			src="../../images/beibe-logo.png" alt="Logotipo BEIBE" width="200"
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
				<li class="nav-item active"><a class="nav-link" href="main.jsp">Meus
						atendimentos <span class="sr-only">(atual)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="updatedata.jsp">Atualizar
						dados</a></li>
				<li class="nav-item"><a class="nav-link" href="asksupport.jsp">Solicitar
						atendimento</a></li>
				<li class="nav-item"><a class="nav-link" href="../../index.jsp"><b>Sair</b></a></li>
			</ul>
		</div>
	</nav>
	<main>
		<div class="row">
			<div class="col-md-8 offset-md-2">
				<h1 class="mb-5">Meus atendimentos</h1>
				<table class="table table-hover">
					<thead>
						<tr>
							<th scope="col">Hash</th>
							<th scope="col">Status</th>
							<th scope="col">Descrição</th>
							<th scope="col">Data</th>
							<th scope="col">Ações</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th scope="row">1</th>
							<td>Em aberto</td>
							<td>Não recebi o produto no prazo</td>
							<td>09/02/2022</td>
							<td><button type="button" class="btn btn-light"
									data-bs-toggle="modal" data-bs-target="#exampleModal">Remover</button>&nbsp;<a
								href="#"><button type="button" class="btn btn-light">
										<img src="../../images/eye-solid.svg" alt="Eye icon"
											width="20" height="auto" class=""></a>
								</button> </a></td>
						</tr>
						<tr>
							<th scope="row">2</th>
							<td>Em aberto</td>
							<td>Produto não entrega o resultado de beleza</td>
							<td>17/08/2021</td>
							<td><button type="button" class="btn btn-light"
									data-bs-toggle="modal" data-bs-target="#exampleModal">Remover</button>&nbsp;<a
								href="#"><button type="button" class="btn btn-light">
										<img src="../../images/eye-solid.svg" alt="Eye icon"
											width="20" height="auto" class=""></a></td>
						</tr>
						<tr>
							<th scope="row">3</th>
							<td>Fechado</td>
							<td>Não gostei do atendimento</td>
							<td>01/03/2021</td>
							<td><button type="button" class="btn btn-dark">Remover</button>&nbsp;<a
								href="#"><button type="button" class="btn btn-light">
										<img src="../../images/eye-solid.svg" alt="Eye icon"
											width="20" height="auto" class=""></a></td>
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