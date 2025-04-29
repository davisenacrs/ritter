import java.util.Scanner;

public class funcao {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        String nome;
        System.out.println("Digite seu nome: ");
        nome = leitor.nextLine();
        //System.out.println(nome);
        //imprimeString(nome);

    }
    public static void imprimeString(String nome){
        System.out.println(nome);
    }
    public static String imprimeStringMaiusculo(String nome) { System.out.println(nome);
        return nome.toUpperCase();
    }
}