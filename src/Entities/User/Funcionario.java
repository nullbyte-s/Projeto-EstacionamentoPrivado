package src.Entities.User;

public class Funcionario extends Usuario {
    private int userLevel;

    public Funcionario(int userLevel) {
        this.userLevel = userLevel;
    }

    public int getUserLevelFunc() {
        return userLevel;
    }

    public void setUserLevelFunc(int userLevel) {
        this.userLevel = userLevel;
    }

    @Override
    public String toString() {
        return super.toString() + ", Nível de acesso: " + userLevel + ", Tipo: FUNCIONARIO";
    }
}
