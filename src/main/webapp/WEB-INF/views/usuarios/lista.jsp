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
			<c:forEach items="${usuarios}" var="usuario">
				<tr>
					<td>${usuario.nome}</td>
					<td>${usuario.email}</td>
					<td>
						<c:forEach items="${usuario.roles}" var="roles">
							${roles.nome}
						</c:forEach>
					</td>
					<td><a href="${contextPath}usuarios/roles"><img alt="Adicionar" src="${contextPath}resources/imagens/adicionar.png"></a></td>
				</tr>
			</c:forEach>
		</table>
		
	</section>
	
</tags:pageTemplate>