import java.util.Scanner;

public class ex8 {

    public static void main(String[] args) {

        float horas, minutos, segundos, totalSegundos;
        Scanner leitor = new Scanner(System.in);
        System.out.print("Digite as horas: ");
        horas = leitor.nextInt();

        System.out.print("Digite os minutos: ");
        minutos = leitor.nextInt();

        System.out.print("Digite os segundos: ");
        segundos = leitor.nextInt();

        totalSegundos = (horas * 60 * 60)+(minutos * 60) + segundos;

        System.out.printf("Total de segundos do dia é: %.1f:\n ", totalSegundos);
    }
}
