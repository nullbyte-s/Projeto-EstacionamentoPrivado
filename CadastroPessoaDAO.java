import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CadastroPessoaDAO {
    private Connection connection;

    public CadastroPessoaDAO() {
        this.connection = new Conexao().GeraConexao();
    }

    // Create
    public void adiciona(@NotNull Pessoa pessoa) {
        if (pessoaJaExiste(pessoa.getIdP())) {
            System.out.println("Pessoa com id " + pessoa.getIdP() + " já existe na tabela.");
            return;
        }
        String sql = "INSERT INTO Pessoa(idP, cpf, email, nome, senha) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, pessoa.getIdP());
            stmt.setString(2, pessoa.getCpf());
            stmt.setString(3, pessoa.getEmail());
            stmt.setString(4, pessoa.getNome());
            stmt.setString(5, pessoa.getSenha());
            stmt.execute();
            stmt.close();
            System.out.println("Pessoa cadastrada com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean pessoaJaExiste(int idP) {
    // Verifica se a pessoa já existe no banco de dados
        String sql = "SELECT COUNT(*) FROM pessoa WHERE idP = ?";
        try { PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idP);
            ResultSet resultSet = stmt.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            stmt.close(); return count > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Read
    public ArrayList<Pessoa> listar() {
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        String sql = "SELECT idP, cpf, email, nome, senha FROM pessoa";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Pessoa p = new Pessoa();
                p.setIdP(resultSet.getInt("idP"));
                p.setCpf(resultSet.getString("cpf"));
                p.setEmail(resultSet.getString("email"));
                p.setNome(resultSet.getString("nome"));
                p.setSenha(resultSet.getString("senha"));
                pessoas.add(p);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pessoas;
    }

    // Read por ID
    public Pessoa buscarPorId(int idP) { String sql = "SELECT idP, cpf, email, nome, senha FROM pessoa WHERE idP = ?";
        try { PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idP); ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) { Pessoa p = new Pessoa();
                p.setIdP(resultSet.getInt("idP"));
                p.setCpf(resultSet.getString("cpf"));
                p.setEmail(resultSet.getString("email"));
                p.setNome(resultSet.getString("nome"));
                p.setSenha(resultSet.getString("senha"));
                stmt.close();
                return p;
            } else {
                stmt.close();
                return null;
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Update
    public void atualiza(@NotNull Pessoa p) {
        String sql = "UPDATE pessoa SET cpf = ?, email = ?, nome = ?, senha = ? WHERE idP = ?";
        try { PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, p.getCpf());
            stmt.setString(2, p.getEmail());
            stmt.setString(3, p.getNome());
            stmt.setString(4, p.getSenha());
            stmt.setInt(5, p.getIdP());
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Pessoa atualizada com sucesso!");
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Delete
    public void exclui(int idP) {
        String sql = "DELETE FROM pessoa WHERE idP = ?";
        try { PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idP);
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Pessoa excluída com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 💣 Nuke 💣
    public void limparTabela() {
        String sql = "DELETE FROM pessoa";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Tabela Pessoa limpa com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Gera ID automaticamente
    public int gerarId() {
        String sql = "SELECT MAX(idP) + 1 AS proximoId FROM pessoa";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("proximoId");
            } else {
                return 1;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}