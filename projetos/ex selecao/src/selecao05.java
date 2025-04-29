import java.util.Scanner;

public class selecao05 {
    public static void main(String[] args) {
        float valor;

        Scanner leitor = new Scanner(System.in);

        System.out.print("Digite um valor: ");
        valor = leitor.nextFloat();

        if (valor > 100 && valor < 200) {
            System.out.println("O valor está dentro do intervalo (100, 200).");
        } else {
            System.out.println("O valor está fora do intervalo (100, 200).");
        }
    }
}

