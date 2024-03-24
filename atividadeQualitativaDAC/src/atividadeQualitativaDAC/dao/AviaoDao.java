package atividadeQualitativaDAC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import atividadeQualitativaDAC.conexao.Conexao;
import atividadeQualitativaDAC.entidates.Aviao;

public class AviaoDao {
	
	private Connection connection;
	
	
	public AviaoDao() {
		try {
			this.connection = new Conexao().obterConexao();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void insereAviao(Aviao aviao) {
		String sql = "insert into aviao (id, modelo) values (?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, aviao.getId());
			stmt.setString(2, aviao.getModelo());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
	public Aviao byId(int id) {
		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from aviao where id=?");
			stmt.setInt(1,id);
			ResultSet rs = stmt.executeQuery();
			Aviao aviao = new Aviao();
			while (rs.next()) {
				aviao.setId(rs.getInt("id"));
				aviao.setModelo(rs.getString("modelo"));
			}
			return aviao;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public Aviao atualizarAviao(Aviao aviao) {
	    try {
	        PreparedStatement stmt = this.connection.prepareStatement("UPDATE aviao SET modelo = ? WHERE id = ?");
	        stmt.setString(1, aviao.getModelo());
	        stmt.setInt(2, aviao.getId());
	        int rowsAffected = stmt.executeUpdate();
	        if (rowsAffected == 0) {
	            throw new RuntimeException("Nenhum avião foi atualizado. Verifique o ID fornecido.");
	        }
	        return aviao;
	    } catch (SQLException e) {
	        throw new RuntimeException("Erro ao atualizar o avião: " + e.getMessage());
	    }
	}

	
	public void removerAviao(int id) {
	    try {
	        PreparedStatement stmt = this.connection.prepareStatement("DELETE FROM aviao WHERE id=?");
	        stmt.setInt(1, id);
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        throw new RuntimeException("Erro ao remover o avião: " + e.getMessage());
	    }
	}
}
