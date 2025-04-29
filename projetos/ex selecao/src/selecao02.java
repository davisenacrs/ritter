import java.util.Scanner;

public class selecao02 {
    public static void main(String[]args){

        int valor;
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite um valor: ");
        valor = leitor.nextInt();

        if(valor % 2 == 0){
            System.out.printf("Número lido (%d) é par.", valor);
        }else{
            System.out.printf("Número lido (%d) é ímpar.", valor);
        }
    }
}
