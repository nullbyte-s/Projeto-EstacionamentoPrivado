public class Pessoa {
    private int idP;
    private String cpf, nome, email, senha;
    public int getIdP() {
        return idP;
    }
    public void setIdP(int idP) {
        this.idP = idP;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    @Override
    public String toString() {
        return "ID: " + idP + ", CPF: " + cpf + ", Nome: " + nome + ", Email: " + email + ", Senha: " + senha;
    }
}