package atividadeQualitativaDAC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import atividadeQualitativaDAC.conexao.Conexao;
import atividadeQualitativaDAC.entidates.Itinerario;

public class ItinerarioDao {
    
    private Connection connection;
    
    public ItinerarioDao() {
        try {
            this.connection = new Conexao().obterConexao();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void insereItinerario(Itinerario itinerario) {
        String sql = "INSERT INTO itinerario (id, id_aviao, origem, destino, dataVoo) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, itinerario.getId());
            stmt.setInt(2, itinerario.getId_aviao());
            stmt.setString(3, itinerario.getOrigem());
            stmt.setString(4, itinerario.getDestino());
            stmt.setString(5, itinerario.getDataVoo());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Itinerario byId(int id) {
        try {
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM itinerario WHERE id=?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Itinerario itinerario = new Itinerario();
            while (rs.next()) {
                itinerario.setId(rs.getInt("id"));
                itinerario.setId_aviao(rs.getInt("id_aviao"));
                itinerario.setOrigem(rs.getString("origem"));
                itinerario.setDestino(rs.getString("destino"));
                itinerario.setDataVoo(rs.getString("dataVoo"));
            }
            return itinerario;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Itinerario atualizarItinerario(Itinerario itinerario) {
        try {
            PreparedStatement stmt = this.connection.prepareStatement("UPDATE itinerario SET id_aviao = ?, origem = ?, destino = ?, dataVoo = ? WHERE id = ?");
            stmt.setInt(1, itinerario.getId_aviao());
            stmt.setString(2, itinerario.getOrigem());
            stmt.setString(3, itinerario.getDestino());
            stmt.setString(4, itinerario.getDataVoo());
            stmt.setInt(5, itinerario.getId());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new RuntimeException("Nenhum itinerário foi atualizado. Verifique o ID fornecido.");
            }
            return itinerario;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar o itinerário: " + e.getMessage());
        }
    }
    
    public void removerItinerario(int id) {
        try {
            PreparedStatement stmt = this.connection.prepareStatement("DELETE FROM itinerario WHERE id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover o itinerário: " + e.getMessage());
        }
    }
}
