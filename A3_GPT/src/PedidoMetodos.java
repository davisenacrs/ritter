import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PedidoMetodos {
    private static List<Pedido> historicoPedidos = new ArrayList<>();

    public static void calcularTotais(Pedido pedido) {
        List<Camiseta> itens = pedido.getItens();
        if (itens == null || itens.isEmpty()) {
            pedido.setQuantidade(0);
            pedido.setValorTotal(0.0);
            return;
        }

        double total = 0;
        for (Camiseta camiseta : itens) {
            double precoComDesconto = camiseta.getPreco() * (1 - camiseta.getDesconto());
            total += precoComDesconto;
        }
        pedido.setQuantidade(itens.size());
        pedido.setValorTotal(total);
    }

    public static void finalizarCompra(Pedido pedido) throws InterruptedException {
        calcularTotais(pedido);
        System.out.println("\nFinalizando compra para cliente: " + pedido.getCliente().getNome());
        System.out.println("Valor total: R$ " + String.format("%.2f", pedido.getValorTotal()));
        if (pedido.getPagamento() != null) {
            System.out.println("Forma de pagamento: " + pedido.getPagamento().getTipo());
            if (pedido.getPagamento() instanceof Boleto) {
                Boleto boleto = (Boleto) pedido.getPagamento();
                System.out.println("Data de vencimento do boleto: " + boleto.getDataVencimento());
                boleto.processarPagamento();
            } else if (pedido.getPagamento() instanceof CartaoCredito) {
                CartaoCredito cartao = (CartaoCredito) pedido.getPagamento();
                cartao.processarPagamento(pedido.getValorTotal());
            }
        }
        // Atualizar estoque - incrementar quantidade vendida das camisetas
        for (Camiseta c : pedido.getItens()) {
            c.setQuantidadeVendida(c.getQuantidadeVendida() + 1);
        }
        pedido.setStatus("Saiu para entrega");
        historicoPedidos.add(pedido);
        System.out.println("Pedido finalizado e saiu para entrega. Prazo estimado: 5 dias.");
    }

    public static void verHistoricoCompras(Cliente cliente) {
        System.out.println("\n=== Histórico de compras do cliente: " + cliente.getNome() + " ===");
        boolean encontrou = false;
        for (Pedido p : historicoPedidos) {
            if (p.getCliente().equals(cliente)) {
                encontrou = true;
                System.out.println("Pedido - Status: " + p.getStatus() + " | Valor: R$ " + String.format("%.2f", p.getValorTotal()));
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum pedido encontrado.");
        }
    }

    public static void editarPerfil(Cliente cliente, String nome, String email, String telefone, String endereco) {
        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setTelefone(telefone);
        cliente.setEndereco(endereco);
        System.out.println("Perfil atualizado com sucesso!");
    }

    public static void visualizarStatusEntrega(Pedido pedido) {
        System.out.println("Status do pedido: " + pedido.getStatus());
        if ("Saiu para entrega".equalsIgnoreCase(pedido.getStatus())) {
            System.out.println("Prazo para entrega: 5 dias úteis");
        }
    }

    public static List<Pedido> getHistoricoPedidos() {
        return historicoPedidos;
    }
}