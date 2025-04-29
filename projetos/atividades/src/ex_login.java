import java.util.Scanner;

public class ex_login {
    public static void main(String[] args) {

        String codigo = " ";
        String user = " ";
        String userCadastrado = " ";
        int senhaCadastrada, senha;
        Scanner leitor = new Scanner(System.in);

        codigo = "98MRbR";

        System.out.print("Cadastre seu nome de usuário: ");
        userCadastrado = leitor.nextLine();

        System.out.print("Cadastre sua senha: ");
        senhaCadastrada = leitor.nextInt();

        System.out.println("Cadastro realizado!");
        leitor.nextLine();

        System.out.print("Digite seu login: ");
        user = leitor.nextLine();

        System.out.print("Digite sua senha: ");
        senha = leitor.nextInt();

        if (!user.equals(userCadastrado) && senha != senhaCadastrada) {
            System.out.println("O nome de usuário e a senha estão incorretos.");
        } else if (!user.equals(userCadastrado)) {
            System.out.println("Apenas o nome de usuário está incorreto.");
        } else if (senha != senhaCadastrada) {
            System.out.println("Apenas a senha está incorreta.");
        } else {

        System.out.println("Login foi realizado com sucesso! Enviaremos o seu código de verificação:");

            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print("CÒDIGO: 98MRbR\n");
            leitor.nextLine();

            System.out.println("Digite seu código: ");
            codigo = leitor.nextLine();

            if (codigo.equals("98MRbR")) {
                System.out.println("Seja Bem-vindo!");
            } else {
                System.out.println("Seja Mal-vindo! Seu código está incorreto. :(");
            }
        }
    }
}
