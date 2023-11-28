package src.Utils;

import src.Entities.Carro;

import java.util.ArrayList;
import java.util.List;

public class CadastroVeiculo {

    private static List<Carro> carros = new ArrayList<>();
    static CadastroVeiculoDAO cadastroVeiculoDAO = new CadastroVeiculoDAO();

    public static int gerarIdCarro() {
        return cadastroVeiculoDAO.gerarIdCarro();
    }

    public static void cadastrarVeiculo(Carro carro) {
        int proximoIdCar = gerarIdCarro();
        carro.cadastrarCarro(proximoIdCar);
        carros.add(carro);
        cadastroVeiculoDAO.adicionaCarro(carro);
    }
    public static void listarVeiculos() {
        if (carros.isEmpty()) {
            System.out.println("Não há veículos cadastrados.");
        } else {
            System.out.println("Lista de veículos:");
            for (Carro carro : carros) {
                System.out.println(carro);
            }
        }
    }
    public static boolean verificarPlaca(String placa) {
        for (Carro carro : carros) {
            if (carro.getPlaca().equals(placa)) {
                return true;
            }
        }
        return false;
    }

}