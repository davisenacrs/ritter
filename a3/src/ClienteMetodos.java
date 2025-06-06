import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClienteMetodos {

    private List<Usuario> listaClientes = new ArrayList<>();
    Scanner leitor = new Scanner(System.in);

    public ClienteMetodos() {
        Usuario admin = new Usuario("Conta ADM", "31320696", "admin@loja.com", "adm123", "00000000000", "Sistema");
        listaClientes.add(admin);
    }

    public void cadastrarCliente() {
        System.out.println("Faça seu cadastro completando os dados abaixo: \n");
        System.out.print("Nome completo: ");
        String nome = leitor.nextLine();
        System.out.print("Telefone: ");
        String telefone = leitor.nextLine();
        System.out.print("E-mail: ");
        String email = leitor.nextLine();
        System.out.print("Senha: ");
        String senha = leitor.nextLine();
        System.out.print("CPF ou CNPJ: ");
        String cpfCnpj = leitor.nextLine();
        System.out.print("Endereço para entrega: ");
        String endereco = leitor.nextLine();

        Usuario novoCliente = new Usuario(nome, telefone, email,senha, cpfCnpj, endereco);
        listaClientes.add(novoCliente);
        System.out.println("Cadastro realizado com sucesso!");
        new LojaMetodos().exibirMenuInicial();
    }

    public void efetuarLogin() {
        System.out.print("Digite seu e-mail: ");
        String emailLogin = leitor.nextLine();

        System.out.print("Digite sua senha: ");
        String senhaLogin = leitor.nextLine();

        for (Usuario cliente : listaClientes) {
            if (senhaLogin.equals(cliente.getSenha()) && emailLogin.equals(cliente.getEmail())) {
                System.out.println("Seja bem-vindo ao nosso site de camisetas personalizadas, " + cliente.getNome() + "! \n");
                new LojaMetodos().iniciarLoja();
            }else {
                    System.out.println("Email ou senha incorretos. Tente novamente.");
                    new LojaMetodos().exibirMenuInicial();
            }
        }
    }
}
