import java.util.Scanner;

public class ex8 {

    public static void main(String[] args) {

        int horas, minutos, segundos;
        float totalSegundos;
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite o horário atual abaixo: ");
        System.out.println("Horas: ");
        horas = leitor.nextInt();

        System.out.println("Minutos: ");
        minutos = leitor.nextInt();

        System.out.println("Segundos: ");
        segundos = leitor.nextInt();

        totalSegundos = (horas * 60 * 60)+ (minutos * 60)+ segundos;

        System.out.printf("O horário atual em segundos é: %.1f", totalSegundos);

    }
}
