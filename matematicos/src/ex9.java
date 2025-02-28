import java.util.Scanner;

public class ex9 {

    public static void main(String[] args) {

        int homens,mulheres, criancas;
        float quantGra, quantKg;
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite o numero de homens que irão participar o churrasco: ");
        homens = leitor.nextInt();

        System.out.println("Digite o numero de mulheres que irão participar o churrasco: ");
        mulheres = leitor.nextInt();

        System.out.println("Digite o numero de crianças que irão participar o churrasco: ");
        criancas = leitor.nextInt();

        quantGra = (homens * 650) + (mulheres * 420) + (criancas * 290);

        quantKg = quantGra / 1000;

        System.out.printf("A quantidade necessária de carne para o churrasco será de: %.2f Kg", quantKg);
    }
}
