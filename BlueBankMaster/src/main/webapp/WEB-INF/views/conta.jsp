<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Conta Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Add a Conta
</h1>

<c:url var="addAction" value="/conta/buscar" ></c:url>
<form:form action="${addAction}" commandName="conta">
<table>
	<c:if test="${!empty conta.id}">
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
			<form:label path="agencia">
				<spring:message text="agencia"/>
			</form:label>
		</td>
		<td>
			<form:input path="agencia" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="numero">
				<spring:message text="numero"/>
			</form:label>
		</td>
		<td>
			<form:input path="numero" />
		</td>
	</tr>
		<tr>
		<td>
			<form:label path="cpf">
				<spring:message text="cpf"/>
			</form:label>
		</td>
		<td>
			<form:input path="cpf" />
		</td>
	</tr>
		<tr>
		<td>
			<form:label path="saldo">
				<spring:message text="saldo"/>
			</form:label>
		</td>
		<td>
			<form:input path="saldo" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty conta.agencia}">
				<input type="submit"
					value="<spring:message text="Edit Conta"/>" />
			</c:if>
			<c:if test="${empty conta.agencia}">
				<input type="submit"
					value="<spring:message text="Add Conta"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Contas List</h3>
<c:if test="${!empty listContas}">
	<table class="tg">
	<tr>
		<th width="80">Conta ID</th>
		<th width="120">Conta Agência</th>
		<th width="120">Conta Número</th>
		<th width="120">Conta CPF</th>
		<th width="120">Conta Saldo</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listContas}" var="conta">
		<tr>
			<td>${conta.id}</td>
			<td>${conta.agencia}</td>
			<td>${conta.numero}</td>
			<td>${conta.cpf}</td>
			<td>${conta.saldo}</td>
			<td><a href="<c:url value='/conta/edit/${conta.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/conta/remove/${conta.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
