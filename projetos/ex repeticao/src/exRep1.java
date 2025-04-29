import java.util.Scanner;

public class exRep1 {
    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        System.out.print("Digite um valor: ");
        int valor = leitor.nextInt();
        int par = 0, impar = 0, somaPares = 0, somaImpares = 0;


        if (valor % 2 == 0) {
            System.out.printf("O número digitado é par.");
            for (int i = 1; i <= valor; i++) {
                if (i % 2 == 0) {
                    par++;
                    somaPares += i;
                }
            }
            System.out.println("Total de números pares: " + par);
            System.out.println("A soma de todos os pares é: " + somaPares);
        } else {
            System.out.println("O número digitado é impar.");
            for (int i = 1; i <= valor; i++) {
                if (i % 2 != 0) {
                    impar++;
                    somaImpares += i;
                }
            }
            System.out.println("Total de números ímpares: " + impar);
            System.out.println("A soma de todos os ímpares é: " + somaImpares);
        }
    }
}