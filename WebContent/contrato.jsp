<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Aplicação Gerenciadora de Contratos de Aluguel</title>
</head>
<body>
	<center>
		<h1>Contratos de Aluguel</h1>
        <h2>
        	<a href="new">Adicionar Contrato</a>
        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        	<a href="list">Listar Contratos</a>
        	
        </h2>
	</center>
    <div align="center">
    
		<c:if test="${contrato != null}">
			<form action="update" method="post">
        </c:if>
        
        <c:if test="${contrato == null}">
			<form action="insert" method="post">
        </c:if>
        
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${contrato != null}">
            			Editar Contrato
            		</c:if>
            		<c:if test="${contrato == null}">
            			Adicionar Contrato
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${contrato != null}">
        			<input type="hidden" name="id" value="<c:out value='${contrato.id}' />" />
        		</c:if>            
            <tr>
                <th>ID Imóvel: </th>
                <td>
                	<input type="number" name="idImovel" size="45"
                			value="<c:out value='${contrato.idImovel}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>ID Cliente: </th>
                <td>
                	<input type="text" name="idCliente" size="45"
                			value="<c:out value='${contrato.idCliente}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Valor Mensal: </th>
                <td>
                	<input type="number" name="valor" size="15"
                			value="<c:out value='${contrato.valor}' />"
                	/>
                </td>
            </tr>
           	<tr>
                <th>Início: </th>
                <td>
                	<input type="number" name="dataInicio" size="15"
                			value="<c:out value='${contrato.dataInicio}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Fim: </th>
                <td>
                	<input type="number" name="dataFim" size="15"
                			value="<c:out value='${contrato.dataFim}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Multa: </th>
                <td>
                	<input type="number" name="multa" size="15"
                			value="<c:out value='${contrato.multa}' />"
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
