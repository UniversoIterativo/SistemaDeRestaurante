<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Movimentacao Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Add a Movimentacao
</h1>

<c:url var="addAction" value="/movimentacao/add" ></c:url>

<form:form action="${addAction}" commandName="movimentacao">
<table>
	<c:if test="${!empty movimentacao.id}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="tipo">
				<spring:message text="tipo" />
			</form:label>
		</td>
		<td>
			<form:select path="tipo" required="required">
				<form:option value="SELECIONE"></form:option>
				<form:options items="${tipo}" />
			</form:select>
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="conta">
				<spring:message text="conta"/>
			</form:label>
		</td>
		<td>
			<form:select path="conta" items="${listContas}" multiple="false" />
		</td>
	</tr>
		<tr>
		<td>
			<form:label path="valor">
				<spring:message text="valor"/>
			</form:label>
		</td>
		<td>
			<form:input path="valor"  required="required" />
		</td>
	</tr>

	<tr>
		<td colspan="2">
			<c:if test="${!empty movimentacao.valor}">
				<input type="submit"
					value="<spring:message text="Edit Movimentacao"/>" />
			</c:if>
			<c:if test="${empty movimentacao.valor}">
				<input type="submit"
					value="<spring:message text="Add Movimentacao"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Movimentacaos List</h3>
<c:if test="${!empty listMovimentacoes}">
	<table class="tg">
	<tr>
		<th width="80">ID</th>
		<th width="120">Tipo</th>
		<th width="120">Valor</th>
		<th width="120">Conta</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listMovimentacoes}" var="movimentacao">
		<tr>
			<td>${movimentacao.id}</td>
			<td>${movimentacao.tipo}</td>
			<td>${movimentacao.valor}</td>
			<td>${movimentacao.conta.numero}</td>
			<td><a href="<c:url value='/movimentacao/edit/${movimentacao.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/movimentacao/remove/${movimentacao.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
