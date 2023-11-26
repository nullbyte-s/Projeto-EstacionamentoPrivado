package src.Entities;

import src.Entities.User.Usuario;
import src.Main.Main;

import java.util.ArrayList;
import java.util.List;

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

//    public Carro(int idUser) {
//        setIdUser(idUser);
//        System.out.println("Informe a Placa:");
//        setPlaca(sc.next());
//        System.out.println("Informe a Cor:");
//        setCor(sc.next());
//    }

    public static Carro cadastrarCarro(int idUser) {
        Carro carro = new Carro();
        carro.setIdUser(idUser);
        System.out.println("Informe a Placa:");
        carro.setPlaca(sc.next());
        System.out.println("Informe a Cor:");
        carro.setCor(sc.next());

        return carro;
    }
}