public class Admin extends Pessoa{
    private int idAdm;
    public int getidAdm(){return idAdm;}
    public void setIdAdm(int idAdm){
        this.idAdm = idAdm;
    }
    @Override
    public String toString(){
        return super.toString() + "ID Administrador: " + idAdm + ", Tipo: ADMIN";
    }
}