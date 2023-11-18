import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int repetir;
        Scanner sc = new Scanner(System.in);
        CadastroPessoa cp = new CadastroPessoa();
        CadastroVeiculo cv = new CadastroVeiculo();

        do {
            System.out.println("---------- Bem-vindo(a) ao Estacionamento ----------");
            System.out.println();
            System.out.println("Primeiro acesso? (1) Sim | (2) Não -> ");
            int primeiroAcesso = sc.nextInt();
            int proximoIdPessoa = 0;

            if (primeiroAcesso == 1) {
                System.out.println();
                System.out.println("Vamos realizar seu cadastro.");
                System.out.println();

                Pessoa pessoa = criarPessoa(sc);
                proximoIdPessoa = cp.gerarId();
                pessoa.setIdP(proximoIdPessoa);
                cp.cadastrarPessoa(pessoa);
                System.out.println();

                System.out.println("Qual tipo de usuário você deseja cadastrar?");
                System.out.println("(1) Usuário | (2) Funcionário | (3) Usuário Premium | (4) Administrador");
                System.out.println("-> ");
                int escolherUsuario = sc.nextInt();
                if (escolherUsuario == 1){
                    System.out.println("Você escolheu cadastrar Usuário.");
                } else if (escolherUsuario == 2){
                    Funcionario funcionario = new Funcionario();
                    System.out.println("Você escolheu cadastrar Funcionário.");
                    System.out.println("Informe o ID de Funcionário:");
                    funcionario.setIdFunc(Integer.parseInt(sc.next()));
                    funcionario.setIdP(proximoIdPessoa);
                } else if (escolherUsuario == 3){
                    PessoaPremium premium = new PessoaPremium();
                    System.out.println("Você escolheu cadastrar Usuário Premium.");
                    System.out.println("Informe o ID de Usuário Premium:");
                    premium.setIdPPre(Integer.parseInt(sc.next()));
                    premium.setIdP(proximoIdPessoa);
                } else if (escolherUsuario == 4){
                    Admin admin = new Admin();
                    System.out.println("Você escolheu cadastrar Administrador.");
                    System.out.println("Informe o ID de Administrador:");
                    admin.setIdAdm(Integer.parseInt(sc.next()));
                    admin.setIdP(proximoIdPessoa);
                } else {
                    System.out.println("Opção inválida.");
                }

                System.out.println();
                Pessoa pessoaCadastrada = cp.buscarPorId(pessoa.getIdP());

                if (pessoaCadastrada != null) {
                    System.out.println("Cadastro finalizado: " + pessoaCadastrada);
                } else {
                    System.out.println("Pessoa não encontrada.");
                }

                System.out.println();
                cp.listarPessoas();
                System.out.println();

                System.out.println("Atualizar os dados da pessoa recém-cadastrada? (1) Sim | (2) Não -> ");
                int opcaoAtualizar = sc.nextInt();

                if (opcaoAtualizar == 1) {
                    Pessoa pessoaAtualizada = criarPessoa(sc);
                    pessoaAtualizada.setIdP(pessoaCadastrada.getIdP());
                    cp.atualiza(pessoaAtualizada);
                } else {
                    System.out.println("Tudo bem! Seguindo...");
                }

                System.out.println();

                System.out.println("Deletar uma pessoa? (1) Sim / (2) Não -> ");
                int opcaoExcluir = sc.nextInt();

                if (opcaoExcluir == 1) {
                    System.out.println("Informe o ID da pessoa que deseja excluir:");
                    int idPessoaExcluir = sc.nextInt();
                    cp.exclui(idPessoaExcluir);
                } else {
                    System.out.println("Tudo bem! Seguindo...");
                }

                System.out.println("Deseja limpar toda a tabela Pessoa? (1) Sim / (2) Não -> ");
                int opcaoLimparTabela = sc.nextInt();

                if (opcaoLimparTabela == 1) {
                    cp.limparTabela();
                } else {
                    System.out.println("Tudo bem! Seguindo...");
                }

            } else if (primeiroAcesso == 2) {
                System.out.println("Informe seu CPF para realizar o login:");
                String cpfLogin = sc.next();
                if (realizarLogin(cp, cpfLogin)) {
                    System.out.println("Login realizado com sucesso!");
                } else {
                    System.out.println("CPF não cadastrado. Por favor, cadastre-se.");
                }
                System.out.println("Por favor, escolha uma das opções a seguir.");

                // Apenas o Administrador e o Funcionário terá acesso completo a todos os recursos.
                // Depois, editaremos as telas para cada situação.
                System.out.println("Cadastrar: (1) Pessoa / (2) Veículo");
                System.out.println("Listar: (3) Pessoas / (4) Veículos");
                System.out.println("Verificar: (5) Placa do Veículo");
                System.out.println("-> ");
                int escolha = sc.nextInt();
                switch (escolha) {
                    case 1:
                        // Obsoleto: será modificado para aproveitar implementação supra.
//                        System.out.println("Qual tipo de usuário você deseja cadastrar?");
//                        System.out.println("Cadastrar: (1) Administrador / (2) Funcionário / (3) Pessoa Premium");
//                        System.out.println("-> ");
//                        int escolherUsuario = sc.nextInt();
//                        if (escolherUsuario == 1) {
//                            Admin admin = new Admin();
//                            System.out.println("Você escolheu cadastrar Administrador.");
//                            System.out.println("Informe o ID de Administrador:");
//                            admin.setIdAdm(Integer.parseInt(sc.next()));
//                            System.out.println();
//                            Pessoa pessoa = criarPessoa(sc);
//                            cp.cadastrarPessoa(pessoa);
//                        } else if (escolherUsuario == 2){
//                            PessoaPremium premium = new PessoaPremium();
//                            System.out.println("Você escolheu cadastrar Funcionário.");
//                            System.out.println("Informe o ID de Funcionário:");
//                            premium.setIdPPre(Integer.parseInt(sc.next()));
//                            System.out.println();
//                            Pessoa pessoa = criarPessoa(sc);
//                            cp.cadastrarPessoa(pessoa);
//                        } else if (escolherUsuario == 3){
//                            System.out.println("Você escolheu cadastrar Pessoa Premium.");
//                            System.out.println();
//                            Pessoa pessoa = criarPessoa(sc);
//                            cp.cadastrarPessoa(pessoa);
//                        } else {
//                            System.out.println("Opção inválida.");
//                        }
                        break;
                    case 2:
                        Carro carro = criarCarro(sc);
                        cv.cadastrarVeiculo(carro);
                        break;
                    case 3:
                        cp.listarPessoas();
                        break;
                    case 4:
                        cv.listarVeiculos();
                        break;
                    case 5:
                        System.out.println("Informe a placa do carro: ");
                        String placaVerificar = sc.next();
                        verificarPlaca(cv, placaVerificar);
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } else {
                System.out.println("Opção inválida.");
            }
            System.out.println("Para ver novamente, digite 0");
            repetir = sc.nextInt();
        } while (repetir==0);
    }
    public static boolean realizarLogin(CadastroPessoa cp, String cpfLogin) {
        for (Pessoa pessoa : cp.getPessoas()) {
            if (pessoa.getCpf().equals(cpfLogin)) {
                return true;
            }
        }
        return false;
    }
    public static void verificarPlaca(CadastroVeiculo cv, String placaVerificar) {
        boolean carroCadastrado = cv.verificarCarroCadastrado(placaVerificar);
        if (carroCadastrado) {
            System.out.println("O carro com a placa " + placaVerificar + " está cadastrado.");
        } else {
            System.out.println("O carro com a placa " + placaVerificar + " não está cadastrado.");
        }
    }
    public static Pessoa criarPessoa(Scanner sc) {
        Pessoa pessoa = new Pessoa();
        System.out.println("Informe o CPF:");
        pessoa.setCpf(sc.next());
        System.out.println("Informe o nome:");
        pessoa.setNome(sc.next());
        System.out.println("Informe o e-mail:");
        pessoa.setEmail(sc.next());
        System.out.println("Informe a senha:");
        pessoa.setSenha(sc.next());
        return pessoa;
    }
    public static Carro criarCarro(Scanner sc) {
        Carro carro = new Carro();
        System.out.println("Informe a Placa:");
        carro.setPlaca(sc.next());
        System.out.println("Informe a Cor:");
        carro.setCor(sc.next());
        return carro;
    }
}