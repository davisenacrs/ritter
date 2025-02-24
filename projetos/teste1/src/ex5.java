import java.util.Scanner;

public class ex5 {

    public static void main(String[] args) {

        int raioCirc;
        Scanner leitor = new Scanner(System.in);
        System.out.print("Digite o valor do raio de um circulo: ");
        raioCirc = leitor.nextInt();

        float area = (float) (3.14 * (raioCirc * raioCirc));

        System.out.printf("O resultado da area desse circulo é %.1f:\n ", raioCirc);
    }
}
