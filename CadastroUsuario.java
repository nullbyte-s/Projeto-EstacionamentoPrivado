import java.util.ArrayList;
public class CadastroUsuario {
    CadastroUsuarioDAO cadastroUsuarioDAO = new CadastroUsuarioDAO();
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    public void cadastrarUsuario(Usuario p) {
        usuarios.add(p);
        cadastroUsuarioDAO.adiciona(p);
    }
    public void listarPessoas() {
        ArrayList<Usuario> usuarios = cadastroUsuarioDAO.listar();
        if (usuarios.isEmpty()) {
            System.out.println("Não há pessoas cadastradas.");
        } else {
            System.out.println("Lista de pessoas:");
            for (Usuario usuario : usuarios) {
                System.out.println(usuario);
            }
        }
    }
    public ArrayList<Usuario> getPessoas() {
        return usuarios;
    }

    public Usuario buscarPorId(int idUser) {
        return cadastroUsuarioDAO.buscarPorId(idUser);
    }

    public void atualiza(Usuario usuarioAtualizada) {
        cadastroUsuarioDAO.atualiza(usuarioAtualizada);
    }

    public void exclui(int idUserExcluir) {
        cadastroUsuarioDAO.exclui(idUserExcluir);
    }

    public void limparTabela() {
        cadastroUsuarioDAO.limparTabela();
    }

    public int gerarId() {
        return cadastroUsuarioDAO.gerarId();
    }
}