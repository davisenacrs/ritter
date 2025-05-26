import java.util.Scanner;

public class TesteLoja {

    public static void main(String[] args) {
        int opcao;
        Scanner leitor = new Scanner(System.in);

        //criar conta adm para poder mexer no codigo

        System.out.println("Bem-vindo(a) à loja de camisetas personalizadas!");
        System.out.println("\nMenu:");
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("2 - Login");
        System.out.println("3 - Sair");
        System.out.print("Escolha uma opção: ");
        opcao = leitor.nextInt();
        if (opcao == 1){

        }else if (opcao == 2){

        }else if (opcao == 3){

        }else {
            System.out.println("Digite um numero correspondente as opções do menu!");
        }

        //criar if else para um menu inicial e outro switch case para o tipo de pagamento

    }
}