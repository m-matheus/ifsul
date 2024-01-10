package br.com.matheuscarrent.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.matheuscarrent.model.Usuario;

public class UsuarioDAO {
    private ConexaoMysql conexao;

	public UsuarioDAO() {
		conexao = new ConexaoMysql("localhost", "3306", "root", "root", "bd_aluguel_veiculos");
	}


	// salvar
	public void salvar(Usuario usuario) {
		// abrir conexao com bd
		this.conexao.abrirConexao();
		// inserir no banco
		String sql = "INSERT INTO usuario VALUES(null, ?, ?, ?);";
		PreparedStatement st;
		try {
			st = conexao.getConexao().prepareStatement(sql);
			st.setString(1, usuario.getNome());
			st.setString(2, usuario.getEmail());
			st.setString(3, usuario.getSenha());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// fechar a conexao
			conexao.fecharConexao();
		}
	}


	// // editar
	// public void editar(Usuario usuario) {
	// 	// abrir conexao com bd
	// 	this.conexao.abrirConexao();
	// 	// inserir no banco
	// 	String sql = "UPDATE usuario SET nome=?, email=?, senha=? WHERE id_usuario=?;";
	// 	PreparedStatement st;
	// 	try {
	// 		st = conexao.getConexao().prepareStatement(sql);
	// 		st.setString(1, usuario.getNome());
	// 		st.setString(2, usuario.getEmail());
	// 		st.setString(3, usuario.getSenha());
	// 		st.setLong(4, usuario.getId());
	// 		st.executeUpdate();
	// 	} catch (SQLException e) {
	// 		e.printStackTrace();
	// 	} finally {
	// 		// fechar a conexao
	// 		conexao.fecharConexao();
	// 	}
	// }


	// // excluir
	// public void excluir(long id) {
	// 	// abrir conexao com bd
	// 	this.conexao.abrirConexao();
	// 	// inserir no banco
	// 	String sql = "DELETE FROM usuario WHERE id_usuario=?;";
	// 	PreparedStatement st;
	// 	try {
	// 		st = conexao.getConexao().prepareStatement(sql);
	// 		st.setLong(1, id);
	// 		st.executeUpdate();
	// 	} catch (SQLException e) {
	// 		e.printStackTrace();
	// 	} finally {
	// 		// fechar a conexao
	// 		conexao.fecharConexao();
	// 	}
	// }


	// buscarPorId
	public Usuario buscarPorId(long id) {
		Usuario u = null;
		// abrir conexao com bd
		this.conexao.abrirConexao();
		// inserir no banco
		String sql = "SELECT * FROM usuario WHERE id_usuario=?;";
		PreparedStatement st;
		try {
			st = conexao.getConexao().prepareStatement(sql);
			st.setLong(1, id);
			ResultSet rs = st.executeQuery();
			// converter a linha inteira do rs em um usuario
			// o rs � tudo que veio da busca no banco
			if (rs.next()) {
				// converter a linha em um usuario
				u = new Usuario();
				u.setId(rs.getLong("id_usuario"));
				u.setNome(rs.getString("nome"));
				u.setEmail(rs.getString("email"));
				u.setSenha(rs.getString("senha"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// fechar a conexao
			conexao.fecharConexao();
		}
		return u;
	}

	// buscarTodos
	public List<Usuario> buscarTodos() {
		List<Usuario> listaUsuarios = new ArrayList<>();
		Usuario u = null;
		// abrir conexao com bd
		this.conexao.abrirConexao();
		// inserir no banco
		String sql = "SELECT * FROM usuario;";
		PreparedStatement st;
		try {
			st = conexao.getConexao().prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			// converter a linha inteira do rs em um usuario
			// o rs � tudo que veio da busca no banco
			while (rs.next()) {
				// converter a linha em um usuario
				u = new Usuario();
				u.setId(rs.getLong("id_usuario"));
				u.setNome(rs.getString("nome"));
				u.setEmail(rs.getString("email"));
				u.setSenha(rs.getString("senha"));
				listaUsuarios.add(u);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// fechar a conexao
			conexao.fecharConexao();
		}
		return listaUsuarios;
	}

	public Usuario fazerLogin(String email, String senha) {
		Usuario u = null;
		this.conexao.abrirConexao();
		String sql = "SELECT * FROM usuario WHERE email=? AND senha=?;";
		PreparedStatement st;
		try {
			st = conexao.getConexao().prepareStatement(sql);
			st.setString(1, email);
			st.setString(2, senha);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				u = new Usuario();
				u.setId(rs.getLong("id_usuario"));
				u.setNome(rs.getString("nome"));
				u.setEmail(rs.getString("email"));
				u.setSenha(rs.getString("senha"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexao.fecharConexao();
		}
		return u;
	}
	
}
