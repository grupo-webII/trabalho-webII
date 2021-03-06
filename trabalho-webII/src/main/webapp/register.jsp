<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
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
            // M�scara dos inputs
            //	$(document).ready(
            //			function() {
            //				$('.cep').mask('00000-000');
            //				$('.phone_with_ddd').mask('(00) 00000-0000');
            //				$('.cpf').mask('000.000.000-00');
            //
            ////				function limpa_formul�rio_cep() {
            ////					// Limpa valores do formul�rio de cep.
            ////					$("#inputAddress").val("");
            ////					$("#inputHood").val("");
            ////					$("#inputCity").val("");
            ////					$("#inputState").val("");
            ////				}
            //
            //				//Quando o campo cep perde o foco.
            ////				$("#inputZip").blur(
            ////						function() {
            ////
            ////							//Nova vari�vel "cep" somente com d�gitos.
            ////							var cep = $(this).val().replace(/\D/g, '');
            ////
            ////							//Verifica se campo cep possui valor informado.
            ////							if (cep != "") {
            ////
            ////								//Express�o regular para validar o CEP.
            ////								var validacep = /^[0-9]{8}$/;
            ////
            ////								//Valida o formato do CEP.
            ////								if (validacep.test(cep)) {
            ////
            ////									//Preenche os campos com "..." enquanto consulta webservice.
            //////									$("#inputAddress").val("...");
            //////									$("#inputHood").val("...");
            //////									$("#inputCity").val("...");
            //////									$("#inputState").val("...");
            ////
            ////									//Consulta o webservice viacep.com.br/
            ////									$.getJSON("https://viacep.com.br/ws/" + cep
            ////											+ "/json/?callback=?", function(
            ////											dados) {
            ////
            ////										if (!("erro" in dados)) {
            ////											//Atualiza os campos com os valores da consulta.
            //////											$("#inputAddress").val(
            //////													dados.logradouro);
            //////											$("#inputHood").val(dados.bairro);
            //////											$("#inputCity").val(
            //////													dados.localidade);
            //////											$("#inputState").val(dados.uf);
            ////										} //end if.
            ////										else {
            ////											//CEP pesquisado n�o foi encontrado.
            ////											limpa_formul�rio_cep();
            //////											alert("CEP n�o encontrado.");
            ////										}
            ////									});
            ////								} //end if.
            ////								else {
            ////									//cep � inv�lido.
            ////									limpa_formul�rio_cep();
            //////									alert("Formato de CEP inv�lido.");
            ////								}
            ////							} //end if.
            ////							else {
            ////								//cep sem valor, limpa formul�rio.
            ////								limpa_formul�rio_cep();
            ////							}
            ////						});
            //
            ////				function CPF() {
            ////					"user_strict";
            ////					function r(r) {
            ////						for (var t = null, n = 0; 9 > n; ++n)
            ////							t += r.toString().charAt(n) * (10 - n);
            ////						var i = t % 11;
            ////						return i = 2 > i ? 0 : 11 - i
            ////					}
            ////					function t(r) {
            ////						for (var t = null, n = 0; 10 > n; ++n)
            ////							t += r.toString().charAt(n) * (11 - n);
            ////						var i = t % 11;
            ////						return i = 2 > i ? 0 : 11 - i
            ////					}
            ////					var n = "CPF Inválido", i = "CPF Válido";
            ////					this.gera = function() {
            ////						for (var n = "", i = 0; 9 > i; ++i)
            ////							n += Math.floor(9 * Math.random()) + "";
            ////						var o = r(n), a = n + "-" + o + t(n + "" + o);
            ////						return a
            ////					},
            ////							this.valida = function(o) {
            ////								for (var a = o.replace(/\D/g, ""), u = a
            ////										.substring(0, 9), f = a
            ////										.substring(9, 11), v = 0; 10 > v; v++)
            ////									if ("" + u + f == "" + v + v + v + v + v
            ////											+ v + v + v + v + v + v)
            ////										return n;
            ////								var c = r(u), e = t(u + "" + c);
            ////								return f.toString() === c.toString()
            ////										+ e.toString() ? i : n
            ////							}
            ////				}
            //
            ////				var CPF = new CPF();
            ////
            ////				$("#inputCPF").keypress(function() {
            ////					$("#resposta").html(CPF.valida($(this).val()));
            ////				});
            ////
            ////				$("#inputCPF").blur(function() {
            ////					$("#resposta").html(CPF.valida($(this).val()));
            ////				});
            //			});
        </script>
        <meta charset="UTF-8">
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
                    <form method="post" action="register" class="mb-5">
                        <div class="form-row">
                            <div class="form-group col-md-6 mb-3">
                                <label for="name">Primeiro nome</label> <input type="text"
                                                                               name="name" class="form-control" id="inputFirstName" placeholder="Maria"
                                                                               required>
                            </div>
                            <div class="form-group col-md-6 mb-3">
                                <label for="lastname">Sobrenome</label> <input type="text"
                                                                               name="lastname" class="form-control" id="inputLastName" placeholder="Luceia"
                                                                               required>
                            </div>
                            <div class="form-group col-md-6 mb-3">
                                <label for="cpf">CPF</label> <input type="text"
                                                                    name="cpf"
                                                                    class="form-control cpf" id="inputCPF"
                                                                    placeholder="00000000000" required> <span
                                                                    id="resposta"></span>
                            </div>
                            <div class="form-group col-md-6 mb-3">
                                <label for="phone">Telefone</label> <input type="text"
                                                                           name="phone"
                                                                           class="form-control phone_with_ddd" id="inputCPF"
                                                                           placeholder="00000000000" required>
                            </div>
                            <div class="form-group col-md-6 mb-3">
                                <label for="email">E-mail</label> <input type="email"
                                                                         name="email"
                                                                         class="form-control" id="inputEmail4"
                                                                         placeholder="test@email.com" required>
                            </div>
                            <div class="form-group col-md-6 mb-3">
                                <label for="password">Senha</label> <input type="password"
                                                                           name="password"
                                                                           class="form-control" id="inputPassword5" placeholder="Senha"
                                                                           required>
                            </div>
                            <div class="form-group col-md-6 mb-3">
                                <label for="confirmPass">Confirmar senha</label> <input
                                    name="confirmPass"
                                    type="password" class="form-control" id="inputPassword6"
                                    placeholder="Senha" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-group col-md-2 mb-3">
                                <label for="cep">CEP</label> <input type="text"
                                                                    name="cep"
                                                                    class="form-control cep" id="inputZip" placeholder="00000000" required>
                            </div>
                            <div class="form-group col-md-6 mb-3">
                                <label for="address">Logradouro</label> <input type="text"
                                                                               name="address"
                                                                               class="form-control" id="inputAddress" placeholder="Rua, número"
                                                                               required>
                            </div>
                        </div>
                        <div class="form-group col-md-2 mb-3">
                            <label for="addressNumber">Número</label> <input type="text"
                                                                             name="addressNumber"
                                                                             class="form-control" id="inputAddress2" placeholder="334"
                                                                             required>
                        </div>
                        <div class="form-group col-md-6 mb-3">
                            <label for="complement">Complemento</label> <input type="text"
                                                                               name="complement"
                                                                               class="form-control" id="inputAddress3"
                                                                               placeholder="Apartamento, bloco, estúdio">
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6 mb-3">
                                <label for="bairro">Bairro</label> <input type="text"
                                                                          name="bairro"
                                                                          class="form-control" id="inputHood" required >
                            </div>
                            <div class="form-group col-md-6 mb-3">
                                <label for="city">Cidade</label> <input type="text" name="city"

                                                                        class="form-control" id="inputCity" required >
                            </div>
                            <div class="form-group col-md-2 mb-3">
                                <label for="state">Estado</label> <input type="text"
                                                                         name="state"
                                                                         class="form-control" id="inputState" required >
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