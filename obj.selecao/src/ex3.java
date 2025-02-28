import java.util.Scanner;

public class ex3 {

    public static void main(String[] args) {

        int valor1, valor2;
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite um valor:");
        valor1 = leitor.nextInt();

        System.out.println("Digite outro valor:");
        valor2 = leitor.nextInt();

        if (valor1 > valor2){
            System.out.printf("O primeiro valor digitado (%d) é o maior entre os dois.", valor1);
        }else{
            System.out.printf("O segundo valor digitado (%d) é o maior entre os dois.", valor2);
        }
    }
}
