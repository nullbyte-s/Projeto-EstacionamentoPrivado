package src.Utils;

import src.Entities.Carro;
import src.Entities.Modelo;
import src.Main.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CadastroVeiculoDAO {
    private Connection connection;

    public CadastroVeiculoDAO() {
        this.connection = new Conexao().GeraConexao();
    }

    // Create
    public void adiciona(Carro carro) {
        if (carroJaExiste(carro.getIdCar())) {
            System.out.println("Carro com id " + carro.getIdCar() + " já existe na tabela.");
            return;
        }
        String sql = "INSERT INTO Carro(idCar, idUser, placa, cor) VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, carro.getIdCar());
            stmt.setInt(2, carro.getIdUser());
            stmt.setString(3, carro.getPlaca());
            stmt.setString(4, carro.getCor());
            stmt.execute();
            stmt.close();
            System.out.println("Carro cadastrado com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean carroJaExiste(int idUser) {
        // Verifica se o usuário já existe no banco de dados
        String sql = "SELECT COUNT(*) FROM usuario WHERE idUser = ?";
        try { PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idUser);
            ResultSet resultSet = stmt.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            stmt.close(); return count > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}