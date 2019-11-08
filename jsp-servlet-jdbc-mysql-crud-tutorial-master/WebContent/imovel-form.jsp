<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Imovel Management Application</title>
</head>
<body>
	<center>
		<h1>Imovel Management</h1>
        <h2>
        	<a href="new">Add New Imóvel</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">List All Imóveis</a>
        	
        </h2>
	</center>
    <div align="center">
    
		<c:if test="${imovel != null}">
			<form action="update" method="post">
        </c:if>
        
        <c:if test="${imovel == null}">
			<form action="insert" method="post">
        </c:if>
        
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${imovel != null}">
            			Edit Imóvel
            		</c:if>
            		<c:if test="${imovel == null}">
            			Add New Imóvel
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${imovel != null}">
        			<input type="hidden" name="id" value="<c:out value='${imovel.id}' />" />
        		</c:if>            
            <tr>
                <th>Disponivel: </th>
                <td>
                	<input type="text" name="disponivel" size="45"
                			value="<c:out value='${imovel.disponivel}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>Alugado: </th>
                <td>
                	<input type="text" name="alugado" size="45"
                			value="<c:out value='${imovel.alugado}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Vendido: </th>
                <td>
                	<input type="text" name="vendido" size="45"
                			value="<c:out value='${imovel.vendido}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Estado: </th>
                <td>
                	<input type="text" name="estado" size="45"
                			value="<c:out value='${imovel.estado}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Cidade: </th>
                <td>
                	<input type="text" name="cidade" size="45"
                			value="<c:out value='${imovel.cidade}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Bairro: </th>
                <td>
                	<input type="text" name="bairro" size="45"
                			value="<c:out value='${imovel.bairro}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Rua: </th>
                <td>
                	<input type="text" name="rua" size="45"
                			value="<c:out value='${imovel.rua}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Numero: </th>
                <td>
                	<input type="text" name="numero" size="45"
                			value="<c:out value='${imovel.numero}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Complemento: </th>
                <td>
                	<input type="text" name="complemento" size="45"
                			value="<c:out value='${imovel.complemento}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>CEP: </th>
                <td>
                	<input type="text" name="cep" size="45"
                			value="<c:out value='${imovel.cep}' />"
                	/>
                </td>
            </tr>
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Save" />
            	</td>
            </tr>
        </table>
        
        </form>
    </div>	
</body>
</html>
