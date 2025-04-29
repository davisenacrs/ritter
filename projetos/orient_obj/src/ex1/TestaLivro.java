package ex1;

public class TestaLivro {

    public static void main(String[] args) {

        Livro L1 = new Livro();
        L1.titulo = "Jornada nas estrelas";
        L1.autor = "Autor de Jornada nas estrelas";
        L1.ano = 2005;

        Livro L2 = new Livro();
        L2.titulo = "The walking dead";
        L2.autor = "Robert Kirkman";
        L2.ano = 2002;

        L1.exibirInfo();
        L2.exibirInfo();
    }
}
