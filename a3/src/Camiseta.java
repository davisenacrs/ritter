import java.util.ArrayList;
import java.util.List;

public class Camiseta {

    private String nome;
    private double preco;
    private double desconto;
    private String tamanho;

    public Camiseta(String nome, double preco, double desconto, String tamanho) {
        this.nome = nome;
        this.preco = preco;
        this.desconto = desconto;
        this.tamanho = tamanho;
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

    //criar metodo mostrarCatalogo e e mostrar todas as camisetas do arraylist via for no testeLoja
}
