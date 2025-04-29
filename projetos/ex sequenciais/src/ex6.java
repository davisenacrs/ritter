import java.util.Scanner;

public class ex6 {

    public static void main(String[] args) {

        float tempFahrenheit;
        float tempCelsius;
        Scanner leitor = new Scanner(System.in);
        System.out.print("Digite a temperatura em fahrenheit: ");
        tempFahrenheit = leitor.nextInt();

        tempCelsius = 5 * (tempFahrenheit - 32) / 9;

        System.out.printf("A temperatura em celsius é %.1f:\n ", tempCelsius);
    }
}
