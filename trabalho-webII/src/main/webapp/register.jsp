<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="resources/bootstrap-5.1.3-dist/css/bootstrap.min.css" />
<link rel="stylesheet" href="styles/globals.css" />
<link rel="stylesheet" href="styles/index.css" />
<link href="http://fonts.cdnfonts.com/css/helvetica-255"
	rel="stylesheet">
<script src="resources/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>
<script src="resources/jquery-3.5.0.min.js"></script>
<meta charset="ISO-8859-1">
<title>Registre-se</title>
</head>
<body>
	<nav class="navbar navbar-light bg-light p-4 mb-5">
		<div class="container-fluid d-flex justify-content-between">
			<a class="navbar-brand" href="index.jsp"> <img
				src="images/beibe-logo.png" alt="Logotipo BEIBE" width="200"
				height="auto" class="d-inline-block align-text-center ml-3">
			</a> <a class="navbar-brand" href="index.jsp"> Sistema de Atendimento
				ao Cliente </a>
		</div>
	</nav>
	<main class="container-fluid">
		<div class="row">
			<div class="col-md-8 offset-md-2 text-center mb-5">
				<h1 class="homeH1">Registre-se na plataforma</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-8 offset-md-4">
				<form method="post" action="#" class="mb-5">
					<div class="form-row">
						<div class="form-group col-md-6 mb-3">
							<label for="inputCPF">CPF</label> <input type="text"
								class="form-control" id="inputCPF" placeholder="000.000.000-00"
								>
						</div>
						<div class="form-group col-md-6 mb-3">
							<label for="inputEmail4">E-mail</label> <input type="email"
								class="form-control" id="inputEmail4"
								placeholder="test@email.com" >
						</div>
						<div class="form-group col-md-6 mb-3">
							<label for="inputPassword4">Senha</label> <input
								type="password" class="form-control" id="inputPassword4"
								placeholder="Senha">
						</div>
						<div class="form-group col-md-6 mb-3">
							<label for="inputPassword5">Confirmar senha</label> <input
								type="password" class="form-control" id="inputPassword6"
								placeholder="Senha">
						</div>
					</div>
					<div class="form-group">
						<div class="form-group col-md-2 mb-3">
							<label for="inputZip">CEP</label> <input type="text"
								class="form-control" id="inputZip">
						</div>
						<div class="form-group col-md-6 mb-3">
							<label for="inputAddress">Logradouro</label> <input type="text"
								class="form-control" id="inputAddress" placeholder="Rua, número">
						</div>
					</div>
					<div class="form-group col-md-2 mb-3">
						<label for="inputAddress2">Número</label> <input type="text"
							class="form-control" id="inputAddress2" placeholder="334">
					</div>
					<div class="form-group col-md-6 mb-3">
						<label for="inputAddress3">Complemento</label> <input type="text"
							class="form-control" id="inputAddress3"
							placeholder="Apartamento, bloco, estúdio">
					</div>
					<div class="form-row">
						<div class="form-group col-md-6 mb-3">
							<label for="inputHood">Bairro</label> <input type="text"
								class="form-control" id="inputHood">
						</div>
						<div class="form-group col-md-6 mb-3">
							<label for="inputCity">Cidade</label> <input type="text"
								class="form-control" id="inputCity">
						</div>
						<div class="form-group col-md-4 mb-3">
							<label for="inputState">Estado</label> <select id="inputState"
								class="form-control">
								<option selected>Paraná - PR</option>
								<option>...</option>
							</select>
						</div>
					</div>
					<button type="submit" class="btn btn-dark">Registrar-me</button>
				<a href="index.jsp" type="button" class="btn btn-secondary">Já tenho
					cadastro</a>
				</form>
			</div>
		</div>
	</main>
</body>
</html>