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
<title>Atualizar dados</title>
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
						dados <span class="sr-only">(atual)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="asksupport.jsp">Solicitar
						atendimento</a></li>
			</ul>
		</div>
	</nav>
	<main>
		<div class="row">
			<div class="col-md-8 offset-md-2">
				<h1 class="mb-5">Atualizar dados</h1>
				<form method="post" action="#" class="mb-5">
					<div class="form-row">
						<div class="form-group col-md-6 mb-3">
							<label for="inputCPF">CPF</label> <input type="text"
								class="form-control" id="inputCPF" placeholder="000.000.000-00"
								disabled>
						</div>
						<div class="form-group col-md-6 mb-3">
							<label for="inputEmail4">E-mail</label> <input type="email"
								class="form-control" id="inputEmail4"
								placeholder="test@email.com" disabled>
						</div>
						<div class="form-group col-md-6 mb-3">
							<label for="inputPassword4">Senha atual</label> <input type="password"
								class="form-control" id="inputPassword4" placeholder="******" disabled>
						</div>
						<div class="form-group col-md-6 mb-3">
							<label for="inputPassword4">Senha nova</label> <input type="password"
								class="form-control" id="inputPassword4" placeholder="Senha">
						</div>
					</div>
					<div class="form-group">
						<div class="form-group col-md-2 mb-3">
							<label for="inputZip">CEP</label> <input type="text"
								class="form-control" id="inputZip">
						</div>
						<div class="form-group mb-3">
							<label for="inputAddress">Logradouro</label> <input type="text"
								class="form-control" id="inputAddress" placeholder="Rua, número">
						</div>
					</div>
					<div class="form-group mb-3">
						<label for="inputAddress2">Número</label> <input type="text"
							class="form-control" id="inputAddress2"
							placeholder="334">
					</div>
					<div class="form-group mb-3">
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
					<button type="submit" class="btn btn-dark">Alterar</button>
				</form>
			</div>
		</div>
	</main>
</body>
</html>