import java.util.Scanner;

public class ex1 {
    public static void main(String[] args){

    int numero1;
    int numero2;
    int produto;
    Scanner leitor = new Scanner(System.in);

    System.out.print("Digite o primeiro número: ");
    numero1 = leitor.nextInt();

    System.out.print("Digite o segundo número: ");
    numero2 = leitor.nextInt();

    produto = numero1 * numero2;
    System.out.printf("O produto é: %d\n", produto);
//    System.out.printf("O produto é: "+ produto);
    }
}
