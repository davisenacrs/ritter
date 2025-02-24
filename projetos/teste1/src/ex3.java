import java.util.Scanner;

public class ex3 {
    public static void main(String[] args) {

        int num1, num2, num3,num4;
        float resultado;
        Scanner leitor = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        num1 = leitor.nextInt();

        System.out.print("Digite o segundo número: ");
        num2 = leitor.nextInt();

        System.out.print("Digite o terceiro número: ");
        num3 = leitor.nextInt();

        System.out.print("Digite o quarto número: ");
        num4 = leitor.nextInt();

        resultado = (num1 + num2 + num3 + num4) / 4;

        System.out.printf("A média aritimética entre os números é: %.2f", resultado);
    }
}
