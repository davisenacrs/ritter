import java.util.Scanner;

public class ex4 {

    public static void main(String[] args) {

        int num1;
        Scanner leitor = new Scanner(System.in);
        System.out.print("Digite um número: ");
        num1 = leitor.nextInt();

        float x = num1;

        System.out.printf("A seguir alguma operções com o número X em questão, no qual é %.1f:\n ", x);

        float quadrado = x * x;
        System.out.println("O quadrado de X é: " + quadrado);

        float resto = (x % 3);
        System.out.println("O resto da divisão de X por 3 é: " + resto);

        float metade = x / 2;
        System.out.println("A metade de X é: " + metade);

        float produto = x * metade;
        System.out.println("O produto de X dividido por sua metade é: " + produto);
    }
}
