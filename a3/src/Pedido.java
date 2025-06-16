import java.util.List;

public class Pedido implements Calculavel{

    private List<Camiseta> camisetasCompradas;
    private double valorTotal;
    private String enderecoEntrega;
    private Pagamento pagamento;
    private String status;

    public Pedido(List<Camiseta> camisetas, double valorTotal, String enderecoEntrega, Pagamento pagamento, String status) {
        this.camisetasCompradas = camisetas;
        this.valorTotal = valorTotal;
        this.enderecoEntrega = enderecoEntrega;
        this.pagamento = pagamento;
        this.status = status;
    }

    @Override
    public double calcularTotal() {
        double total = 0;
        for (Camiseta c : camisetasCompradas) {
            total += c.getPreco() * (1 - c.getDesconto());
        }
        return total;
    }

    @Override
    public double calcularDesconto() {
        double descontoTotal = 0;
        for (Camiseta c : camisetasCompradas) {
            descontoTotal += c.getPreco() * c.getDesconto();
        }
        return descontoTotal;
    }

    public List<Camiseta> getCamisetasCompradas() {
        return camisetasCompradas;
    }

    public void setCamisetasCompradas(List<Camiseta> camisetasCompradas) {
        this.camisetasCompradas = camisetasCompradas;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}