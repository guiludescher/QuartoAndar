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
        	<a href="new">Add New Imóvel</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">List All Imóveis</a>
        	
        </h2>
	</center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Imóveis</h2></caption>
            <tr>
            <!--disponivel, alugado, vendido, estado, cidade, bairro, rua, numero, complemento, cep -->
                <th>ID</th>
                <th>Disponível</th>
                <th>Alugado</th>
                <th>Vendido</th>
                <th>Estado</th>
                <th>Cidade</th>
                <th>Bairro</th>
                <th>Rua</th>
                <th>Número</th>
                <th>Complemento</th>
                <th>CEP</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="imovel" items="${listImovel}">
                <tr>
                    <td><c:out value="${imovel.id}" /></td>
                    <td><c:out value="${imovel.disponivel}" /></td>
                    <td><c:out value="${imovel.alugado}" /></td>
                    <td><c:out value="${imovel.vendido}" /></td>
                    <td><c:out value="${imovel.estado}" /></td>
                    <td><c:out value="${imovel.cidade}" /></td>
                    <td><c:out value="${imovel.bairro}" /></td>
                    <td><c:out value="${imovel.rua}" /></td>
                    <td><c:out value="${imovel.numero}" /></td>
                    <td><c:out value="${imovel.complemento}" /></td>
                    <td><c:out value="${imovel.cep}" /></td>
                    <td>
                    	<a href="edit?id=<c:out value='${imovel.id}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete?id=<c:out value='${imovel.id}' />">Delete</a>                    	
                    </td>
                </tr>
            </c:forEach>
            
        </table>
    </div>	
</body>
</html>
