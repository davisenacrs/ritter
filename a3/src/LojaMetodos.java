import java.util.List;
import java.util.Scanner;

public class LojaMetodos {
    private Scanner leitor = new Scanner(System.in);

    public void exibirMenuInicial() {

        System.out.println("\nMenu:");
        System.out.println("1 - Cadastrar-se");
        System.out.println("2 - Login");
        System.out.println("3 - Sair");
        System.out.print("Escolha uma opção: ");
        int opcao = leitor.nextInt();
        leitor.nextLine();

        ClienteMetodos cliente = new ClienteMetodos();

        switch (opcao) {
            case 1:
                cliente.cadastrarCliente();
                break;
            case 2:
                cliente.efetuarLogin();
                break;
            case 3:
                System.out.println("Poxa já vai? Esperamos por você outra hora...");
                break;
            default:
                System.out.println("Opção inválida!");
                exibirMenuInicial();
        }
    }

    public void iniciarLoja() {

        CamisetaMetodos metodos1 = new CamisetaMetodos();
        metodos1.catalogoCamisetas();
        List<Camiseta> catalogo = metodos1.getCatalogo();

        System.out.println("Catálogo de camisetas disponíveis:");

        for (int i = 0; i < catalogo.size(); i++) {
            Camiseta c = catalogo.get(i);
            System.out.printf("%d - %s | Preço: R$%.2f | Desconto: %.0f%% | Tamanho: %s%n", i + 1, c.getNome(), c.getPreco(), c.getDesconto() * 100, c.getTamanho());
        }

        System.out.println("\nEscolha uma opção abaixo: ");
        System.out.println("1 - Adicionar camiseta ao carrinho");
        System.out.println("2 - Visualizar carrinho");
        System.out.println("3 - Finalizar compra");
        System.out.println("4 - Sair");
        int opcao = leitor.nextInt();
        leitor.nextLine();

        PedidoMetodos metodos2 = new PedidoMetodos();

        switch (opcao) {
            case 1:
                metodos2.adicionarCamiseta();
                break;
            case 2:
                metodos2.vizualizarCarrinho();
                break;
            case 3:
                metodos2.finalizarCompra();
            case 4:
                System.out.println("Poxa já vai? Esperamos por você outra hora...");
                exibirMenuInicial();
            default:
                System.out.println("Opção inválida!");
                iniciarLoja();
        }
    }
}
