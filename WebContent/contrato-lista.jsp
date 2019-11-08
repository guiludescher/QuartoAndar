<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>User Management Application</title>
</head>
<body>
	<center>
		<h1>User Management</h1>
        <h2>
        	<a href="new">Adicionar Contrato</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">Listar Contrato</a>
        	
        </h2>
	</center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Lista de Contratos</h2></caption>
            <tr>
                <th>ID</th>
                <th>ID Imóvel</th>
                <th>ID Cliente</th>
                <th>Valor Mensal</th>
                <th>Início</th>
                <th>Fim</th>
                <th>Multa</th>
            </tr>
            <c:forEach var="contrato" items="${listContratos}">
                <tr>
                    <td><c:out value="${contrato.id}" /></td>
                    <td><c:out value="${contrato.idImovel}" /></td>
                    <td><c:out value="${contrato.idCliente}" /></td>
                    <td><c:out value="${contrato.valor}" /></td>
                    <td><c:out value="${contrato.dataInicio}" /></td>
                    <td><c:out value="${contrato.dataFim}" /></td>
                    <td><c:out value="${contrato.multa}" /></td>
                    <td>
                    	<a href="edit?id=<c:out value='${contrato.id}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete?id=<c:out value='${contrato.id}' />">Delete</a>                    	
                    </td>
                </tr>
            </c:forEach>
            
        </table>
    </div>	
</body>
</html>
