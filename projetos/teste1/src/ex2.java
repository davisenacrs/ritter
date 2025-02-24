import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) {

    int num1, num2, num3, resultado;
    Scanner leitor = new Scanner(System.in);

    System.out.print("Digite o primeiro número: ");
    num1 = leitor.nextInt();

    System.out.print("Digite o segundo número: ");
    num2 = leitor.nextInt();

    System.out.print("Digite o terceiro número: ");
    num3 = leitor.nextInt();

    resultado = num1 + num2 + num3;

    System.out.printf(" O resultado da soma é "+ resultado);
    }
}
