package atividadeQualitativaDAC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import atividadeQualitativaDAC.conexao.Conexao;
import atividadeQualitativaDAC.entidates.Passageiro;

public class PassageiroDao {
    
    private Connection connection;
    
    public PassageiroDao() {
        try {
            this.connection = new Conexao().obterConexao();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void inserePassageiro(Passageiro passageiro) {
        String sql = "INSERT INTO passageiro (id, nome, id_itinerario) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, passageiro.getId());
            stmt.setString(2, passageiro.getNome());
            stmt.setInt(3, passageiro.getId_itinerario());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Passageiro byId(int id) {
        try {
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM passageiro WHERE id=?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Passageiro passageiro = new Passageiro();
            while (rs.next()) {
                passageiro.setId(rs.getInt("id"));
                passageiro.setNome(rs.getString("nome"));
                passageiro.setId_itinerario(rs.getInt("id_itinerario"));
            }
            return passageiro;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Passageiro atualizarPassageiro(Passageiro passageiro) {
        try {
            PreparedStatement stmt = this.connection.prepareStatement("UPDATE passageiro SET nome = ?, id_itinerario = ? WHERE id = ?");
            stmt.setString(1, passageiro.getNome());
            stmt.setInt(2, passageiro.getId_itinerario());
            stmt.setInt(3, passageiro.getId());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new RuntimeException("Nenhum passageiro foi atualizado. Verifique o ID fornecido.");
            }
            return passageiro;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar o passageiro: " + e.getMessage());
        }
    }
    
    public void removerPassageiro(int id) {
        try {
            PreparedStatement stmt = this.connection.prepareStatement("DELETE FROM passageiro WHERE id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover o passageiro: " + e.getMessage());
        }
    }
}
