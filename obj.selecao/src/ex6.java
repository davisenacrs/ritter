import java.util.Scanner;

public class ex6 {

    public static void main(String[] args) {

        int a, b, c;
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite o valor de A: ");
        a = leitor.nextInt();

        System.out.println("Digite o valor de B: ");
        b = leitor.nextInt();

        System.out.println("Digite o valor de C: ");
        c = leitor.nextInt();

        if ((a < b + c) && (b < a + c) && (c < a + b)) {
            System.out.printf("Os valores digitados formam um triângulo!");
        }else{
            System.out.printf("Os valores digitados não formam um triângulo!");
        }
    }
}
