import java.util.Scanner;

public class ex9 {

    public static void main(String[] args) {

        float homens, mulheres, crianças, totalcarne;
        Scanner leitor = new Scanner(System.in);

        homens = 3 * 650f;
        mulheres = 3 * 420f;
        crianças = 2 * 290f;

        totalcarne = (float) homens + mulheres + crianças;

        System.out.printf("Quantidade de carne necessária em gramas para o churrasco: %.1fgramas\n", totalcarne);
    }
}
