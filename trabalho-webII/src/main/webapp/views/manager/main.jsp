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
						dos gerentes/funcionários <span class="sr-only">(atual)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="updatedata.jsp">Listagem dos atendimentos em aberto</a></li>
				<li class="nav-item"><a class="nav-link" href="asksupport.jsp">Listagem dos atendimentos</a></li>
				<li class="nav-item"><a class="nav-link" href="asksupport.jsp">Relatórios</a></li>
				<li class="nav-item"><a class="nav-link" href="../../index.jsp"><b>Sair</b></a></li>
			</ul>
		</div>
	</nav>
</body>
</html>