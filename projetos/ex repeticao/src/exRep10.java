import java.util.Scanner;

public class exRep10 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int numero;

        do {
            System.out.print("Digite um número positivo: ");
            numero = leitor.nextInt();

            if (numero > 0) {
                for (int i = 1; i <= numero; i++) {
                    System.out.println(numero + " x " + i + " = " + (numero * i));
                }
            }
        } while (numero > 0);

        System.out.println("Fim do programa.");
        leitor.close();
    }
}
