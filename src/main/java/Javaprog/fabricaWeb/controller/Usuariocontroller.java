package Javaprog.fabricaWeb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Javaprog.fabricaWeb.entidade.Usuario;
import Javaprog.fabricaWeb.persistencia.jdbc.UsuarioDAO;

//http://localhost:8080/fabricaweb/usucontroller
@WebServlet("/usucontroller")
public class Usuariocontroller extends HttpServlet {
	public Usuariocontroller() {
		System.out.println("novo SErvlet");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init");
		super.init();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");// TODO Auto-generated method stub
		String acao = req.getParameter("acao");
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		if (acao.equals("exc")) {
			String id = req.getParameter("id");
			Usuario usu = new Usuario();
			usu.setId(Integer.parseInt(id));
			usuarioDAO.excluir(usu);

		} else if (acao.equals("Lis")) {
			List<Usuario> lista = usuarioDAO.buscarTodos();
			for (Usuario u : lista) {
				resp.getWriter().println(u.getNome() + "<br>");
				req.setAttribute("Lista", lista);
				RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/listausu.jsp");
				dispatcher.forward(req, resp);
			}
		} else if (acao.equals("alt")) {
			String id = req.getParameter("id");
			Usuario usuario = usuarioDAO.buscarPorId(Integer.parseInt(id));
			req.setAttribute("usu", usuario);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/alterarusu.jsp");
			dispatcher.forward(req, resp);
		} else if (acao.equals("add")) {

			Usuario usu = new Usuario();
			usuarioDAO.salvar(usu);
			req.setAttribute("usu", usu);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/addusu2.jsp");
			dispatcher.forward(req, resp);
		} else if (acao.equals("cad")) {
			Usuario usu = new Usuario();
			usu.setId(0);
			usu.setNome("");
			usu.setLogin("");
			usu.setSenha("");
			req.setAttribute("usu", usu);
			RequestDispatcher dispatcher = req. getRequestDispatcher("WEB-INF/addusu2.jsp");
			dispatcher.forward(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String nome = req.getParameter("nome");
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		Usuario usu = new Usuario();
		if (id != null)
			usu.setId(Integer.parseInt(id));
		usu.setNome(nome);
		usu.setLogin(login);
		usu.setSenha(senha);

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usu);

		resp.sendRedirect("usucontroller?acao=Lis");

	}

	@Override
	public void destroy() {
		System.out.println("aca bow");
		super.destroy();
	}

}