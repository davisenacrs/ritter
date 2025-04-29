import java.util.Scanner;

public class vetor14 {
    public static void main(String[] args) {

        int num1, num2;
        float media;

        Scanner leitor = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        num1 = leitor.nextInt();

        System.out.print("Digite o segundo número: ");
        num2 = leitor.nextInt();

        media = (num1 + num2) / 2;
        System.out.printf("A média é: ", media);
    }
}
