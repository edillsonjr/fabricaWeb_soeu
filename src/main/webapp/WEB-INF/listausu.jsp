<%@page import="java.util.List"%>
<%@page import="Javaprog.fabricaWeb.entidade.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Usuarios</title>
<script type="text/javascript">
	function confirmaExclusao(id) {
		if (window.confirm('Tem certeza que deseja excluir?')) {
			location.href = "usucontroller?acao=exc&id=" + id;
		}
	}
</script>
</head>
<body>
	<%
		List<Usuario> lista = (List<Usuario>) request.getAttribute("Lista");
	%>
	
		<a href="http://localhost:8080/fabricaweb/usucontroller?acao=add">adicionar</a>
	<table border=1>
		<tr>
			<th>id</th>
			<th>nome</th>
			<th>Ação</th>
		</tr>
		<%
			for (Usuario u : lista) {
		%>
		<tr>
			<td>
				<%
					out.print(u.getId());
				%>
			</td>
			<td><%=u.getNome()%>
			<td><a href="javascript:confirmaExclusao(<%=u.getId()%>)">
					Excluir</a>| <a href="usucontroller?acao=alt&id=<%=u.getId()%>">alterar</a></td>



		
		
		</tr>
		<%
			}
		%>
	</table>

</body>
</html>