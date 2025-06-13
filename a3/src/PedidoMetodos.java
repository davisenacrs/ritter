import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PedidoMetodos {

    Scanner leitor = new Scanner(System.in);
    List<Camiseta> carrinho = new ArrayList<>();
    //arrays acima

    CamisetaMetodos camisetaMetodos = new CamisetaMetodos();
    //delcaração do objeto acima

    public void adicionarAoCarrinho(){
        List<Camiseta> catalogo = camisetaMetodos.getCatalogo();

        System.out.println("Catálogo de camisetas disponíveis:");

        for (Camiseta camiseta : catalogo) {
            System.out.printf("%d - %s | Preço: R$%.2f | Desconto: %.0f%% | Tamanho: %s%n",
                    camiseta.getId(), camiseta.getNome(), camiseta.getPreco(), camiseta.getDesconto() * 100, camiseta.getTamanho());
        }
        System.out.println("Digite o numero da camiseta que você deseja adicionar ao carrinho: ");
        String entrada = leitor.nextLine();// recebe o que o usuario digitar
        int opcao; //variavel para guardar o que o usuario digitou mas em inteiro

        try {
            opcao = Integer.parseInt(entrada);
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido! Digite apenas números.");
            return;
        }

        Camiseta camisetaEscolhida = null; //criei variavel camisetaescolhida do tipo camiseta e declarei como nula
        for (Camiseta camiseta : catalogo) {
            if (camiseta.getId() == opcao) {
                camisetaEscolhida = camiseta; //camiseta escolohida é o num id que o usuario digitou que agora aponta para o lugar do vetor no qual aquela camiseta está
                break;
            }
        }

        if (camisetaEscolhida != null) {
            carrinho.add(camisetaEscolhida);
            System.out.println("Camiseta adicionada ao carrinho!");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("ID de camiseta inválido! Tente novamente.");
        }
    }

    public void vizualizarCarrinho() {
        if (carrinho.isEmpty()) {
            System.out.println("Carrinho vazio.\n");
            return;
        }
        System.out.println("=== Carrinho ===");
        for (Camiseta c : carrinho) {
            System.out.printf("Nome: %s | Tamanho: %s | Preço: R$ %.2f%n",
                    c.getNome(), c.getTamanho(), c.getPreco());
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void finalizarCompra (){
        System.out.printf("");
    }

    public void vizualizarHistorico(){
        System.out.printf("");
    }
}
