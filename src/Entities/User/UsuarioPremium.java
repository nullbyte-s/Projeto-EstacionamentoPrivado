package src.Entities.User;

public class UsuarioPremium extends Usuario {
    private int userLevel;

    public UsuarioPremium(int userLevel) {
        this.userLevel = userLevel;
    }

    public int getUserLevelUPre(){return userLevel;}
    public void setUserLevelUPre(int userLevel){this.userLevel = userLevel;}
    @Override
    public String toString() {
        return super.toString() + ", Nível de acesso: " + userLevel + ", Tipo: PREMIUM";
    }

}