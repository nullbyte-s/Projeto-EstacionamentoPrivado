package src.Main;

import src.Entities.*;
import src.Entities.User.*;
import src.Utils.CadastroUsuario;
import src.Utils.CadastroVeiculo;
import src.Utils.FuncoesAdmin;
import src.Utils.FuncoesUsuario;

import java.util.Scanner;
public class Main {

    public static Scanner sc;
    private static int idLogin;

    public static void imprimirOpcoes(String tipo) {
        switch (tipo) {
            case "ADMIN":
                FuncoesAdmin funcoesAdmin = new FuncoesAdmin();
                funcoesAdmin.painelAdmin();
                break;

            case "FUNCIONARIO":
                System.out.println("\nCadastrar: (1) Veículo\nListar: (2) Pessoas | (3) Veículos\nVerificar: (4) Placa do Veículo\nConta: (5) Logout\n");
                break;

            case "usuario PREMIUM":
                System.out.println("\nCadastrar: (1) Veículo\nListar: (3) Veículos\nVerificar: (4) Placa do Veículo\nConta: (5) Logout\n");
                break;

            default:
                System.out.println("\nPainel do Usuário: (3)\nConta: (5) Logout\n");
                break;
        }
    }

    public static void main(String[] args) {
        int repetir = 0;

        sc = new Scanner(System.in);

        do {
            System.out.println("\n---------- Bem-vindo(a) ao Estacionamento ----------\n\nPrimeiro acesso? (1) Sim | (2) Não -> ");
            int primeiroAcesso = sc.nextInt();

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

                    System.out.printf("\nLogin como %s realizado com sucesso! %n", tipo,"\n");

                    imprimirOpcoes(tipo);
                    int escolha = sc.nextInt();
                    sc.nextLine();

                    switch (escolha) {
                        case 1:
                            if ("FUNCIONARIO".equals(tipo) || "usuario PREMIUM".equals(tipo)) {
                                // TODO: atribuir ações em comum a esses usuários
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
                        case 3:
                            if ("Usuario Comum".equals(tipo) || "usuario PREMIUM".equals(tipo)) {
                                FuncoesUsuario funcoesUsuario = new FuncoesUsuario();
                                funcoesUsuario.painelUsuario(idLogin);
                            } else {
                                System.out.println("Opção inválida para este tipo de usuário.");
                            }
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
            System.out.println("\nPara ver novamente, digite 0");
            repetir = sc.nextInt();
        } while (repetir==0);
    }
}