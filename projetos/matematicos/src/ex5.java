import java.util.Scanner;

public class ex5 {

    public static void main(String[] args) {

        int raioCirc;
        float pi = 3.14f;
        Scanner leitor = new Scanner(System.in);
        System.out.print("Digite o valor do raio de um circulo: ");
        raioCirc = leitor.nextInt();

        float area = (float) (pi * (raioCirc * raioCirc));

        System.out.printf("O resultado da area desse circulo é %.1f:\n ", area);
    }
}
