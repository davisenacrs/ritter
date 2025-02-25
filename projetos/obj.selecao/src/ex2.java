import java.util.Scanner;

public class ex2 {

    public static void main(String[] args) {

        int valor, par, impar;
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite um valor:");
        valor = leitor.nextInt();


        if (valor % 2 == 0){
            System.out.println("O valor digitado é par.");
        }else{
            System.out.println("O valor digitado é ímpar.");
        }
    }
}
