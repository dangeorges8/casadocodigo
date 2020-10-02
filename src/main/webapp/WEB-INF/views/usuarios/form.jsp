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
					<label><strong><fmt:message key="cadastro.nome"/></strong></label>
					<form:input path="nome" class="form-control-sm" />
					<form:errors path="nome" />
				</div>
				<div class="form-group">
					<label><strong>E-mail</strong></label>
					<form:input type="email" path="email" class="form-control-sm" />
					<form:errors path="email" />
				</div>
				<div class="form-group">
					<label><strong><fmt:message key="cadastro.senha"/></strong></label>
					<form:input type="password" path="senha" class="form-control-sm" />
					<form:errors path="senha" />
				</div>
				<div class="form-group">
					<label><strong><fmt:message key="cadastro.senhaRepetida"/></strong></label>
					<form:input type="password" path="senhaRepetida" class="form-control-sm" />
					<form:errors path="senha" />
				</div>
				<button type="submit" class="btn btn-primary"><fmt:message key="cadastro.cadastrar"/></button>
			</form:form>
		</div>
	</section>

</tags:pageTemplate>