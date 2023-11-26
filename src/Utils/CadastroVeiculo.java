package src.Utils;

import src.Entities.Carro;
import src.Entities.User.Admin;
import src.Entities.User.Funcionario;
import src.Entities.User.UsuarioPremium;

import java.util.ArrayList;
import java.util.List;

import static src.Utils.CadastroUsuario.gerarId;

public class CadastroVeiculo {

    private static List<Carro> carros = new ArrayList<>();
    static CadastroVeiculoDAO cadastroVeiculoDAO = new CadastroVeiculoDAO();

    public static void cadastrarVeiculo(Carro carro) {
        int proximoIdCar = gerarId();
        carro.cadastrarCarro(proximoIdCar);
        carros.add(carro);
        cadastroVeiculoDAO.adiciona(carro);
        System.out.println("Veículo cadastrado com sucesso!");
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