import java.util.ArrayList;
public class CadastroPessoa {
    CadastroPessoaDAO cadastroPessoaDAO = new CadastroPessoaDAO();
    private ArrayList<Pessoa> pessoas = new ArrayList<>();
    public void cadastrarPessoa(Pessoa p) {
        pessoas.add(p);
        cadastroPessoaDAO.adiciona(p);
    }
    public void listarPessoas() {
        ArrayList<Pessoa> pessoas = cadastroPessoaDAO.listar();
        if (pessoas.isEmpty()) {
            System.out.println("Não há pessoas cadastradas.");
        } else {
            System.out.println("Lista de pessoas:");
            for (Pessoa pessoa : pessoas) {
                System.out.println(pessoa);
            }
        }
    }
    public ArrayList<Pessoa> getPessoas() {
        return pessoas;
    }

    public Pessoa buscarPorId(int idP) {
        return cadastroPessoaDAO.buscarPorId(idP);
    }

    public void atualiza(Pessoa pessoaAtualizada) {
        cadastroPessoaDAO.atualiza(pessoaAtualizada);
    }

    public void exclui(int idPessoaExcluir) {
        cadastroPessoaDAO.exclui(idPessoaExcluir);
    }

    public void limparTabela() {
        cadastroPessoaDAO.limparTabela();
    }

    public int gerarId() {
        return cadastroPessoaDAO.gerarId();
    }
}