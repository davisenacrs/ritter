import java.util.Scanner;

public class selecao07 {
    public static void main(String[] args) {
        int totalEleitores, votosBrancos, votosNulos, votosValidos;
        float percentualBrancos, percentualNulos, percentualValidos;

        Scanner leitor = new Scanner(System.in);

        System.out.print("Digite o número total de eleitores: ");
        totalEleitores = leitor.nextInt();

        System.out.print("Digite o número de votos brancos: ");
        votosBrancos = leitor.nextInt();

        System.out.print("Digite o número de votos nulos: ");
        votosNulos = leitor.nextInt();

        System.out.print("Digite o número de votos válidos: ");
        votosValidos = leitor.nextInt();

        if ((votosBrancos + votosNulos + votosValidos) > totalEleitores) {
            System.out.println("Erro: O total de votos excede o número de eleitores.");
        } else {
            percentualBrancos = (votosBrancos * 100.0f) / totalEleitores;
            percentualNulos = (votosNulos * 100.0f) / totalEleitores;
            percentualValidos = (votosValidos * 100.0f) / totalEleitores;

            System.out.printf("\nPercentual de votos brancos: %.2f%%\n", percentualBrancos);
            System.out.printf("Percentual de votos nulos: %.2f%%\n", percentualNulos);
            System.out.printf("Percentual de votos válidos: %.2f%%\n", percentualValidos);
        }
    }
}

