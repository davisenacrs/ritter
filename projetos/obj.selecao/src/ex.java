import java.util.Scanner;

public class ex {
    public static void main(String[] args) {
        String login = "admin";
        int senha = 1234;
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite seu login e senha: ");
        login = leitor.nextLine();
        senha = leitor.nextInt();

        if (senha == 1234){
            System.out.println("Seja Bem-vindo!");
        }else{
            System.out.println("Senha ou login incorreto.");
        }
    }
}