<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<c:url value="/" var="contextPath" />

<tags:pageTemplate titulo="Livros de Java, Android, iPhone, Ruby, PHP e muito mais ....">

	<section id="index-section" class="container middle">
		<br>
		<a href="${contextPath}usuarios/form">Novo usuário</a>
		<h2>Lista de Usuários</h2>
		
		<p>${message}</p>
		
		<table>
			<tr>
				<th>Nome</th>
				<th>E-mail</th>
				<th>Roles</th>
				<th></th>
			</tr>
			<c:forEach items="${usuariosComRoles}" var="usuarioRole">
				<tr>
					<td>${usuarioRole.nome}</td>
					<td>${usuarioRole.email}</td>
					<td>
						<c:forEach items="${usuarioRole.roles}" var="roles" varStatus="loop">
							${roles.nome}
							<c:if test="${!loop.last}">,</c:if>
						</c:forEach>
					</td>
					<td><a href="${s:mvcUrl('UC#editarRoles').arg(0, usuarioRole.email).build()}"><img alt="Editar" src="${contextPath}resources/imagens/editar.png"></a></td>
				</tr>
			</c:forEach>
			<c:forEach items="${usuariosSemRoles}" var="usuarioSemRole">
				<tr>
					<td>${usuarioSemRole.nome}</td>
					<td>${usuarioSemRole.email}</td>
					<td> </td>
					<td><a href="${s:mvcUrl('UC#editarRoles').arg(0, usuarioSemRole.email).build()}"><img alt="Adicionar" src="${contextPath}resources/imagens/adicionar.png"></a></td>
				</tr>
			</c:forEach>
		</table>
		
	</section>
	
</tags:pageTemplate>