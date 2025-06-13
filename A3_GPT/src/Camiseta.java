public class Camiseta {
    private String nome;
    private double preco;
    private double desconto;
    private String tamanho;
    private int quantidadeVendida;

    public Camiseta(String nome, double preco, double desconto, String tamanho) {
        this.nome = nome;
        this.preco = preco;
        this.desconto = desconto;
        this.tamanho = tamanho;
        this.quantidadeVendida = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setQuantidadeVendida(int quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }
}