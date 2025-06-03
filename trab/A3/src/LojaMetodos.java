import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class LojaMetodos {
    private List<Cliente> listaClientes = new ArrayList<>();
    private Scanner leitor = new Scanner(System.in);
    private List<Camiseta> catalogo = new ArrayList<>();
    private Carrinho carrinho = new Carrinho();
    private Cliente clienteLogado = null;

    public void exibirMenuInicial() {
        System.out.println("\n=== LOJA DE CAMISETAS ===");
        System.out.println("1 - Cadastrar-se");
        System.out.println("2 - Login");
        System.out.println("3 - Sair");
        System.out.print("Escolha: ");

        int opcao = leitor.nextInt();
        leitor.nextLine();

        switch (opcao) {
            case 1: cadastrarCliente(); break;
            case 2: efetuarLogin(); break;
            case 3: System.out.println("Até logo!"); break;
            default:
                System.out.println("Opção inválida!");
                exibirMenuInicial();
        }
    }

    public void cadastrarCliente() {
        System.out.println("\n=== CADASTRO ===");
        System.out.print("Nome: ");
        String nome = leitor.nextLine();
        System.out.print("Telefone: ");
        String telefone = leitor.nextLine();
        System.out.print("E-mail: ");
        String email = leitor.nextLine();
        System.out.print("Senha: ");
        String senha = leitor.nextLine();
        System.out.print("CPF/CNPJ: ");
        String cpfCnpj = leitor.nextLine();
        System.out.print("Endereço: ");
        String endereco = leitor.nextLine();

        Cliente novoCliente = new Cliente(nome, telefone, email, senha, cpfCnpj, endereco);
        listaClientes.add(novoCliente);
        System.out.println("Cadastro realizado!");
        exibirMenuInicial();
    }

    public void efetuarLogin() {
        System.out.println("\n=== LOGIN ===");
        System.out.print("E-mail: ");
        String email = leitor.nextLine();
        System.out.print("Senha: ");
        String senha = leitor.nextLine();

        for (Cliente cliente : listaClientes) {
            if (cliente.verificaLogin(email, senha)) {
                System.out.println("Bem-vindo, " + cliente.getNome() + "!");
                clienteLogado = cliente;
                iniciarLoja();
                return;
            }
        }

        System.out.println("Login inválido!");
        exibirMenuInicial();
    }

    public void catalogoCamisetas() {
        catalogo.clear();
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
        boolean continuar = true;

        while (continuar) {
            Camiseta.mostrarCatalogo(catalogo);

            System.out.println("\n1 - Adicionar ao carrinho");
            System.out.println("2 - Ver carrinho");
            System.out.println("3 - Finalizar compra");
            System.out.println("4 - Sair");
            System.out.print("Opção: ");

            int opcao = leitor.nextInt();
            leitor.nextLine();

            switch (opcao) {
                case 1: adicionarCamiseta(); break;
                case 2: carrinho.mostrarItens(); break;
                case 3:
                    if (carrinho.getItens().isEmpty()) {
                        System.out.println("Carrinho vazio!");
                    } else {
                        finalizarCompra();
                        continuar = false;
                    }
                    break;
                case 4:
                    System.out.println("Obrigado!");
                    continuar = false;
                    break;
                default: System.out.println("Opção inválida!");
            }
        }
    }

    private void adicionarCamiseta() {
        System.out.print("Escolha a camiseta (número): ");
        int escolha = leitor.nextInt();
        leitor.nextLine();

        if (escolha < 1 || escolha > catalogo.size()) {
            System.out.println("Escolha inválida!");
            return;
        }

        System.out.print("Quantidade: ");
        int qtd = leitor.nextInt();
        leitor.nextLine();

        if (qtd <= 0) {
            System.out.println("Quantidade inválida!");
            return;
        }

        Camiseta camiseta = catalogo.get(escolha - 1);
        carrinho.adicionarItem(camiseta, qtd);
        System.out.println("Adicionado ao carrinho!");
    }

    private void finalizarCompra() {
        System.out.println("\n=== FINALIZAR COMPRA ===");

        Pedido pedido = new Pedido(clienteLogado, carrinho.getItens());
        double total = pedido.calcularTotal();

        System.out.println("Total: R$ " + String.format("%.2f", total));
        System.out.println("1 - Boleto");
        System.out.println("2 - Cartão");
        System.out.print("Forma de pagamento: ");

        int opcao = leitor.nextInt();
        leitor.nextLine();

        if (opcao == 1) {
            Boleto boleto = new Boleto("30/12/2024", "");
            pedido.setPagamento(boleto);
            // Chama o processamento automático do boleto
            boleto.processarPagamento();
        } else if (opcao == 2) {
            System.out.print("Número de parcelas: ");
            int parcelas = leitor.nextInt();
            leitor.nextLine();

            CartaoCredito cartao = new CartaoCredito(parcelas);
            pedido.setPagamento(cartao);
            cartao.calculaParcelas(total);
        } else {
            System.out.println("Opção de pagamento inválida!");
            return;
        }

        // Mostra o resumo final do pedido
        pedido.mostrarResumoPedido();
        System.out.println("Compra finalizada com sucesso!");
        carrinho.limpar();
    }
}