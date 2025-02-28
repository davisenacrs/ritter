import java.util.Scanner;

public class ex6 {
    public static void main(String[] args) {

        float TempFar;
        Scanner leitor = new Scanner(System.in);
        System.out.print("Digite uma temperatura em Fahrenheit: ");
        TempFar = leitor.nextInt();

        float TempCel = 5 * (TempFar - 32) / 9;

        System.out.printf("A temperatura digitada acima em Celsius é %.1f:\n ", TempCel);

    }
}
