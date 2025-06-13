import java.util.ArrayList;
import java.util.List;

public class Camiseta {

    private int id;
    private String nome;
    private double preco;
    private double desconto;
    private String tamanho;

    public Camiseta(int id, String nome, double preco, double desconto, String tamanho) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.desconto = desconto;
        this.tamanho = tamanho;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
