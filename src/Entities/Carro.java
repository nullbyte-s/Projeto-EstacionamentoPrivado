package src.Entities;

import static src.Main.Main.sc;

public class Carro {
    private int idCar;
    private int idUser;
    private String placa;
    private String cor;

    public int getIdCar() {
        return idCar;
    }
    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }

    public int getIdUser() { return idUser; }

    public void setIdUser(int idUser) { this.idUser = idUser; }

    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }

    public Carro(int idUser) {
        setIdUser(idUser);
        System.out.println("Informe a Placa:");
        setPlaca(sc.next());
        System.out.println("Informe a Cor:");
        setCor(sc.next());
    }


}