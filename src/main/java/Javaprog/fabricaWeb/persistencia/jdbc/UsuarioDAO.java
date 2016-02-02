package Javaprog.fabricaWeb.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Javaprog.fabricaWeb.entidade.Usuario;

public class UsuarioDAO {
	Connection con = ConexaoFactory.getConnection();

	public void cadastrar(Usuario usu) {
		Connection con = ConexaoFactory.getConnection();
		String sql = "insert into usuario (nome,login,senha) values(? , ? ,? )";

		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			;
			preparador.setString(1, usu.getNome());// substitui o ? pelo dado
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());
			// executar o comando sql no banco
			preparador.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void alterar(Usuario usu) {
		Connection con = ConexaoFactory.getConnection();
		String sql = "update usuario set nome=?,login=?,senha=? where id=?";

		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			;

			preparador.setString(1, usu.getNome());// substitui o ? pelo dado
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());
			preparador.setInt(4, usu.getId());
			// executar o comando sql no banco
			preparador.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * exclui do banco de dados o usuario pelo ID
	 * 
	 * @param usu
	 *            e o objeto que corresponde ao usuario
	 */
	public void excluir(Usuario usu) {
		Connection con = ConexaoFactory.getConnection();
		String sql = "delete from usuario where id=?";

		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			;

			preparador.setInt(1, usu.getId());
			// executar o comando sql no banco
			preparador.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub

	}

	/**
	 * id= nulo cadastra novo usuario, id existente altera dados do usuario
	 * @param usu
	 * @return 
	 * @return 
	 */
	public  void salvar(Usuario usu) {
		if (usu.getId() != null && usu.getId()!= 0 ) {
			alterar(usu);
		} else {
			cadastrar(usu);
		}
	}

	/**
	 * busca de um resgistro no banco de dados pelo id do usuario
	 * 
	 * @param id
	 *            é um inteiro que representa o numero do id do usuario
	 * 
	 * @return um objeto usuario quando encontra ou nulo quando nao encontra
	 */
	public Usuario buscarPorId(Integer id) {
		Connection con = ConexaoFactory.getConnection();
		String sql = "Select * from usuario where id=?";
		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			preparador.setInt(1, id);
			// Retorno da consulta em Resultset
			ResultSet resultado = preparador.executeQuery();
			// posicionando o cursor
			if (resultado.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
				return usuario;

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}

	/**
	 * Realiza a busca de todos os registro da tabel usuário
	 * 
	 * @return uma lista de objetos Usuario contendo 0 tiver registros ou n
	 *         elementos quando tiver resultado.
	 */
	public List<Usuario> buscarTodos() {
		Connection con = ConexaoFactory.getConnection();
		String sql = "Select * from usuario";
		List<Usuario> lista = new ArrayList<Usuario>();
		try (PreparedStatement preparador = con.prepareStatement(sql)) {

			ResultSet resultado = preparador.executeQuery();
			// posicionando o cursor
			while (resultado.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
				// Adicionando usuario na lista
				lista.add(usuario);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return lista;

	}

	/**
	 * Autentica o login e senha
	 * 
	 * @param usuConsulta
	 * @return
	 */
	public Usuario autenticar(Usuario usuConsulta) {
		String sql = "Select * from usuario where login=? and senha=?";
		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			preparador.setString(1, usuConsulta.getLogin());
			preparador.setString(2, usuConsulta.getSenha());
			ResultSet resultado = preparador.executeQuery();

			if (resultado.next()) {
				Usuario usuario = new Usuario();

				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));

				return usuario;
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
