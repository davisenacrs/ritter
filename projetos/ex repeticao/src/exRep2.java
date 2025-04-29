import java.util.Scanner;

public class exRep2 {
    public static void main(String[] args) {

        int soma = 0;
        Scanner leitor = new Scanner(System.in);

        System.out.print("Digite o valor A: ");

        int A = leitor.nextInt();
        System.out.print("Digite o valor B (maior que A): ");
        int B = leitor.nextInt();

        System.out.println("Números divisíveis por 5 entre os valores digitados:");

        for (int i = A; i <= B; i++) {
            if (i % 5 == 0) {
                System.out.print(i + " ");
                soma += i;
            }
        }
        System.out.printf("\nA soma dos números encontrados é: %d",  soma);
    }
}
