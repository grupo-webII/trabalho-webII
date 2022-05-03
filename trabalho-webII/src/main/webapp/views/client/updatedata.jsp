<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
    <c:when test="${!user.isAuthenticated}">
        <c:redirect url="/index.jsp" />
    </c:when>
    <c:when test="${!user.role.ROLE_CLIENTE}">
        <c:redirect url="/index.jsp" />
    </c:when>
</c:choose>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet"
              href="${pageContext.request.contextPath}/resources/bootstrap-5.1.3-dist/css/bootstrap.min.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/globals.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/index.css" />
        <link href="http://fonts.cdnfonts.com/css/helvetica-255"
              rel="stylesheet">
        <script src="${pageContext.request.contextPath}/resources/jquery-3.5.0.min.js"></script>
        <script
        src="${pageContext.request.contextPath}/resources/jQuery-Mask-Plugin-master/dist/jquery.mask.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>
        <script>
            // Máscara dos inputs
//            $(document).ready(
//                    function () {
//                        $('.cep').mask('00000-000');
//                        $('.phone_with_ddd').mask('(00) 00000-0000');
//                        $('.cpf').mask('000.000.000-00');
//
//                        function limpa_formulario_cep() {
//                            // Limpa valores do formulário de cep.
//                            $("#inputAddress").val("");
//                            $("#inputHood").val("");
//                            $("#inputCity").val("");
//                            $("#inputState").val("");
//                        }
//
//                        //Quando o campo cep perde o foco.
//                        $("#inputZip").blur(
//                                function () {
//
//                                    //Nova vari�vel "cep" somente com d�gitos.
//                                    var cep = $(this).val().replace(/\D/g, '');
//
//                                    //Verifica se campo cep possui valor informado.
//                                    if (cep != "") {
//
//                                        //Expressção regular para validar o CEP.
//                                        var validacep = /^[0-9]{8}$/;
//
//                                        //Valida o formato do CEP.
//                                        if (validacep.test(cep)) {
//
//                                            //Preenche os campos com "..." enquanto consulta webservice.
//                                            $("#inputAddress").val("...");
//                                            $("#inputHood").val("...");
//                                            $("#inputCity").val("...");
//                                            $("#inputState").val("...");
//
//                                            //Consulta o webservice viacep.com.br/
//                                            $.getJSON("https://viacep.com.br/ws/" + cep
//                                                    + "/json/?callback=?", function (
//                                                            dados) {
//
//                                                        if (!("erro" in dados)) {
//                                                            //Atualiza os campos com os valores da consulta.
//                                                            $("#inputAddress").val(
//                                                                    dados.logradouro);
//                                                            $("#inputHood").val(dados.bairro);
//                                                            $("#inputCity").val(
//                                                                    dados.localidade);
//                                                            $("#inputState").val(dados.uf);
//                                                        } //end if.
//                                                        else {
//                                                            //CEP pesquisado não foi encontrado.
//                                                            limpa_formulario_cep();
//                                                            alert("CEP não encontrado.");
//                                                        }
//                                                    });
//                                        } //end if.
//                                        else {
//                                            //cep é inválido.
//                                            limpa_formulario_cep();
//                                            alert("Formato de CEP inv�lido.");
//                                        }
//                                    } //end if.
//                                    else {
//                                        //cep sem valor, limpa formulário.
//                                        limpa_formulario_cep();
//                                    }
//                                });
//
//                        function CPF() {
//                            "user_strict";
//                            function r(r) {
//                                for (var t = null, n = 0; 9 > n; ++n)
//                                    t += r.toString().charAt(n) * (10 - n);
//                                var i = t % 11;
//                                return i = 2 > i ? 0 : 11 - i
//                            }
//                            function t(r) {
//                                for (var t = null, n = 0; 10 > n; ++n)
//                                    t += r.toString().charAt(n) * (11 - n);
//                                var i = t % 11;
//                                return i = 2 > i ? 0 : 11 - i
//                            }
//                            var n = "CPF Inv�lido", i = "CPF V�lido";
//                            this.gera = function () {
//                                for (var n = "", i = 0; 9 > i; ++i)
//                                    n += Math.floor(9 * Math.random()) + "";
//                                var o = r(n), a = n + "-" + o + t(n + "" + o);
//                                return a
//                            },
//                                    this.valida = function (o) {
//                                        for (var a = o.replace(/\D/g, ""), u = a
//                                                .substring(0, 9), f = a
//                                                .substring(9, 11), v = 0; 10 > v; v++)
//                                            if ("" + u + f == "" + v + v + v + v + v
//                                                    + v + v + v + v + v + v)
//                                                return n;
//                                        var c = r(u), e = t(u + "" + c);
//                                        return f.toString() === c.toString()
//                                                + e.toString() ? i : n
//                                    }
//                        }
//
//                        var CPF = new CPF();
//
//                        $("#inputCPF").keypress(function () {
//                            $("#resposta").html(CPF.valida($(this).val()));
//                        });
//
//                        $("#inputCPF").blur(function () {
//                            $("#resposta").html(CPF.valida($(this).val()));
//                        });
//                    });
        </script>
        <title>Atualizar dados</title>
        <meta charset="UTF-8">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light p-4 mb-5">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp"> <img
                    src="${pageContext.request.contextPath}/images/beibe-logo.png" alt="Logotipo BEIBE" width="200"
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
                    <li class="nav-item active"><a class="nav-link" href="main">Meus
                            atendimentos </a></li>
                    <li class="nav-item"><a class="nav-link" href="updatedata">Atualizar
                            dados <span class="sr-only">(atual)</span>
                        </a></li>
                    <li class="nav-item"><a class="nav-link" href="asksupport">Solicitar
                            atendimento</a></li>
                    <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/logout"><b>Sair</b></a></li>
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
                                <label for="name">Primeiro nome</label> <input type="text"
                                                                               name="name"  value="${userData.name}"                                               
                                                                               class="form-control" id="inputFirstName" placeholder="${userData.name}"
                                                                               required>
                            </div>
                            <div class="form-group col-md-6 mb-3">
                                <label for="lastname">Sobrenome</label> <input type="text"
                                                                               name="lastname"          value="${userData.lastname}"                                   
                                                                               class="form-control" id="inputLastName" placeholder="${userData.lastname}"
                                                                               required>
                            </div>
                            <div class="form-group col-md-6 mb-3">
                                <label for="cpf">CPF</label> <input type="text" name="cpf" value="${userData.cpf}"
                                                                    class="form-control" id="inputCPF" placeholder="{userData.cpf}"
                                                                    >
                            </div>
                            <div class="form-group col-md-6 mb-3">
                                <label for="email">E-mail</label> <input type="email" name="email" value="${user.email}"
                                                                         class="form-control" id="inputEmail4"
                                                                         placeholder="${user.email}" >
                            </div>
                            <div class="form-group col-md-6 mb-3">
                                <label for="inputPassword3">Senha atual</label> <input
                                    type="password" class="form-control" id="inputPassword4"
                                    placeholder="******" disabled>
                            </div>
                            <div class="form-group col-md-6 mb-3">
                                <label for="password">Senha nova</label> <input name="password" value="${user.password}"
                                                                                type="password" class="form-control" id="inputPassword5"
                                                                                placeholder="Senha">
                            </div>
                            <div class="form-group col-md-6 mb-3">
                                <label for="confirmPass">Confirmar senha nova</label> <input name="confirmPass"
                                                                                             type="password" class="form-control" id="inputPassword6"
                                                                                             placeholder="Senha">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-group col-md-2 mb-3">
                                <label for="cep">CEP</label> <input type="text" name="cep" 
                                                                    class="form-control " id="inputZip" value="${userData.cep}"
                                                                    required>
                            </div>
                            <div class="form-group col-md-6 mb-3">
                                <label for="address">Logradouro</label> <input type="text" name="address" value="${userData.address}"
                                                                               class="form-control" id="inputAddress" placeholder="Rua, número"
                                                                               required>
                            </div>
                        </div>
                        <div class="form-group col-md-2 mb-3">
                            <label for="addressNumber">Número</label> <input type="text" name="addressNumber" value="${userData.adressNumber}"
                                                                             class="form-control" id="inputAddress2" placeholder="334"
                                                                             required>
                        </div>
                        <div class="form-group col-md-6 mb-3">
                            <label for="complement">Complemento</label> <input type="text" name="complement" value="${userData.complement}}"
                                                                               class="form-control" id="inputAddress3"
                                                                               placeholder="Apartamento, bloco, estúdio">
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6 mb-3">
                                <label for="bairro">Bairro</label> <input type="text" name="bairro" value="${userData.bairro}"
                                                                          class="form-control" id="inputHood" required >
                            </div>

                            <div class="form-group col-md-6 mb-3">
                                <label for="city">Cidade</label> <input type="text" name="city" value="${userData.city}"
                                                                        class="form-control" id="inputCity" required >
                            </div>
                            <div class="form-group col-md-2 mb-3">
                                <label for="state">Estado</label> <input type="text" name="state" value="${userData.state}"
                                                                         class="form-control" id="inputState" required >
                            </div>
                        </div>
                        <button type="submit" class="btn btn-dark">Alterar</button>
                    </form>
                </div>
            </div>
        </main>
    </body>
</html>