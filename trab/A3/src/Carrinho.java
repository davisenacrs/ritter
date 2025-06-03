import java.util.HashMap;
import java.util.Map;

public class Carrinho implements Calculavel {
    private Map<Camiseta, Integer> itens;
    private double valorTotal;
    private int quantidadeItens;
    private String statusCarrinho;

    public Carrinho() {
        itens = new HashMap<>();
        this.valorTotal = 0.0;
        this.quantidadeItens = 0;
        this.statusCarrinho = "Ativo";
    }

    public void adicionarItem(Camiseta camiseta, int quantidade) {
        if (itens.containsKey(camiseta)) {
            itens.put(camiseta, itens.get(camiseta) + quantidade);
        } else {
            itens.put(camiseta, quantidade);
        }
        atualizarQuantidadeItens();
        atualizarValorTotal();
    }

    public Map<Camiseta, Integer> getItens() {
        return itens;
    }

    // Getters e Setters para os novos atributos
    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getQuantidadeItens() {
        return quantidadeItens;
    }

    public void setQuantidadeItens(int quantidadeItens) {
        this.quantidadeItens = quantidadeItens;
    }

    public String getStatusCarrinho() {
        return statusCarrinho;
    }

    public void setStatusCarrinho(String statusCarrinho) {
        this.statusCarrinho = statusCarrinho;
    }

    // Métodos auxiliares para atualizar atributos
    private void atualizarQuantidadeItens() {
        this.quantidadeItens = 0;
        for (Integer qtd : itens.values()) {
            this.quantidadeItens += qtd;
        }
    }

    private void atualizarValorTotal() {
        this.valorTotal = calcularTotal();
    }

    public void mostrarItens() {
        if (itens.isEmpty()) {
            System.out.println("Carrinho vazio.");
            return;
        }

        System.out.println("\n===== CARRINHO =====");
        System.out.println("Status: " + statusCarrinho);
        double total = 0;

        for (Map.Entry<Camiseta, Integer> entry : itens.entrySet()) {
            Camiseta c = entry.getKey();
            int qtd = entry.getValue();
            double precoComDesconto = c.getPreco() * (1 - c.getDesconto());
            double subtotal = precoComDesconto * qtd;
            total += subtotal;

            System.out.printf("%s | Qtd: %d | Preço: R$ %.2f | Subtotal: R$ %.2f%n",
                    c.getNome(), qtd, precoComDesconto, subtotal);
        }

        System.out.printf("Quantidade total de itens: %d%n", quantidadeItens);
        System.out.printf("Total: R$ %.2f%n", total);
        System.out.printf("Desconto total: R$ %.2f%n", calcularDesconto());
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

    public void limpar() {
        itens.clear();
        this.valorTotal = 0.0;
        this.quantidadeItens = 0;
        this.statusCarrinho = "Finalizado";
    }
}