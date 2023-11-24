package src.Main;

import src.Entities.*;
import src.Entities.User.*;
import src.Utils.CadastroUsuario;
import src.Utils.CadastroVeiculo;

import java.util.Scanner;
public class Main {

    public static Scanner sc;

    public static void imprimirOpcoes(String tipo) {
        switch (tipo) {
            case "ADMIN":
                System.out.println("Cadastrar: (1) Veículo\nListar: (2) Pessoas | (3) Veículos\nVerificar: (4) Placa do Veículo\nConta: (5) Logout\n");
                break;

            case "FUNCIONARIO":
                System.out.println("Verificar: (4) Placa do Veículo\nConta: (5) Logout\n");
                break;

            case "usuario PREMIUM":
                System.out.println("Cadastrar: (1) Veículo\nConta: (5) Logout\n");
                break;

            default:
                System.out.println("Cadastrar: (1) Veículo\nConta: (5) Logout\n");
        }
    }

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

                if (usuario != null && usuario.getSenha().equals(senhaLogin)){

                    String tipo = "Usuario Comum";

                    switch (usuario) {
                        case Admin admin -> tipo = "ADMIN";
                        case Funcionario funcionario -> tipo = "FUNCIONARIO";
                        case UsuarioPremium usuarioPremium -> tipo = "usuario PREMIUM";
                        case null, default -> {
                        }
                    }

                    System.out.printf("Login como %s realizado com sucesso! %n", tipo);
                    System.out.println("\nPor favor, escolha uma das opções a seguir.\n");

                    imprimirOpcoes(tipo);
                    int escolha = sc.nextInt();

                    switch (escolha) {
                        case 1:
                            if ("ADMIN".equals(tipo) || "usuario PREMIUM".equals(tipo)) {
                                Carro carro = new Carro(idLogin);
                                CadastroVeiculo.cadastrarVeiculo(carro);
                            } else {
                                System.out.println("Opção inválida para este tipo de usuário.");
                            }
                            break;
                        case 2:
                            if ("ADMIN".equals(tipo) || "FUNCIONARIO".equals(tipo)) {
                                CadastroUsuario.listarPessoas();
                            } else {
                                System.out.println("Opção inválida para este tipo de usuário.");
                            }
                            break;
                        // TODO: Adicionar cases para outras ações
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
            System.out.println("\nPara ver novamente, digite 0");
            repetir = sc.nextInt();
        } while (repetir==0);
    }
}