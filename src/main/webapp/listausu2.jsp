<%@page import="java.util.List"%>
<%@page import="Javaprog.fabricaWeb.entidade.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Usuarios</title>
</head>
<body>
	<%
		List<Usuario> lista = (List<Usuario>) request.getAttribute("Lista");
		out.print("<table  border= 1>");
		out.print("<tr> <th> id </th> <th> nome </th> </tr>");
		for (Usuario u : lista) {
			out.print("<tr>");
			out.print("<td>" + u.getId() + "</td> <td>" + u.getNome() + "<br> ");
			out.print("</tr>");
		}
		out.print("</table>");
	%>
</body>
</html>