<!DOCTYPE html>


<%@page import= "javax.servlet.RequestDispatcher"%>
<%@page import ="javax.servlet.ServletException"%>
<%@page import ="javax.servlet.annotation.WebServlet"%>
<%@page import ="javax.servlet.http.HttpServlet"%>
<%@page import ="javax.servlet.http.HttpServletRequest"%>
<%@page import ="javax.servlet.http.HttpServletResponse"%>
<%@page import="java.util.List"%>
<%@page import="Javaprog.fabricaWeb.entidade.Usuario"%>
<%@page import="Javaprog.fabricaWeb.persistencia.jdbc.UsuarioDAO"%>
<%@page import="Javaprog.fabricaWeb.controller.Usuariocontroller"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		Usuario usuario = (Usuario) request.getAttribute("usu");
	%>
	<form action="usucontroller" method="post">
		
			
			
		
		nome:<input  type="text" name="nome" value="" />
		login:<input type="text" name="login" value="" /> 
		senha:<input type="text" name="senha" value="" /> 
		      <input type="submit"		      value="Salvar">
		     <% UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.salvar(usuario); %>
	</form>
</body>
</html>