import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PedidoMetodos {

    Scanner leitor = new Scanner(System.in);
    List<Camiseta> carrinho = new ArrayList<>();
    List<Pedido> historico = new ArrayList<>();
    //arrays acima

    CamisetaMetodos camisetaMetodos = new CamisetaMetodos();
    //delcaração do objeto acima

    public void adicionarAoCarrinho() {
        List<Camiseta> catalogo = camisetaMetodos.getCatalogo();

        System.out.println("Catálogo de camisetas disponíveis:");

        for (Camiseta camiseta : catalogo) {
            System.out.printf("%d - %s | Preço: R$%.2f | Desconto: %.0f%%%n",
                    camiseta.getId(), camiseta.getNome(), camiseta.getPreco(), camiseta.getDesconto() * 100);
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
            System.out.print("Digite o tamanho desejado (P/M/G/GG): ");
            String tamanho = leitor.nextLine().toUpperCase();

            Camiseta camisetaPersonalizada = new Camiseta( //cria uma camiseta igual a camiseta escolhida e adiciona o finan o tamanho referente a essa camiseta
                    camisetaEscolhida.getId(),
                    camisetaEscolhida.getNome(),
                    camisetaEscolhida.getPreco(),
                    camisetaEscolhida.getDesconto()
            );
            camisetaPersonalizada.setTamanho(tamanho);

            carrinho.add(camisetaPersonalizada);

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
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return;
        }
        System.out.println("\nCarrinho atual:");
        for (Camiseta camiseta : carrinho) {
            double precoFinal = camiseta.getPreco() * (1 - camiseta.getDesconto());
            System.out.printf("Nome: %s | Tamanho: %s | Preço com desconto: R$ %.2f%n",
                    camiseta.getNome(), camiseta.getTamanho(), precoFinal);
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void finalizarCompra() { //adicionar não poder finalizar se carinho vazio
        System.out.println("\nCarrinho atual:");
        for (Camiseta camiseta : carrinho) {
            double precoFinal = camiseta.getPreco() * (1 - camiseta.getDesconto());
            System.out.printf("Nome: %s | Tamanho: %s | Preço com desconto: R$ %.2f%n",
                    camiseta.getNome(), camiseta.getTamanho(), precoFinal);
        }

        double valorTotal = 0;
        double descontoTotal = 0;
        for (Camiseta camiseta : carrinho) {
            valorTotal += camiseta.getPreco() * (1 - camiseta.getDesconto());
            descontoTotal += camiseta.getPreco() * camiseta.getDesconto();
        }
        System.out.printf("Total de descontos aplicados: R$ %.2f\n", descontoTotal);
        System.out.printf("Valor total do pedido: R$ %.2f\n", valorTotal);

        System.out.println("Endereço de entrega cadastrado: " + UsuarioMetodos.usuarioLogado.getEndereco());
        System.out.print("Digite 1 para confirmar esse endereço ou 2 para informar um novo: ");
        String opcaoEndereco = leitor.nextLine();

        String enderecoEntrega;
        if (opcaoEndereco.equals("1")) {
            enderecoEntrega = UsuarioMetodos.usuarioLogado.getEndereco();
        } else {
            System.out.print("Digite o novo endereço de entrega: ");
            enderecoEntrega = leitor.nextLine();
        }

        Pagamento pagamento;
        while (true) {
            System.out.println("Escolha o tipo de pagamento:");
            System.out.println("1 - Cartão de Crédito");
            System.out.println("2 - Boleto");
            String opcao = leitor.nextLine();

            if (opcao.equals("1")) {
                System.out.print("Quantas parcelas? ");
                int parcelas = Integer.parseInt(leitor.nextLine());
                pagamento = new CartaoCredito(parcelas);
                ((CartaoCredito) pagamento).calculaParcelas(valorTotal);
                break;
            } else if (opcao.equals("2")) {
                String dataVencimento = "17/07/2025";
                String dataPagamento = "0";
                pagamento = new Boleto(dataVencimento, dataPagamento);
                System.out.println("Gerando boleto...");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Boleto gerado! Vencimento em: " + dataVencimento + "\n"); // adicionar mostrar valor total boleto
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                pagamento.setStatus("Pendente");
                break;
            } else {
                System.out.println("Opção inválida. Digite 1 para Cartão ou 2 para Boleto.");
            }
        }

        Pedido novoPedido = new Pedido(new ArrayList<>(carrinho), // copia do carrinho
                valorTotal,
                enderecoEntrega,
                pagamento,
                pagamento.getStatus()
        );
        historico.add(novoPedido);

        carrinho.clear();

        System.out.println("Compra finalizada!\n");
    }

    public void vizualizarHistorico() {
        if (historico.isEmpty()) {
            System.out.println("Você ainda não tem compras no histórico.");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return;
        }

        System.out.println("\nHistórico de Compras:");
        int i = 1;
        for (Pedido pedido : historico) {
            System.out.printf("Pedido %d | Status: %s | Total: R$ %.2f\n", i++, pedido.getStatus(), pedido.calcularTotal());
            System.out.println("Endereço: " + pedido.getEnderecoEntrega());
            System.out.println("Pagamento: " + pedido.getPagamento().getTipo());
            for (Camiseta camiseta : pedido.getCamisetasCompradas()) {
                double precoFinal = camiseta.getPreco() * (1 - camiseta.getDesconto());
                System.out.printf("  - %s | Tamanho: %s | Preço com desconto: R$ %.2f",
                        camiseta.getNome(), camiseta.getTamanho(), precoFinal, "\n");
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
