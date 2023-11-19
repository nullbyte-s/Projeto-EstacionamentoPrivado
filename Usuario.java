public class Usuario {
    private int idUser, userLevel;
    private String cpf, nome, email, senha;
    public int getidUser() {
        return idUser;
    }
    public void setidUser(int idUser) {
        this.idUser = idUser;
    }
    public int getUserLevel() { return userLevel; }
    public void setUserLevel(int userLevel) { this.userLevel = userLevel; }
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
        return new StringBuilder().append("ID: ").append(idUser).append(", Nível: ").append(userLevel).append(", CPF: ").append(cpf).append(", Nome: ").append(nome).append(", Email: ").append(email).append(", Senha: ").append(senha).toString();
    }
}