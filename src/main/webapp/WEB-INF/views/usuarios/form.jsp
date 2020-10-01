<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<tags:pageTemplate
	titulo="Livros de Java, Android, iPhone, Ruby, PHP e muito mais ....">

	<section id="index-section" class="container middle">

		<h2>Cadastro de Usuários</h2>
		<div class="container">
			<form:form action="${s:mvcUrl('UC#gravar').build() }" method="post"
				commandName="usuario" enctype="multipart/form-data">
				<div class="form-group">
					<label>Nome</label>
					<form:input path="nome" cssClass="form-control" />
					<form:errors path="nome" />
				</div>
				<div class="form-group">
					<label>E-mail</label>
					<form:textarea path="email" cssClass="form-control" />
					<form:errors path="email" />
				</div>
				<div class="form-group">
					<label>Senha</label>
					<form:input path="senha" cssClass="form-control" />
					<form:errors path="senha" />
				</div>
				<div class="form-group">
					<label>Senha Repetida</label>
					<form:input path="senha" cssClass="form-control" />
					<form:errors path="senha" />
				</div>
				<button type="submit" class="btn btn-primary">Cadastrar</button>
			</form:form>
		</div>
	</section>

</tags:pageTemplate>