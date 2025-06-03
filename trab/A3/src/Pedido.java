import java.util.Date;
import java.util.Map;

public class Pedido implements Calculavel {
    private Cliente cliente;
    private Map<Camiseta, Integer> itens;
    private Pagamento pagamento;
    private String enderecoEntrega;
    private Date dataPedido;

    public Pedido(Cliente cliente, Map<Camiseta, Integer> itens) {
        this.cliente = cliente;
        this.itens = itens;
        this.dataPedido = new Date();
        this.enderecoEntrega = cliente.getEndereco();
    }

    // Getters e Setters
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Map<Camiseta, Integer> getItens() {
        return itens;
    }

    public void setItens(Map<Camiseta, Integer> itens) {
        this.itens = itens;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(String endereco) {
        this.enderecoEntrega = endereco;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    // Implementação da interface Calculavel
    @Override
    public double calcularTotal() {
        double total = 0;
        for (Map.Entry<Camiseta, Integer> entry : itens.entrySet()) {
            Camiseta c = entry.getKey();
            int qtd = entry.getValue();
            double precoComDesconto = c.getPreco() * (1 - c.getDesconto());
            total += precoComDesconto * qtd;
        }
        return total;
    }

    @Override
    public double calcularDesconto() {
        double totalDesconto = 0;
        for (Map.Entry<Camiseta, Integer> entry : itens.entrySet()) {
            Camiseta c = entry.getKey();
            int qtd = entry.getValue();
            totalDesconto += (c.getPreco() * c.getDesconto()) * qtd;
        }
        return totalDesconto;
    }

    // Método para exibir resumo do pedido
    public void mostrarResumoPedido() {
        System.out.println("\n===== RESUMO DO PEDIDO =====");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Endereço: " + enderecoEntrega);
        System.out.println("Data: " + dataPedido);

        System.out.println("\nItens:");
        for (Map.Entry<Camiseta, Integer> entry : itens.entrySet()) {
            Camiseta c = entry.getKey();
            int qtd = entry.getValue();
            double precoComDesconto = c.getPreco() * (1 - c.getDesconto());
            double subtotal = precoComDesconto * qtd;

            System.out.printf("%s | Qtd: %d | Preço: R$ %.2f | Subtotal: R$ %.2f%n",
                    c.getNome(), qtd, precoComDesconto, subtotal);
        }

        System.out.printf("\nDesconto total: R$ %.2f%n", calcularDesconto());
        System.out.printf("Total do pedido: R$ %.2f%n", calcularTotal());

        if (pagamento != null) {
            System.out.println("Forma de pagamento: " + pagamento.getTipo());
            System.out.println("Status do pagamento: " + pagamento.getEstado());
        }
    }
}