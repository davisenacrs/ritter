import java.util.Scanner;

public class exRep06 {
    public static void main(String[] args) {

        int valor;
        Scanner leitor = new Scanner(System.in);

        do {
            System.out.print("Digite um valor: ");
            valor = leitor.nextInt();

            if (valor >= 0) {
                for (int i = 1; i <= 10; i++) {
                    System.out.printf("%d x %d = %d\n", valor, i, valor * i);
                }
            }
        } while (valor >= 0);
        System.out.printf("Fim do porgrama.");
    }
}
