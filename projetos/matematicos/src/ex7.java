import java.util.Scanner;

public class ex7 {

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        int polegadas;
        System.out.printf("Digite um comprimento em polegadas: ");
        polegadas = leitor.nextInt();

        float milimetros = (polegadas * 25.4f);

        System.out.printf("O comprimento de polegadas correspondente a milimetros é %.1f:", milimetros);
    }
}
