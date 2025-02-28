import java.util.Scanner;

public class ex5 {

    public static void main(String[] args) {

        int valor;
        Scanner leitor = new Scanner(System.in);

        System.out.print("Digite um valor: ");
        valor = leitor.nextInt();

        if (valor > 99 && valor < 201) {
            System.out.printf("O valor digitado (%d) está entre 100 e 200.", valor);
        }else{
            System.out.print("O valor digitado não está entre 100 e 200.");
        }
    }
}
