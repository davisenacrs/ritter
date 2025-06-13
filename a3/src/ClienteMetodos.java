import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClienteMetodos {

    private static List<Usuario> listaClientes = new ArrayList<>();
    Scanner leitor = new Scanner(System.in);

    public static List<Usuario> getListaClientes() {
        return listaClientes;
    }

    public static void setListaClientes(List<Usuario> listaClientes) {
        ClienteMetodos.listaClientes = listaClientes;
    }

    //    public ClienteMetodos() {
//        Usuario admin = new Usuario("Conta ADM", "31320696", "admin@loja.com", "adm123", "00000000000", "Sistema");
//        listaClientes.add(admin);
//    }


    public Usuario usuarioLogado;

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
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Cadastro realizado com sucesso!");
    }

    public void efetuarLogin() {
        System.out.print("Digite seu e-mail: ");
        String emailLogin = leitor.nextLine();

        System.out.print("Digite sua senha: ");
        String senhaLogin = leitor.nextLine();

        boolean log = false;

        for (Usuario cliente : listaClientes) {
            if (senhaLogin.equals(cliente.getSenha()) && emailLogin.equals(cliente.getEmail())) {
                usuarioLogado = cliente;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("\n Bem-vindo ao nosso site de camisetas personalizadas, " + cliente.getNome() + "! \n");
                log = true;
                break;
            }
        }
        if (!log) {
            System.out.println("Email ou senha incorretos. Tente novamente.");
        }
    }

    public void editarPerfil() {
        System.out.print("Novo nome: ");
        String nome = leitor.nextLine();

        System.out.print("Novo email: ");
        String email = leitor.nextLine();

        System.out.print("Novo telefone: ");
        String telefone = leitor.nextLine();

        System.out.print("Novo endereço: ");
        String endereco = leitor.nextLine();

        usuarioLogado.setNome(nome);
        usuarioLogado.setEmail(email);
        usuarioLogado.setTelefone(telefone);
        usuarioLogado.setEndereco(endereco);

        System.out.println("Perfil atualizado com sucesso!");
    }

}
