import java.util.Scanner;

public class selecao09 {
    public static void main(String[] args) {
        int quantidadeLaranjas;
        double precoPorLaranja, valorTotal;

        Scanner leitor = new Scanner(System.in);

        System.out.print("Digite o número de laranjas compradas: ");
        quantidadeLaranjas = leitor.nextInt();

        if (quantidadeLaranjas <= 0) {
            System.out.println("Erro: A quantidade de laranjas deve ser maior que zero.");
        } else {
            if (quantidadeLaranjas < 12) {
                precoPorLaranja = 0.30;
            } else {
                precoPorLaranja = 0.25;
            }

            valorTotal = quantidadeLaranjas * precoPorLaranja;

            System.out.printf("Valor total da compra: R$ %.2f\n", valorTotal);
        }
    }
}

