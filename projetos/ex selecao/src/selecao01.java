import java.util.Scanner;

public class selecao01 {
    public static void main(String[]args){

        int valor;
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite um valor: ");
        valor = leitor.nextInt();

        if(valor > 100){
            System.out.printf("Número lido (%d) é maior que 100.", valor);
        }else{
            System.out.printf("Número lido (%d) não é maior que 100.", valor);
        }
    }
}
