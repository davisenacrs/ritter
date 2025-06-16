import java.util.List;
import java.util.Scanner;

public class LojaMetodos {
    private Scanner leitor = new Scanner(System.in);
    CamisetaMetodos camisetaMetodos = new CamisetaMetodos();
    PedidoMetodos pedidoMetodos = new PedidoMetodos();
    UsuarioMetodos clienteMetodos = new UsuarioMetodos();

    public void exibirMenuCliente() {

        while (true){
        System.out.println("\nMenu:");
        System.out.println("1 - Cadastrar-se");
        System.out.println("2 - Login");
        System.out.println("3 - Sair");
        System.out.print("Escolha uma opção: ");
        int opcao = leitor.nextInt();
        leitor.nextLine();


        switch (opcao) {
            case 1:
                clienteMetodos.cadastrarCliente();
                break;
            case 2:
                clienteMetodos.efetuarLogin();
                if (clienteMetodos.usuarioLogado != null){
                    iniciarLoja();
                }
                break;
            case 3:
                System.out.println("Poxa já vai? Esperamos por você outra hora...");
                return;//para sair do propgrama
            default:
                System.out.println("Opção inválida!");
            }
        }
    }


    public void iniciarLoja() {
        while (true) {
            List<Camiseta> catalogo = camisetaMetodos.getCatalogo();

            System.out.println("Catálogo de camisetas disponíveis:");

            for (Camiseta camiseta : catalogo) {
                System.out.printf("%d - Nome: %s | Preço: R$%.2f | Desconto: %.0f%%\n",
                        camiseta.getId(), camiseta.getNome(), camiseta.getPreco(), camiseta.getDesconto() * 100);
            }

            System.out.println("\nEscolha uma opção abaixo: ");
            System.out.println("1 - Adicionar camiseta ao carrinho");
            System.out.println("2 - Visualizar carrinho");
            System.out.println("3 - Finalizar compra");
            System.out.println("4 - Ver histórico de compras");
            System.out.println("5 - Editar perfil");
            System.out.println("6 - Sair");
            int opcao = leitor.nextInt();
            leitor.nextLine();

            switch (opcao) {
                case 1:
                    pedidoMetodos.adicionarAoCarrinho();
                    break;
                case 2:
                    pedidoMetodos.vizualizarCarrinho();
                    break;
                case 3:
                    pedidoMetodos.finalizarCompra();
                    break;
                case 4:
                    pedidoMetodos.vizualizarHistorico();
                    break;
                case 5:
                    clienteMetodos.editarPerfil();
                    break;
                case 6:
                    System.out.println("Poxa já vai? Esperamos por você outra hora...");
                    clienteMetodos.usuarioLogado = null;
                    return;//faz voltar ao menu inicial
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}
