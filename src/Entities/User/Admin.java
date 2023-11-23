package src.Entities.User;

public class Admin extends Usuario {
    private int userLevel;

    public Admin(int userLevel) {
        this.userLevel = userLevel;
    }

    public int getUserLevelAdm(){return userLevel;}
    public void setUserLevelAdm(int userLevel){
        this.userLevel = userLevel;
    }
    @Override
    public String toString(){
        return super.toString() + ", Nível de acesso: " + userLevel + ", Tipo: ADMIN";
    }
}