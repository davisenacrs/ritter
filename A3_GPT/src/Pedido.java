import java.util.List;

public class Pedido {
    private Cliente cliente;
    private List<Camiseta> itens;
    private Pagamento pagamento;
    private String endereco;
    private String dados; // dados adicionais
    private double valorTotal;
    private int quantidade; // quantidade de itens no pedido
    private String status; // ex: "Em processamento", "Saiu para entrega", "Entregue"

    public Pedido(Cliente cliente, List<Camiseta> itens, String endereco, String dados) {
        this.cliente = cliente;
        this.itens = itens;
        this.endereco = endereco;
        this.dados = dados;
        this.status = "Em processamento";
        this.quantidade = itens != null ? itens.size() : 0; // Inicializa a quantidade
        this.valorTotal = 0.0;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Camiseta> getItens() {
        return itens;
    }

    public void setItens(List<Camiseta> itens) {
        this.itens = itens;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDados() {
        return dados;
    }

    public void setDados(String dados) {
        this.dados = dados;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}