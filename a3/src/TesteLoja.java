import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TesteLoja {

    public static void main(String[] args) {
        List<Cliente> listaClientes = new ArrayList<>();
        Scanner leitor = new Scanner(System.in);

        //criar conta adm para poder mexer no codigo

        System.out.println("Bem-vindo a loja de camisetas personalizadas! \n");
        System.out.println("Menu:");
        System.out.println("1 - Cadastrar-se");
        System.out.println("2 - Login");
        System.out.println("3 - Sair");
        System.out.print("Escolha uma opção: ");
        int opcao = leitor.nextInt();
        leitor.nextLine();

        if (opcao == 1){
            cadastrarCliente(listaClientes, leitor);
        }else if (opcao == 2){
            efetuarLogin(listaClientes, leitor);
        }else if (opcao == 3){
            System.out.println("");
        }else {
            System.out.println("Digite um numero correspondente as opções do menu!");
            leitor.close();
        }

        public static void cadastrarCliente(List<Cliente> listaClientes, Scanner leitor) {
            System.out.println("Faça seu cadastro completando os dados abaixo: \n");
            System.out.print("Nome completo: ");
            String nome = leitor.nextLine();
            System.out.print("Telefone: ");
            String telefone = leitor.nextLine();
            System.out.print("E-mail: ");
            String email = leitor.nextLine();
            System.out.print("CPF ou CNPJ: ");
            String cpfCnpj = leitor.nextLine();
            System.out.print("Endereço para entrega: ");
            String endereco = leitor.nextLine();

            Cliente novoCliente = new Cliente(nome, telefone, email, cpfCnpj, endereco);
            listaClientes.add(novoCliente);
            System.out.println("Cadastro realizado com sucesso!");
        }

        public static void efetuarLogin(List<Cliente> listaClientes, Scanner leitor) {
            System.out.print("Digite seu e-mail: ");
            String emailLogin = leitor.nextLine();

            System.out.print("Digite sua senha: ");
            String senhaLogin = leitor.nextLine();

            boolean loginSucesso = false;

            for (Cliente cliente : listaClientes) {
                if (cliente.verificaLogin(emailLogin, senhaLogin)) {
                    System.out.println("Login realizado com sucesso! Bem-vindo(a), " + cliente.getNome() + "!");
                    loginSucesso = true;
                    break;
                }
            }

            if (!loginSucesso) {
                System.out.println("Email ou senha incorretos. Tente novamente.");
            }
        }
        //criar if else para um menu inicial e outro switch case para o tipo de pagamento
    }
}