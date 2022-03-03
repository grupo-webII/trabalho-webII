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
<title>Descrição do atendimento - Gerente</title>
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
                                        dos usuários
				</a></li>
				<li class="nav-item active"><a class="nav-link" href="openrequests.jsp">Listagem
						dos atendimentos em aberto
				<span class="sr-only"> (atual)</span></a></li>
				<li class="nav-item"><a class="nav-link" href="allsupportrequests.jsp">Listagem
						dos atendimentos</a></li>
				<li class="nav-item"><a class="nav-link" href="exports.jsp">Relatórios</a></li>
				<li class="nav-item"><a class="nav-link" href="../../index.jsp"><b>Sair</b></a></li>
			</ul>
		</div>
	</nav>
	<div class="row">
		<div class="col-md-8 offset-md-2">
			<h1 class="mb-3 h1">Descrição do atendimento #1</h1>
			<div class="ml-0 pl-0 supportInfo container d-inline-flex">
                                <h4 class="mb-5 h4"><b>Maria Joaquina</b></h4>&nbsp;&nbsp;&nbsp;&nbsp;
				<h4 class="mb-5 h4"><b>09/02/2022</b></h4>&nbsp;&nbsp;&nbsp;&nbsp;
				<h4 class="mb-5 h4" style="color: yellow"><b>Em aberto - Resolver</b></h4>
			</div>
			<form action="main.jsp" class="mb-5">
				<div class="form-row">
					<div class="form-group col-md-6 mb-3">
						<select class="custom-select" disabled>
							<option value="1">Produto danificado</option>
							<option value="2" selected>Problemas com a entrega</option>
							<option value="3">Reação alérgica/indesejada</option>
							<option value="3">Troca/Devolução</option>
							<option value="3">Sugestão/Feedback</option>
						</select>
					</div>
					<div class="form-group col-md-6 mb-3">
						<select class="custom-select" disabled>
							<option value="3">N/A</option>
							<option value="1">Shampoo Hidratante</option>
							<option value="2">Hidratante Facial</option>
							<option value="3">Batom</option>
							<option value="3">Creme Mágico</option>
							<option value="3" selected>Pó Facial</option>
						</select>
					</div>
					<div class="form-group col-md-6 mb-3">
						<label for="inputShortDescriptive">Título do atendimento</label> <input
							type="text" class="form-control" id="inputShortDescriptive"
							disabled>
					</div>
					<div class="form-group mb-3">
						<label class="mb-3" for="exampleFormControlTextarea1">Descrição detalhada do caso</label>
						<textarea class="form-control" id="exampleFormControlTextarea1"
							rows="3" disabled>Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum</textarea>
					</div>
                                        <div class="form-group mb-3">
						<label class="mb-3" for="exampleFormControlTextarea1" style="font-weight: bold;"">Resolução</label>
						<textarea class="form-control" id="exampleFormControlTextarea1"
							rows="3" disabled></textarea>
					</div>
				</div>
                                <a href="openrequests.jsp" class="btn btn-dark">Voltar</a>
			</form>
		</div>
	</div>
</body>
</html>