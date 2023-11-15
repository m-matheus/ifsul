package br.com.matheuscarrent.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.matheuscarrent.model.Veiculo;

public class VeiculoDAO {
    private ConexaoMysql conexao;

    public VeiculoDAO() {
		conexao = new ConexaoMysql("localhost", "3306", "root", "root", "bd_aluguel_veiculos");
	}

    // Cadastra veiculos
    public void cadastrarVeiculo(Veiculo veiculo) {
        this.conexao.abrirConexao();
        String sql = "INSERT INTO veiculo VALUES(null, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement st;
        try {
            st = conexao.getConexao().prepareStatement(sql);
            st.setString(1, veiculo.getPlaca());
            st.setString(2, veiculo.getModelo());
            st.setString(3, veiculo.getCor());
            st.setLong(4, veiculo.getAno());
            st.setDouble(5, veiculo.getPreco());
            st.setLong(6, veiculo.getProprietario().getId());
            st.setString(7, veiculo.getStatus());
            st.executeUpdate();
        }   catch (SQLException e) {
            e.printStackTrace();
        }   finally {
			// fechar a conexao
			conexao.fecharConexao();
		}
    }

    // public Veiculo buscarVeiculoPorId(long id) {
    //     Connection connection = conexao.getConexao();
    //     String sql = "SELECT * FROM veiculo WHERE id_veiculo = ?";
    //     try (PreparedStatement statement = connection.prepareStatement(sql)) {
    //         statement.setLong(1, id);
    //         ResultSet resultSet = statement.executeQuery();
    //         if (resultSet.next()) {
    //             Veiculo veiculo = new Veiculo();
    //             veiculo.setId(resultSet.getLong("id_veiculo"));
    //             veiculo.setPlaca(resultSet.getString("placa"));
    //             veiculo.setModelo(resultSet.getString("modelo"));
    //             veiculo.setCor(resultSet.getString("cor"));
    //             veiculo.setAno(resultSet.getInt("ano"));
    //             veiculo.setPreco(resultSet.getDouble("preco"));
    //             return veiculo;
    //         }
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    //     return null;
    // }

    // public void editarVeiculo(Veiculo veiculo) {
    //     this.conexao.abrirConexao();
    //     PreparedStatement st;
    //     String sql = "UPDATE veiculo SET placa = ?, modelo = ?, cor = ?, ano = ?, preco = ? WHERE id_veiculo = ?";
    //     try {
    //         st = conexao.getConexao().prepareStatement(sql);
    //         st.setString(1, veiculo.getPlaca());
    //         st.setString(2, veiculo.getModelo());
    //         st.setString(3, veiculo.getCor ());
    //         st.setInt(4, veiculo.getAno ());
    //         st.setDouble(5, veiculo.getPreco());
    //         st.setLong(6, veiculo.getProprietario().getId());
    //         st.executeUpdate();
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     } finally {
	// 		// fechar a conexao
	// 		conexao.fecharConexao();
	// 	}   
    // }

    // Edita veiculo (usado para mudar o status do veiculo)
    public void editarVeiculo(Veiculo veiculo) {
        this.conexao.abrirConexao();
        String sql = "UPDATE veiculo SET status = ? WHERE id_veiculo = ?;";
    
        try {
            PreparedStatement st = conexao.getConexao().prepareStatement(sql);
            st.setString(1, veiculo.getStatus());
            st.setLong(2, veiculo.getId());
    
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
    }

    // Busca os veiculos do usuario atual
    public List<Veiculo> buscarVeiculosUsuario(long id) {
        List<Veiculo> veiculos = new ArrayList<>();
        this.conexao.abrirConexao();
        String sql = "SELECT * FROM veiculo WHERE id_usuario = ?";
        try {
            PreparedStatement st = conexao.getConexao().prepareStatement(sql);
            st.setLong(1, id); // Define o ID do usuário na consulta
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Veiculo veiculo = new Veiculo();
                veiculo.setId(rs.getLong("id_veiculo"));
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setCor(rs.getString("cor"));
                veiculo.setAno(rs.getInt("ano"));
                veiculo.setPreco(rs.getDouble("preco"));
                veiculo.setStatus(rs.getString("status"));
                veiculos.add(veiculo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
        return veiculos;
    }

    // Busca todos veiculos da tabela
    public List<Veiculo> buscarTodosVeiculos() {
        List<Veiculo> veiculos = new ArrayList<>();
        this.conexao.abrirConexao();
        String sql = "SELECT * FROM veiculo";
        try {
            PreparedStatement st = conexao.getConexao().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Veiculo veiculo = new Veiculo();
                veiculo.setId(rs.getLong("id_veiculo"));
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setCor(rs.getString("cor"));
                veiculo.setAno(rs.getInt("ano"));
                veiculo.setPreco(rs.getDouble("preco"));
                veiculo.setStatus(rs.getString("status"));
                
                veiculos.add(veiculo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
        return veiculos;
    }


    // public List<Veiculo> buscarVeiculosReservadosUsuario(long idUsuario) {
    //     List<Veiculo> veiculosReservados = new ArrayList<>();
    //     this.conexao.abrirConexao();
    //     String sql = "SELECT * FROM veiculo WHERE id_usuario = ? OR id_veiculo IN (SELECT id_veiculo FROM reservas WHERE id_usuario_reserva = ?)";
    //     try {
    //         PreparedStatement st = conexao.getConexao().prepareStatement(sql);
    //         st.setLong(1, idUsuario);
    //         st.setLong(2, idUsuario);
    //         ResultSet rs = st.executeQuery();
    //         while (rs.next()) {
    //             Veiculo veiculo = new Veiculo();
    //             veiculo.setId(rs.getLong("id_veiculo"));
    //             veiculo.setPlaca(rs.getString("placa"));
    //             veiculo.setModelo(rs.getString("modelo"));
    //             veiculo.setCor(rs.getString("cor"));
    //             veiculo.setAno(rs.getInt("ano"));
    //             veiculo.setStatus(rs.getString("status"));
    //             veiculosReservados.add(veiculo);
    //         }
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     } finally {
    //         conexao.fecharConexao();
    //     }
    //     return veiculosReservados;
    // }
}
