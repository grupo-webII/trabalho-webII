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
<script>
	// Máscara dos inputs
	$(document)
			.ready(
					function() {
						$('.cep').mask('00000-000');
						$('.phone_with_ddd').mask('(00) 00000-0000');
						$('.cpf').mask('000.000.000-00');

						function limpa_formulário_cep() {
							// Limpa valores do formulário de cep.
							$("#inputAddress").val("");
							$("#inputHood").val("");
							$("#inputCity").val("");
							$("#inputState").val("");
						}

						//Quando o campo cep perde o foco.
						$("#inputZip")
								.blur(
										function() {

											//Nova variável "cep" somente com dígitos.
											var cep = $(this).val().replace(
													/\D/g, '');

											//Verifica se campo cep possui valor informado.
											if (cep != "") {

												//Expressão regular para validar o CEP.
												var validacep = /^[0-9]{8}$/;

												//Valida o formato do CEP.
												if (validacep.test(cep)) {

													//Preenche os campos com "..." enquanto consulta webservice.
													$("#inputAddress").val(
															"...");
													$("#inputHood").val("...");
													$("#inputCity").val("...");
													$("#inputState").val("...");

													//Consulta o webservice viacep.com.br/
													$
															.getJSON(
																	"https://viacep.com.br/ws/"
																			+ cep
																			+ "/json/?callback=?",
																	function(
																			dados) {

																		if (!("erro" in dados)) {
																			//Atualiza os campos com os valores da consulta.
																			$(
																					"#inputAddress")
																					.val(
																							dados.logradouro);
																			$(
																					"#inputHood")
																					.val(
																							dados.bairro);
																			$(
																					"#inputCity")
																					.val(
																							dados.localidade);
																			$(
																					"#inputState")
																					.val(
																							dados.uf);
																		} //end if.
																		else {
																			//CEP pesquisado não foi encontrado.
																			limpa_formulário_cep();
																			alert("CEP não encontrado.");
																		}
																	});
												} //end if.
												else {
													//cep é inválido.
													limpa_formulário_cep();
													alert("Formato de CEP inválido.");
												}
											} //end if.
											else {
												//cep sem valor, limpa formulário.
												limpa_formulário_cep();
											}
										});

						function CPF() {
							"user_strict";
							function r(r) {
								for (var t = null, n = 0; 9 > n; ++n)
									t += r.toString().charAt(n) * (10 - n);
								var i = t % 11;
								return i = 2 > i ? 0 : 11 - i
							}
							function t(r) {
								for (var t = null, n = 0; 10 > n; ++n)
									t += r.toString().charAt(n) * (11 - n);
								var i = t % 11;
								return i = 2 > i ? 0 : 11 - i
							}
							var n = "CPF Inválido", i = "CPF Válido";
							this.gera = function() {
								for (var n = "", i = 0; 9 > i; ++i)
									n += Math.floor(9 * Math.random()) + "";
								var o = r(n), a = n + "-" + o + t(n + "" + o);
								return a
							}, this.valida = function(o) {
								for (var a = o.replace(/\D/g, ""), u = a
										.substring(0, 9), f = a
										.substring(9, 11), v = 0; 10 > v; v++)
									if ("" + u + f == "" + v + v + v + v + v
											+ v + v + v + v + v + v)
										return n;
								var c = r(u), e = t(u + "" + c);
								return f.toString() === c.toString()
										+ e.toString() ? i : n
							}
						}

						var CPF = new CPF();
						

						$("#inputCPF").keypress(function() {
							$("#resposta").html(CPF.valida($(this).val()));
						});

						$("#inputCPF").blur(function() {
							$("#resposta").html(CPF.valida($(this).val()));
						});
					});
</script>
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
							<label for="inputCPF">CPF</label> 
							<input type="text"
								class="form-control cpf" id="inputCPF"
								placeholder="000.000.000-00" required>
							<span id="resposta"></span>
						</div>
						<div class="form-group col-md-6 mb-3">
							<label for="inputCPF">Telefone</label> <input type="text"
								class="form-control phone_with_ddd" id="inputCPF"
								placeholder="(00) 00000-0000" required>
						</div>
						<div class="form-group col-md-6 mb-3">
							<label for="inputEmail4">E-mail</label> <input type="email"
								class="form-control" id="inputEmail4"
								placeholder="test@email.com" required>
						</div>
						<div class="form-group col-md-6 mb-3">
							<label for="inputPassword5">Senha</label> <input type="password"
								class="form-control" id="inputPassword5" placeholder="Senha"
								required>
						</div>
						<div class="form-group col-md-6 mb-3">
							<label for="inputPassword6">Confirmar senha</label> <input
								type="password" class="form-control" id="inputPassword6"
								placeholder="Senha" required>
						</div>
					</div>
					<div class="form-group">
						<div class="form-group col-md-2 mb-3">
							<label for="inputZip">CEP</label> <input type="text"
								class="form-control cep" id="inputZip" required>
						</div>
						<div class="form-group col-md-6 mb-3">
							<label for="inputAddress">Logradouro</label> <input type="text"
								class="form-control" id="inputAddress" placeholder="Rua, número"
								required>
						</div>
					</div>
					<div class="form-group col-md-2 mb-3">
						<label for="inputAddress2">Número</label> <input type="text"
							class="form-control" id="inputAddress2" placeholder="334"
							required>
					</div>
					<div class="form-group col-md-6 mb-3">
						<label for="inputAddress3">Complemento</label> <input type="text"
							class="form-control" id="inputAddress3"
							placeholder="Apartamento, bloco, estúdio">
					</div>
					<div class="form-row">
						<div class="form-group col-md-6 mb-3">
							<label for="inputHood">Bairro</label> <input type="text"
								class="form-control" id="inputHood" required disabled>
						</div>
						<div class="form-group col-md-6 mb-3">
							<label for="inputCity">Cidade</label> <input type="text"
								class="form-control" id="inputCity" required disabled>
						</div>
						<div class="form-group col-md-2 mb-3">
								<label for="inputCity">Estado</label> <input type="text"
								class="form-control" id="inputState" required disabled>
						</div>
					</div>
					<button type="submit" class="btn btn-dark">Registrar-me</button>
					<a href="index.jsp" type="button" class="btn btn-secondary">Já
						tenho cadastro</a>
				</form>
			</div>
		</div>
	</main>
</body>
</html>