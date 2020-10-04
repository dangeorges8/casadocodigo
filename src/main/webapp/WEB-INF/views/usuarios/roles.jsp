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

		<h2>Cadastro de Permissões para ${usuario.nome}</h2>
		<div class="container">
			<form:form action="${s:mvcUrl('UC#gravarRoles').arg(1,usuario.email).arg(2,usuario.nome).build()}" method="post"
				commandName="usuario" enctype="multipart/form-data">
				<div class="form-group">
					<label><strong>Permissões</strong></label>
					<c:forEach items="${listaRoles}" var="role">
						<form:checkbox path="roles" value="${role.nome}"/>${role.nome}
					</c:forEach>
					<button type="submit" class="btn btn-outline-primary">Atualizar</button>
				</div>
			</form:form>
		</div>
	</section>

</tags:pageTemplate>