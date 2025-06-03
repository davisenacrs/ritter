import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Nome> nomes = new ArrayList<>();
        String nome;

        // cria lista chamada "nomes" para armazenar os nomes digitados

        System.out.println("Digite 5 nomes:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Nome " + (i + 1) + ": ");
            Nome = scanner.nextLine();
            nomes.add(Nome);
        }

        System.out.println("\nNomes digitados:");
        for (String Nome : nomes) {
            System.out.println(" " + Nome);
        }


        System.out.print("\nDigite um nome que deseja remover da lista: ");
        String nomeRemover = scanner.nextLine();

        if (nomes.remove(nomeRemover)) {
            System.out.println("Nome removido com sucesso!");
        } else {
            System.out.println("Nome não encontrado na lista.");
        }

        System.out.println("\nLista final de nomes:");

        for (String nome : nomes) {
            System.out.println(" " + nome);
        }

        scanner.close();
    }
}
