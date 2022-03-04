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
<script src="../../resources/jquery-3.5.0.min.js"></script>
<meta charset="ISO-8859-1">
<title>Dashboard do Gerente</title>
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
                                <li class="nav-item active"><a class="nav-link" href="main.jsp">Listagem
                                        dos usu�rios<span class="sr-only"> (atual)</span>
				</a></li>
				<li class="nav-item active"><a class="nav-link" href="openrequests.jsp">Listagem
						dos atendimentos em aberto
				</a></li>
				<li class="nav-item"><a class="nav-link" href="allsupportrequests.jsp">Listagem
						dos atendimentos</a></li>
				<li class="nav-item"><a class="nav-link" href="exports.jsp">Relat�rios</a></li>
				<li class="nav-item"><a class="nav-link" href="../../index.jsp"><b>Sair</b></a></li>
			</ul>
		</div>
	</nav>
    <main>
		<div class="row">
			<div class="col-md-8 offset-md-2">
				<h1 class="h1">Usu�rios do sistema</h1>
                                <a class="mb-5 btn btn-dark" href="newuser.jsp" class="btn btn-dark">Adicionar novo</a>
				<table class="table table-hover">
					<thead>
						<tr>
							<th scope="col">Hash</th>
							<th scope="col">Tipo</th>
							<th scope="col">Nome</th>
							<th scope="col">E-mail</th>
							<th scope="col">CPF</th>
							<th scope="col">A��es</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th scope="row">1</th>
							<td>Funcion�rio</td>
							<td>Jenivaldo Aquidaban</td>
							<td>jenivaldo@test.com</td>
							<td>000.000.000-00</td>
							<td><button type="button" class="btn btn-light"
									data-bs-toggle="modal" data-bs-target="#exampleModal">Remover</button>&nbsp;<a
								href="userdetails.jsp"><button type="button"
										class="btn btn-light">
										<img src="../../images/eye-solid.svg" alt="Eye icon"
											width="20" height="auto" class="">
									</button></a>&nbsp;<a
								href="userdetails.jsp"><button type="button"
										class="btn btn-light">
										<img src="../../images/pen-to-square-solid.svg" alt="Eye icon"
											width="20" height="auto" class="">
									</button></a></td>
						</tr>
						<tr>
							<th scope="row">2</th>
							<td>Gerente</td>
							<td>Jenivaldo Aquidaban</td>
							<td>jenivaldo@test.com</td>
							<td>000.000.000-00</td>
							<td><button type="button" class="btn btn-light"
									data-bs-toggle="modal" data-bs-target="#exampleModal">Remover</button>&nbsp;<a
								href="userdetails.jsp"><button type="button"
										class="btn btn-light">
										<img src="../../images/eye-solid.svg" alt="Eye icon"
											width="20" height="auto" class="">
									</button></a>&nbsp;<a
								href="userdetails.jsp"><button type="button"
										class="btn btn-light">
										<img src="../../images/pen-to-square-solid.svg" alt="Eye icon"
											width="20" height="auto" class="">
									</button></a></td>
						</tr>
						<tr>
							<th scope="row">3</th>
							<td>Funcion�rio</td>
							<td>Jenivaldo Aquidaban</td>
							<td>jenivaldo@test.com</td>
							<td>000.000.000-00</td>
							<td><button type="button" class="btn btn-light"
									data-bs-toggle="modal" data-bs-target="#exampleModal">Remover</button>&nbsp;<a
								href="userdetails.jsp"><button type="button"
										class="btn btn-light">
										<img src="../../images/eye-solid.svg" alt="Eye icon"
											width="20" height="auto" class="">
									</button></a>&nbsp;<a
								href="userdetails.jsp"><button type="button"
										class="btn btn-light">
										<img src="../../images/pen-to-square-solid.svg" alt="Eye icon"
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