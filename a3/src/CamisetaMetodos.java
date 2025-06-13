import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CamisetaMetodos {

    Scanner leitor = new Scanner(System.in);
    private List<Camiseta> catalogo = new ArrayList<>();


    public CamisetaMetodos() {
        if (catalogo.isEmpty()) {
            catalogoCamisetas();
        }
    }

    public List<Camiseta> getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(List<Camiseta> catalogo) {
        this.catalogo = catalogo;
    }

    public void catalogoCamisetas() {
        catalogo.add(new Camiseta(1,"Camiseta Yamal", 129.0, 0.10));
        catalogo.add(new Camiseta(2,"Camiseta Messi", 129.0, 0.15));
        catalogo.add(new Camiseta(3,"Camiseta CR7", 119.0, 0.05));
        catalogo.add(new Camiseta(4,"Camiseta Neymar", 109.0, 0.20));
        catalogo.add(new Camiseta(5,"Camiseta R9", 109.0, 0.10));
        catalogo.add(new Camiseta(6,"Camiseta R10", 109.0, 0.15));
        catalogo.add(new Camiseta(7,"Camiseta Kaká", 89.0, 0.05));
        catalogo.add(new Camiseta(8,"Camiseta Mbappé", 99.0, 0.20));
    }

    public void adicionarCamiseta() {
        System.out.println("Adicionar nova camiseta:");

        System.out.print("Nome (ex: Camiseta Mbappé) :");
        String nome = leitor.nextLine();

        System.out.print("Preço (ex: 109.0):");
        double preco = Double.parseDouble(leitor.nextLine());

        System.out.print("Desconto (0.1 para 10%) :");
        double desconto = Double.parseDouble(leitor.nextLine());

        int novoId = catalogo.isEmpty() ? 1 : catalogo.get(catalogo.size() - 1).getId() + 1;

        Camiseta nova = new Camiseta(novoId, nome, preco, desconto);
        catalogo.add(nova);

        System.out.println("Camiseta adicionada com sucesso!");
    }

    public void removerCamiseta() {
        System.out.println("\nCatálogo de camisetas disponíveis:");
        for (Camiseta c : catalogo) {
            System.out.printf("ID %d - %s | Preço: R$%.2f | Desconto: %.0f%% | Tamanho: %s%n",
                    c.getId(), c.getNome(), c.getPreco(), c.getDesconto() * 100, c.getTamanho());
        }

        System.out.print("\nDigite o Numero(ID) da camiseta que deseja remover: ");
        int id = Integer.parseInt(leitor.nextLine());

        boolean removida = false;

        for (int i = 0; i < catalogo.size(); i++) {
            if (catalogo.get(i).getId() == id) {
                catalogo.remove(i);
                removida = true;
                System.out.println("Camiseta removida com sucesso!");
                break;
            }
        }

        if (!removida) {
            System.out.println("Nenhuma camiseta com esse ID foi encontrada.");
        }
    }

    public void editarCamiseta() {
        System.out.println("\nCatálogo de camisetas disponíveis:");
        for (Camiseta c : catalogo) {
            System.out.printf("%d - %s | Preço: R$%.2f | Desconto: %.0f%% | Tamanho: %s%n",
                    c.getId(), c.getNome(), c.getPreco(), c.getDesconto() * 100, c.getTamanho());
        }

        System.out.print("\nDigite o numero (ID) da camiseta que deseja editar: ");
        int id = Integer.parseInt(leitor.nextLine());

        for (Camiseta c : catalogo) {
            if (c.getId() == id) {
                System.out.print("Novo nome (" + c.getNome() + "): ");
                String nome = leitor.nextLine();

                System.out.print("Novo preço (" + c.getPreco() + "): ");
                double preco = Double.parseDouble(leitor.nextLine());

                System.out.print("Novo desconto (" + c.getDesconto() + "): ");
                double desconto = Double.parseDouble(leitor.nextLine());

                System.out.print("Novo tamanho (" + c.getTamanho() + "): ");
                String tamanho = leitor.nextLine();

                c.setNome(nome);
                c.setPreco(preco);
                c.setDesconto(desconto);
                c.setTamanho(tamanho);

                System.out.println("Camiseta editada com sucesso!");
                return;
            }
        }
        System.out.println("Nenhuma camiseta com esse ID foi encontrada.");
    }
}
