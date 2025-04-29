import java.util.Scanner;

public class exRep03 {
    public static void main(String[] args) {

        int soma = 0, valor = 0;
        Scanner leitor = new Scanner(System.in);
        System.out.print("Digite um número positivo: ");
        valor = leitor.nextInt();

        if (valor <= 0) {
            System.out.println("Digite um número inteiro positivo.");
            return;
        }

        for (int i = 1; i < valor; i++) {
            if (valor % i == 0) {
                soma += i;
            }
        }

        if (soma == valor) {
            System.out.printf("O valor digitado (%d) é um número perfeito", valor);
        } else {
            System.out.printf("O valor digitado (%d) não é um número perfeito", valor);
        }
    }
}
