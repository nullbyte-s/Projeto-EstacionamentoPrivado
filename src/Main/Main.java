package src.Main;

import src.Entities.*;
import src.Entities.User.*;
import src.Utils.CadastroUsuario;
import src.Utils.CadastroVeiculo;

import java.util.Scanner;
public class Main {

    public static Scanner sc;

    public static void main(String[] args) {
        int repetir = 0;

        sc = new Scanner(System.in);

        do {
            System.out.println("\n---------- Bem-vindo(a) ao Estacionamento ----------\n\nPrimeiro acesso? (1) Sim | (2) Não -> ");
            int primeiroAcesso = sc.nextInt();
            int idLogin = 0;

            if (primeiroAcesso == 1) {
                System.out.println();
                System.out.println("Vamos realizar seu cadastro.");
                System.out.println();

                Usuario usuario = CadastroUsuario.cadastrarUsuario();

                if (usuario != null) {
                    System.out.println("Cadastro finalizado: " + usuario);
                } else {
                    System.out.println("Usuário não encontrado.");
                }

                System.out.println("\nAtualizar os dados do usuário recém-cadastrado? (1) Sim | (2) Não -> ");
                int opcaoAtualizar = sc.nextInt();

                if (opcaoAtualizar == 1) {
                    Usuario usuarioAtualizado = Usuario.criarUsuario();
                    usuarioAtualizado.setIdUser(usuario.getIdUser());
                    CadastroUsuario.atualiza(usuarioAtualizado);
                }

                System.out.println("Efetue o login para continuar.");
                continue;

            } else if (primeiroAcesso == 2) {

                System.out.println("Digite o seu idUser: ");
                idLogin=sc.nextInt();
                System.out.println("Digite a sua senha: ");
                String senhaLogin = sc.next();

                Usuario usuario = CadastroUsuario.buscarPorId(idLogin);

                if (usuario != null) {
                    int userLevel = usuario.getUserLevel();
                    System.out.println("O userLevel do usuário encontrado é: " + userLevel);
                    break;
                } else {
                    System.out.println("Usuário não encontrado.");
                }

                if (usuario != null && usuario.getSenha().equals(senhaLogin)){
                    String tipo = "Usuário Comum";

                    int userLevel = usuario.getUserLevel();
                    switch (userLevel) {
                        case 0:
                            break;
                        case 1:
                            tipo = "Usuário PREMIUM";
                            UsuarioPremium usuarioPremium = new UsuarioPremium(userLevel);
                            break;
                        case 2:
                            tipo = "FUNCIONARIO";
//                            Funcionario funcionario = new Funcionario(userLevel);
                            break;
                        case 3:
                            tipo = "ADMIN";
                            Admin admin = new Admin(userLevel);
                            break;
                        default:
                            System.out.println("Tipo de usuário desconhecido.");
                    }

                    System.out.printf("Login como %s realizado com sucesso! %n", tipo);

                    System.out.println("\nPor favor, escolha uma das opções a seguir.\n");
                    System.out.println("Cadastrar: (1) Veículo\nListar: (2) Pessoas | (3) Veículos\nVerificar: (4) Placa do Veículo\nConta: (5) Logout\n");
                    int escolha = sc.nextInt();
                    switch (escolha) {
                        case 1:
                            Carro carro = new Carro(idLogin);
                            CadastroVeiculo.cadastrarVeiculo(carro);
                            break;
                        case 2:
                            CadastroUsuario.listarPessoas();
                            break;
                        case 3:
                            CadastroVeiculo.listarVeiculos();
                            break;
                        case 4:
                            System.out.println("Informe a placa do carro: ");
                            String placaVerificar = sc.next();

                            if (CadastroVeiculo.verificarPlaca(placaVerificar))
                                System.out.println("O carro com a placa " + placaVerificar + " está cadastrado.");
                            else
                                System.out.println("O carro com a placa " + placaVerificar + " não está cadastrado.");
                            break;
                        case 5:
                            break;
                        default:
                            System.out.println("Opção inválida.");
                    }
                } else {
                    System.out.println("Senha incorreta. Tente novamente.");
                    System.out.flush();
                    continue;
                }
            } else {
                System.out.println("Usuário não encontrado.");
                System.out.flush();
                continue;
            }
            System.out.println("Para ver novamente, digite 0");
            repetir = sc.nextInt();
        } while (repetir==0);
    }
}