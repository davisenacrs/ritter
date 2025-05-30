import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LojaMetodos {
    private List<Cliente> listaClientes = new ArrayList<>();
    private Scanner leitor = new Scanner(System.in);
    private List<Camiseta> catalogo = new ArrayList<>();


    public void exibirMenuInicial() {

        System.out.println("\nMenu:");
        System.out.println("1 - Cadastrar-se");
        System.out.println("2 - Login");
        System.out.println("3 - Sair");
        System.out.print("Escolha uma opção: ");
        int opcao = leitor.nextInt();
        leitor.nextLine();

        switch (opcao) {
            case 1:
                cadastrarCliente();
                break;
            case 2:
                efetuarLogin();
                break;
            case 3:
                System.out.println("Poxa já vai? Esperamos por você outra hora...");
                break;
            default:
                System.out.println("Opção inválida!");
                exibirMenuInicial();
        }
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

        Cliente novoCliente = new Cliente(nome, telefone, email,senha, cpfCnpj, endereco);
        listaClientes.add(novoCliente);
        System.out.println("Cadastro realizado com sucesso!");
        exibirMenuInicial();
    }

    public void efetuarLogin() {
        System.out.print("Digite seu e-mail: ");
        String emailLogin = leitor.nextLine();

        System.out.print("Digite sua senha: ");
        String senhaLogin = leitor.nextLine();

        boolean loginSucesso = false;

        for (Cliente cliente : listaClientes) {
            if (senhaLogin.equals(cliente.getSenha()) && emailLogin.equals(cliente.getEmail())) {
                System.out.println("Sejá bem-vindo o nosso site de camisetas personalisadas, " + cliente.getNome() + "! \n");
                loginSucesso = true;
                iniciarLoja();
                break;
            }
        }

        if (!loginSucesso) {
            System.out.println("Email ou senha incorretos. Tente novamente.");
            exibirMenuInicial();
        }
    }


    public void catalogoCamisetas() {
            catalogo.add(new Camiseta("Camiseta Yamal", 129.0, 0.10, "P"));
            catalogo.add(new Camiseta("Camiseta Messi", 129.0, 0.15, "M"));
            catalogo.add(new Camiseta("Camiseta CR7", 119.0, 0.05, "M"));
            catalogo.add(new Camiseta("Camiseta Neymar", 109.0, 0.20, "G"));
            catalogo.add(new Camiseta("Camiseta R9", 109.0, 0.10, "GG"));
            catalogo.add(new Camiseta("Camiseta R10", 109.0, 0.15, "G"));
            catalogo.add(new Camiseta("Camiseta Kaká", 89.0, 0.05, "P"));
            catalogo.add(new Camiseta("Camiseta Mbappé", 99.0, 0.20, "M"));
    }

    public void iniciarLoja() {
        catalogoCamisetas();

        System.out.println("Catálogo de camisetas disponíveis:");

        for (int i = 0; i < catalogo.size(); i++) {
            Camiseta c = catalogo.get(i);
            System.out.printf("%d - %s | Preço: R$%.2f | Desconto: %.0f%% | Tamanho: %s%n",
                    i + 1, c.getNome(), c.getPreco(), c.getDesconto() * 100, c.getTamanho());
        }

        System.out.println("\nEscolha uma opção abaixo: ");
        System.out.println("1 - Adicionar camiseta ao carrinho");
        System.out.println("2 - Visualizar carrinho");
        System.out.println("3 - Finalizar compra");
        System.out.println("4 - Sair");
    }
}
