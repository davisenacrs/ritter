import java.util.Scanner;

public class ex7 {

    public static void main(String[] args) {

        float polegadas;
        float milimitros;
        Scanner leitor = new Scanner(System.in);
        System.out.print("Digite as polegadas: ");
        polegadas = leitor.nextInt();

        milimitros = polegadas * 25.4f;

        System.out.printf("A metragem em milímitros é %.1f:\n ", milimitros);
    }
}
