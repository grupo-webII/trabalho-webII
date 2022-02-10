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
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<meta charset="ISO-8859-1">
<title>Solicitar atendimento</title>
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
						atendimentos </a></li>
				<li class="nav-item"><a class="nav-link" href="updatedata.jsp">Atualizar
						dados</a></li>
				<li class="nav-item"><a class="nav-link" href="asksupport.jsp">Solicitar
						atendimento<span class="sr-only">(atual)</span>
						<li class="nav-item"><a class="nav-link" href="../../index.jsp"><b>Sair</b></a></li>
				</a></li>
			</ul>
		</div>
	</nav>
	<div class="row">
		<div class="col-md-8 offset-md-2">
			<h1 class="mb-5">Solicitar atendimento</h1>
			<form method="post" action="#" class="mb-5">
				<div class="form-row">
					<div class="form-group col-md-6 mb-3">
						<select class="custom-select">
							<option selected>Tipo do atendimento</option>
							<option value="1">Produto danificado</option>
							<option value="2">Problemas com a entrega</option>
							<option value="3">Reação alérgica/indesejada</option>
							<option value="3">Troca/Devolução</option>
							<option value="3">Sugestão/Feedback</option>
						</select>
					</div>
					<div class="form-group col-md-6 mb-3">
						<select class="custom-select">
							<option selected>Produto envolvido</option>
							<option value="3">N/A</option>
							<option value="1">Shampoo Hidratante</option>
							<option value="2">Hidratante Facial</option>
							<option value="3">Batom</option>
							<option value="3">Creme Mágico</option>
							<option value="3">Pó Facial</option>
						</select>
					</div>
					<div class="form-group mb-3">
						<label class="mb-3" for="exampleFormControlTextarea1">Descreva da maneira mais detalhada possível o seu caso</label>
						<textarea class="form-control" id="exampleFormControlTextarea1"
							rows="3"></textarea>
					</div>
				</div>
				<button type="submit" class="btn btn-dark">Enviar</button>
			</form>
		</div>
	</div>
</body>
</html>