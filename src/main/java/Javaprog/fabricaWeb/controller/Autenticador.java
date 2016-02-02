package Javaprog.fabricaWeb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Javaprog.fabricaWeb.entidade.Usuario;
import Javaprog.fabricaWeb.persistencia.jdbc.UsuarioDAO;

@WebServlet("autenticador")
public class Autenticador extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		Usuario usuario = new Usuario();

		usuario.setSenha(senha);
		usuario.setLogin(login);

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario Usuautenticado = usuarioDAO.autenticar(usuario);
		if (Usuautenticado != null) {
			HttpSession session = req.getSession();
			session.setAttribute("usuautentic", Usuautenticado);

			req.getRequestDispatcher("WEB-INF.jsp").forward(req, resp);

		} else {
			resp.getWriter().print("<script> window.alert('nao encontrado'); href='login.html';</script>");
		}
		super.doPost(req, resp);
	}

}
