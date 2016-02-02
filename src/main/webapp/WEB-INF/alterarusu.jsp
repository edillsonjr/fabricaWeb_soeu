<!DOCTYPE html>
<%@page import="Javaprog.fabricaWeb.entidade.Usuario"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Usuario u= (Usuario)request.getAttribute("usu");
%>
	<form action="usucontroller" method="post">
		ID:<input type="number" name="id" value="<%=u.getId() %>" /> 
		nome:<input type="text"name="nome" value="<%=u.getNome() %>" /> 
		login:<input type="text" name="login"value="<%=u.getLogin() %>" /> 
		senha:<input type="text" name="senha" value="<%=u.getSenha() %>" /> 
		
		<input		type="submit" value="Salvar">
	</form>
</body>
</html>