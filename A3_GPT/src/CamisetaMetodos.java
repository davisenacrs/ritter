import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CamisetaMetodos {
    private static List<Camiseta> catalogo = new ArrayList<>();

    public static void adicionarCamiseta(Camiseta camiseta) {
        catalogo.add(camiseta);
    }

    public static void removerCamiseta(String nome) {
        catalogo.removeIf(c -> c.getNome().equalsIgnoreCase(nome));
    }

    public static void editarCamiseta(String nome, Camiseta novaCamiseta) {
        for (int i = 0; i < catalogo.size(); i++) {
            if (catalogo.get(i).getNome().equalsIgnoreCase(nome)) {
                catalogo.set(i, novaCamiseta);
                break;
            }
        }
    }

    public static void visualizarCatalogo() {
        System.out.println("\n=== CATÁLOGO DE CAMISETAS ===");
        for (Camiseta c : catalogo) {
            System.out.printf("Nome: %s | Tamanho: %s | Preço: R$ %.2f | Desconto: R$ %.2f | Vendidos: %d%n",
                    c.getNome(), c.getTamanho(), c.getPreco(), c.getDesconto(), c.getQuantidadeVendida());
        }
    }

    public static void camisetasMaisCompradas(int topN) {
        catalogo.stream()
                .sorted(Comparator.comparingInt(Camiseta::getQuantidadeVendida).reversed())
                .limit(topN)
                .forEach(c -> System.out.printf("Nome: %s | Quantidade Vendida: %d%n", c.getNome(), c.getQuantidadeVendida()));
    }

    public static List<Camiseta> getCatalogo() {
        return catalogo;
    }
}
