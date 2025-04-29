import java.util.Scanner;

public class selecao04 {
    public static void main(String[]args){

        int valor1;
        int valor2;
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite o valor 1: ");
        valor1 = leitor.nextInt();

        System.out.println("Digite o valor 2: ");
        valor2 = leitor.nextInt();

        if(valor1 < valor2 ){
            System.out.printf("O (%d) é o menor numero digitado", valor1);
        }else{
            System.out.printf("O (%d) é o menor numero digitado", valor2);
        }
    }
}
