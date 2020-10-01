<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:pageTemplate titulo="Livros de Java, Android, iPhone, Ruby, PHP e muito mais ....">

	<section id="index-section" class="container middle">

		<h2>Lista de pedidos atuais</h2>
		<table>
			<tr>
				<th>ID</th>
				<th>Valor</th>
				<th>Data Pedido</th>
				<th>Títulos</th>
			</tr>
			<c:forEach items="${pedidos}" var="pedido">
				<tr>
					<td>${pedido.id}</td>
					<td>${pedido.valor}</td>
					<td><fmt:formatDate value="${pedido.data.time}" pattern="dd/MM/yyyy"/></td>
					<td>
						<c:forEach items="${pedido.produtos}" var="produto" varStatus="loop">
							${produto.titulo}
							<c:if test="${!loop.last}">,</c:if>
						</c:forEach>
					</td>
				</tr>
			</c:forEach>
		</table>
		
	</section>
	
</tags:pageTemplate>