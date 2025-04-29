import java.util.Scanner;

public class exRep11 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        int totalHomens = 0, totalMulheres = 0;
        int somaIdadeHomens = 0, somaIdadeMulheres = 0;
        char sexo;
        int idade;

        while (true) {
            System.out.print("Digite o sexo (M para masculino, F para feminino, outro para sair): ");
            sexo = leitor.next().charAt(0);

            if (sexo != 'M' && sexo != 'F') {
                break;
            }

            System.out.print("Digite a idade: ");
            idade = leitor.nextInt();

            if (sexo == 'M') {
                somaIdadeHomens += idade;
                totalHomens++;
            } else {
                somaIdadeMulheres += idade;
                totalMulheres++;
            }
        }

        if (totalHomens > 0) {
            System.out.println("Média de idade dos homens: " + (somaIdadeHomens / totalHomens));
        } else {
            System.out.println("Nenhum homem foi cadastrado.");
        }

        if (totalMulheres > 0) {
            System.out.println("Média de idade das mulheres: " + (somaIdadeMulheres / totalMulheres));
        } else {
            System.out.println("Nenhuma mulher foi cadastrada.");
        }

        System.out.println("Programa encerrado.");
        leitor.close();
    }
}
