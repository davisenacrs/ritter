import java.util.Scanner;

public class selecao {
    public static void main(String[]args){

        String login = "admin";
        int senha = 1234;
        Scanner objetoLeitor = new Scanner(System.in);

        System.out.println("Digite seu login e sua senha: ");
        login = objetoLeitor.nextLine();
        senha = objetoLeitor.nextInt();

        //System.out.printf("Login: %s - Senha: %d", login, senha);

        if(senha == 1234){
            System.out.println("Seja bem vindo: " + login);
        }else{
            System.out.println("Senha ou email incorreta!");
        }
    }
}
