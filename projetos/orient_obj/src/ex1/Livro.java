package ex1;

public class Livro {

    String titulo;
    String autor;
    int ano;

    public void exibirInfo(){
        System.out.printf("%s - %s (%d)\n", titulo, autor, ano);
    }

}
