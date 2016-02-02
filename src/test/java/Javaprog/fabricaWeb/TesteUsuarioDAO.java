package Javaprog.fabricaWeb;

import java.util.List;

import Javaprog.fabricaWeb.entidade.Usuario;
import Javaprog.fabricaWeb.persistencia.jdbc.UsuarioDAO;

public class TesteUsuarioDAO {
	public static void main(String[] args) {

		
		testAutenticar();
	}

	private static void testAutenticar() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usu = new Usuario();
		usu.setLogin("jzao");
		usu.setSenha("123");
		Usuario usuRetorno = usuarioDAO.autenticar(usu);
		System.out.println(usuRetorno);
	}

	public static void testAlterar() {
		// Criando o Usuário
		Usuario usu = new Usuario();
		usu.setId(2);
		usu.setNome("jaozao da silva");
		usu.setLogin("jzaoss");
		usu.setSenha("123456");

		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.alterar(usu);

		System.out.println("eu funcionii");
	}

	public static void testCadastrar() {

		// Criando o Usuário
		Usuario usu = new Usuario();
		usu.setNome("jaozao");
		usu.setLogin("jzao");
		usu.setSenha("123");

		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.cadastrar(usu);

		System.out.println("foi otimo ");
	}

	public static void testExcluir() {
		// Criando o Usuário
		Usuario usu = new Usuario();
		usu.setId(2);

		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.excluir(usu);

		System.out.println("eu apaguiii");
	}

	public static void testSalvar() {
		Usuario usuario = new Usuario();
		// usuario.setId(1);
		usuario.setNome("maria joana");
		usuario.setLogin("mar");
		usuario.setSenha("senha");
		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.salvar(usuario);
		System.out.println("eu salvii");

	}

	public static void testBuscarPorId() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscarPorId(3);
		System.out.println(usuario);
	}

	public static void testBuscarTodos() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> lista = usuarioDAO.buscarTodos();
		for (Usuario u : lista) {
			System.out.println(u);
		}
	}

}
