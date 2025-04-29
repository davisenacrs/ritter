import java.util.Scanner;

public class vetor {
    public static void main(String[] args) {

        //String[] vetor = new String[5];

        int[] vetor = new int[5];
        Scanner leitor = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.println("Digite um número: ");
            vetor[i] = leitor.nextInt();
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(vetor[i]);
        }
    }
}
