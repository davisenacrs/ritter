import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsuarioMetodos {

    private static List<Usuario> listaClientes = new ArrayList<>();
    public static Usuario usuarioLogado = null;
    Scanner leitor = new Scanner(System.in);
    CamisetaMetodos camisetaMetodos = new CamisetaMetodos();

    public static List<Usuario> getListaClientes() {
        return listaClientes;
    }

    public static void setListaClientes(List<Usuario> listaClientes) {
        UsuarioMetodos.listaClientes = listaClientes;
    }

    public UsuarioMetodos() {
        Usuario admin = new Usuario("Conta ADM", "31320696", "adm@loja.com", "adm321", "00000000000", "Sistema");
        listaClientes.add(admin);
    }

    public void cadastrarCliente() {
        System.out.println("Faça seu cadastro completando os dados abaixo: \n");

        System.out.print("Nome completo: ");
        String nome = leitor.nextLine();

        System.out.print("Telefone: ");
        String telefone = leitor.nextLine();

        System.out.print("E-mail: ");
        String email = leitor.nextLine();

        System.out.print("Senha: ");
        String senha = leitor.nextLine();

        System.out.print("CPF ou CNPJ: ");
        String cpfCnpj = leitor.nextLine();

        System.out.print("Endereço para entrega: ");
        String endereco = leitor.nextLine();

        Usuario novoCliente = new Usuario(nome, telefone, email, senha, cpfCnpj, endereco);
        listaClientes.add(novoCliente);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Cadastro realizado com sucesso!");
    }

    public void efetuarLogin() {
        System.out.print("Digite seu e-mail: ");
        String emailLogin = leitor.nextLine();

        System.out.print("Digite sua senha: ");
        String senhaLogin = leitor.nextLine();

        for (Usuario cliente : listaClientes) {
            if (senhaLogin.equals(cliente.getSenha()) && emailLogin.equals(cliente.getEmail())) {
                usuarioLogado = cliente;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                if (emailLogin.equals("adm@loja.com")) {
                    System.out.println("Login como Admin realizado com sucesso!");
                    exibirMenuAdmin();
                } else {
                    System.out.println("\nBem-vindo ao nosso site de camisetas personalizadas, " + cliente.getNome() + "! \n");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                return;
            }
        }

        System.out.println("Email ou senha incorretos. Tente novamente.");
    }

    public void exibirMenuAdmin() {
        boolean sair = false;
        while (!sair) {
            System.out.println("\nMenu Admin");
            System.out.println("1. Visualizar catálogo");
            System.out.println("2. Adicionar camiseta");
            System.out.println("3. Remover camiseta");
            System.out.println("4. Editar camiseta");
            System.out.println("5. Visualizar camisetas mais vendidas");
            System.out.println("6. Sair");
            System.out.print("Escolha: ");
            int opcao = leitor.nextInt();
            leitor.nextLine();

            switch (opcao) {
                case 1:
                    List<Camiseta> catalogo = camisetaMetodos.getCatalogo();

                    System.out.println("Catálogo de camisetas disponíveis:");

                    for (Camiseta camiseta : catalogo) {
                        System.out.printf("%d - Nome: %s | Preço: R$%.2f | Desconto: %.0f%%\n",
                                camiseta.getId(), camiseta.getNome(), camiseta.getPreco(), camiseta.getDesconto() * 100);
                    }
                    break;
                case 2:
                    camisetaMetodos.adicionarCamiseta();
                    break;
                case 3:
                    camisetaMetodos.removerCamiseta();
                    break;
                case 4:
                    camisetaMetodos.editarCamiseta();
                    break;
                case 5:
                    System.out.println("Visualizando mais vendidas (adição futura ao projeto).");
                    break;
                case 6:
                    sair = true;
                    usuarioLogado = null;
                    System.out.println("Logout realizado.");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public void editarPerfil() {
        System.out.print("Novo nome: ");
        String nome = leitor.nextLine();

        System.out.print("Novo telefone: ");
        String telefone = leitor.nextLine();

        System.out.print("Novo endereço: ");
        String endereco = leitor.nextLine();

        usuarioLogado.setNome(nome);
        usuarioLogado.setTelefone(telefone);
        usuarioLogado.setEndereco(endereco);

        System.out.println("Perfil atualizado com sucesso!\n");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
