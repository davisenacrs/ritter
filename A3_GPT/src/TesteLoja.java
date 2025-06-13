import java.util.*;

public class TesteLoja {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Usuario> usuarios = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Pedido> pedidos = new ArrayList<>();
    private static Funcionario funcionario = new Funcionario("Func1", "0000", "func@loja.com", "F123");
    private static Usuario adm = new Usuario("admin", "0000", "admin@loja.com", "admin123", "", "");
    private static Cliente clienteLogado = null;
    private static Usuario usuarioLogado = null;
    private static List<Camiseta> catalogo = new ArrayList<>();
    private static List<Camiseta> carrinho = new ArrayList<>();

    public static void main(String[] args) {
        inicializarCatalogo();
        boolean encerrar = false;
        while (!encerrar) {
            System.out.println("\n=== Sistema Loja ===");
            System.out.println("1. Cadastro");
            System.out.println("2. Login");
            System.out.println("3. Sair");
            System.out.print("Escolha: ");
            String op = scanner.nextLine();
            switch (op) {
                case "1":
                    cadastro();
                    break;
                case "2":
                    login();
                    break;
                case "3":
                    encerrar = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
        System.out.println("Saindo do sistema. Até logo!");
    }

    private static void inicializarCatalogo() {
        CamisetaMetodos.adicionarCamiseta(new Camiseta("Camiseta Yamal", 129.0, 0.10, "P"));
        CamisetaMetodos.adicionarCamiseta(new Camiseta("Camiseta Messi", 129.0, 0.15, "M"));
        CamisetaMetodos.adicionarCamiseta(new Camiseta("Camiseta CR7", 119.0, 0.05, "M"));
        CamisetaMetodos.adicionarCamiseta(new Camiseta("Camiseta Neymar", 109.0, 0.20, "G"));
        CamisetaMetodos.adicionarCamiseta(new Camiseta("Camiseta R9", 109.0, 0.10, "GG"));
        CamisetaMetodos.adicionarCamiseta(new Camiseta("Camiseta Kaká", 89.0, 0.05, "P"));
        CamisetaMetodos.adicionarCamiseta(new Camiseta("Camiseta Mbappé", 99.0, 0.20, "M"));
        catalogo = CamisetaMetodos.getCatalogo();
    }

    private static void cadastro() {
        System.out.println("\nCadastrar como:");
        System.out.println("1. Pessoa Física");
        System.out.println("2. Pessoa Jurídica");
        System.out.print("Escolha: ");
        String tipo = scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        if ("1".equals(tipo)) {
            System.out.print("CPF: ");
            String cpf = scanner.nextLine();
            PessoaFisica pf = new PessoaFisica(nome, email, telefone, endereco, cpf);
            clientes.add(pf);
            usuarios.add(new Usuario(nome, telefone, email, senha, cpf, endereco));
            System.out.println("Cadastro pessoa física efetuado!");
        } else if ("2".equals(tipo)) {
            System.out.print("CNPJ: ");
            String cnpj = scanner.nextLine();
            PessoaJuridica pj = new PessoaJuridica(nome, email, telefone, endereco, cnpj);
            clientes.add(pj);
            usuarios.add(new Usuario(nome, telefone, email, senha, cnpj, endereco));
            System.out.println("Cadastro pessoa jurídica efetuado!");
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private static void login() {
        System.out.print("\nDigite o email: ");
        String email = scanner.nextLine();
        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();

        // Verificar se administrador
        if (adm.verificaLogin(email, senha)) {
            usuarioLogado = adm;
            System.out.println("Login como Admin realizado com sucesso!");
            menuAdmin();
            return;
        }

        Optional<Usuario> usuarioOpt = usuarios.stream()
                .filter(u -> u.getEmail().equals(email) && u.getSenha().equals(senha))
                .findFirst();
        if (usuarioOpt.isPresent()) {
            usuarioLogado = usuarioOpt.get();
            clienteLogado = clientes.stream()
                    .filter(c -> c.getEmail().equals(email))
                    .findFirst()
                    .orElse(null);
            System.out.println("Login como cliente realizado com sucesso!");
            menuCliente();
        } else {
            System.out.println("Credenciais inválidas.");
        }
    }

    private static void menuAdmin() {
        boolean sair = false;
        while (!sair) {
            System.out.println("\n=== Menu Admin ===");
            System.out.println("1. Visualizar catálogo");
            System.out.println("2. Adicionar camiseta");
            System.out.println("3. Remover camiseta");
            System.out.println("4. Editar camiseta");
            System.out.println("5. Visualizar camisetas mais vendidas");
            System.out.println("6. Sair");
            System.out.print("Escolha: ");
            String op = scanner.nextLine();

            switch (op) {
                case "1":
                    FuncionarioMetodos.visualizarCatalogo();
                    break;
                case "2":
                    adicionarCamiseta();
                    break;
                case "3":
                    removerCamiseta();
                    break;
                case "4":
                    editarCamiseta();
                    break;
                case "5":
                    FuncionarioMetodos.visualizarMaisVendidas(5);
                    break;
                case "6":
                    sair = true;
                    usuarioLogado = null;
                    System.out.println("Logout realizado.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void adicionarCamiseta() {
        System.out.print("Nome da camiseta: ");
        String nome = scanner.nextLine();
        System.out.print("Preço: R$");
        double preco = Double.parseDouble(scanner.nextLine());
        System.out.print("Desconto (ex: 0.1 para 10%): ");
        double desconto = Double.parseDouble(scanner.nextLine());
        System.out.print("Tamanho: ");
        String tamanho = scanner.nextLine();

        Camiseta nova = new Camiseta(nome, preco, desconto, tamanho);
        FuncionarioMetodos.adicionarCamiseta(nova);
        System.out.println("Camiseta adicionada.");
    }

    private static void removerCamiseta() {
        System.out.print("Nome da camiseta a remover: ");
        String nome = scanner.nextLine();
        FuncionarioMetodos.removerCamiseta(nome);
        System.out.println("Camiseta removida se existia.");
    }

    private static void editarCamiseta() {
        System.out.print("Nome da camiseta a editar: ");
        String nomeAntigo = scanner.nextLine();

        System.out.print("Novo nome: ");
        String novoNome = scanner.nextLine();
        System.out.print("Novo preço: R$");
        double novoPreco = Double.parseDouble(scanner.nextLine());
        System.out.print("Novo desconto: ");
        double novoDesconto = Double.parseDouble(scanner.nextLine());
        System.out.print("Novo tamanho: ");
        String novoTamanho = scanner.nextLine();

        Camiseta nova = new Camiseta(novoNome, novoPreco, novoDesconto, novoTamanho);
        FuncionarioMetodos.editarCamiseta(nomeAntigo, nova);
        System.out.println("Camiseta editada.");
    }

    private static void menuCliente() {
        boolean sair = false;
        carrinho.clear();
        while (!sair) {
            System.out.println("\n=== Menu Cliente ===");
            System.out.println("1. Ver catálogo");
            System.out.println("2. Adicionar ao carrinho");
            System.out.println("3. Ver carrinho");
            System.out.println("4. Finalizar compra");
            System.out.println("5. Ver histórico de compras");
            System.out.println("6. Editar perfil");
            System.out.println("7. Logout");
            System.out.print("Escolha: ");
            String op = scanner.nextLine();

            switch (op) {
                case "1":
                    CamisetaMetodos.visualizarCatalogo();
                    break;
                case "2":
                    adicionarAoCarrinho();
                    break;
                case "3":
                    verCarrinho();
                    break;
                case "4":
                    try {
                        finalizarCompra();
                    } catch (InterruptedException e) {
                        System.out.println("Erro no processamento do pagamento.");
                    }
                    break;
                case "5":
                    PedidoMetodos.verHistoricoCompras(clienteLogado);
                    break;
                case "6":
                    editarPerfil();
                    break;
                case "7":
                    sair = true;
                    usuarioLogado = null;
                    clienteLogado = null;
                    System.out.println("Logout realizado.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void adicionarAoCarrinho() {
        System.out.print("Nome da camiseta para adicionar ao carrinho: ");
        String nome = scanner.nextLine();
        Optional<Camiseta> c = catalogo.stream()
                .filter(cam -> cam.getNome().equalsIgnoreCase(nome))
                .findFirst();
        if (c.isPresent()) {
            carrinho.add(c.get());
            System.out.println("Camiseta adicionada ao carrinho.");
        } else {
            System.out.println("Camiseta não encontrada.");
        }
    }

    private static void verCarrinho() {
        if (carrinho.isEmpty()) {
            System.out.println("Carrinho vazio.");
            return;
        }
        System.out.println("=== Carrinho ===");
        for (Camiseta c : carrinho) {
            System.out.printf("Nome: %s | Tamanho: %s | Preço: R$ %.2f%n",
                    c.getNome(), c.getTamanho(), c.getPreco());
        }
    }

    private static void finalizarCompra() throws InterruptedException {
        if (carrinho.isEmpty()) {
            System.out.println("Carrinho vazio. Adicione produtos antes de finalizar.");
            return;
        }
        System.out.print("Deseja escolher boleto ou cartão de crédito? (boleto/cartao): ");
        String escolha = scanner.nextLine().toLowerCase();

        List<Camiseta> itensCompra = new ArrayList<>(carrinho);
        Pedido pedido = new Pedido(clienteLogado, itensCompra, clienteLogado.getEndereco(), "");
        pedido.setStatus("Em processamento");
        PedidoMetodos.calcularTotais(pedido);

        if ("boleto".equals(escolha)) {
            Boleto boleto = new Boleto();
            pedido.setPagamento(boleto);
        } else if ("cartao".equals(escolha)) {
            System.out.print("Número do cartão: ");
            String numeroCartao = scanner.nextLine();
            System.out.print("Nome do titular: ");
            String nomeTitular = scanner.nextLine();
            System.out.print("Data de validade (MM/AA): ");
            String dataValidade = scanner.nextLine();
            System.out.print("Código de segurança: ");
            String codigoSeguranca = scanner.nextLine();
            System.out.print("Número de parcelas: ");
            int parcelas = Integer.parseInt(scanner.nextLine());
            CartaoCredito cartao = new CartaoCredito(parcelas, numeroCartao, nomeTitular, dataValidade, codigoSeguranca);
            pedido.setPagamento(cartao);
        } else {
            System.out.println("Forma de pagamento inválida.");
            return;
        }

        PedidoMetodos.finalizarCompra(pedido);
        pedidos.add(pedido);
        carrinho.clear();
    }

    private static void editarPerfil() {
        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();
        System.out.print("Novo email: ");
        String email = scanner.nextLine();
        System.out.print("Novo telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Novo endereço: ");
        String endereco = scanner.nextLine();

        PedidoMetodos.editarPerfil(clienteLogado, nome, email, telefone, endereco);
    }
}