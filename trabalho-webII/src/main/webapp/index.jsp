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
<script src="resources/jquery-3.5.0.min.js"></script>
<script
	src="resources/jQuery-Mask-Plugin-master/dist/jquery.mask.min.js"></script>
<script src="resources/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>BEIBE - Sistema de Atendimento ao Cliente</title>
</head>
<body class="h100Body">
	<nav class="navbar navbar-light bg-light p-4 mb-5">
		<div class="container-fluid d-flex justify-content-between">
			<a class="navbar-brand" href="index.jsp"> <img
				src="images/beibe-logo.png" alt="Logotipo BEIBE" width="200"
				height="auto" class="d-inline-block align-text-center ml-3">
			</a> Sistema de Atendimento ao Cliente
		</div>
	</nav>
	<main class="container-fluid">
		<div class="row">
			<div class="col-md-8 offset-md-2 text-center mb-5">
				<h1 class="homeH1">Entre na plataforma</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-7 offset-md-4">
				<form class="form-wrapper p-4" method="post" action="login">

					<div class="form-group col-md-7 mb-3">
						<label for="inputEmail4">E-mail</label> <input type="email"
							class="form-control" id="inputEmail4" name="uemail"
							placeholder="example@email.com" required>
					</div>
					<div class="form-group col-md-7 mb-3">
						<label for="inputPassword3">Senha</label> <input
							type="password" class="form-control" id="inputPassword4" name="upass"
							placeholder="******" required>
					</div>
					<button type="submit" class="btn btn-dark">Entrar</button>
					<a href="register.jsp" type="button" class="btn btn-secondary">Não
						tenho cadastro</a>

					<!-- <div class="mb-3">
						<label for="exampleInputEmail1" class="form-label">E-mail
						</label> <input type="email" class="form-control" id="exampleInputEmail1"
							aria-describedby="emailHelp" name="uemail" required>
						<div id="emailHelp" class="form-text">Nós não iremos
							compartilhar com mais ninguém.</div>
					</div>
					<div class="mb-3">
						<label for="exampleInputPassword1" class="form-label">Senha</label>
						<input type="password" class="form-control"
							id="exampleInputPassword1" name="upass" required>
					</div>
					<button type="submit" class="btn btn-dark">Entrar</button>
					<a href="register.jsp" type="button" class="btn btn-secondary">Não
						tenho cadastro</a> -->
				</form>
			</div>
		</div>
	</main>
</body>
</html>