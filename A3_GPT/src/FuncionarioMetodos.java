public class FuncionarioMetodos {

    public static void visualizarCatalogo() {
        CamisetaMetodos.visualizarCatalogo();
    }

    public static void adicionarCamiseta(Camiseta camiseta) {
        CamisetaMetodos.adicionarCamiseta(camiseta);
    }

    public static void removerCamiseta(String nome) {
        CamisetaMetodos.removerCamiseta(nome);
    }

    public static void editarCamiseta(String nomeAntigo, Camiseta novaCamiseta) {
        CamisetaMetodos.editarCamiseta(nomeAntigo, novaCamiseta);
    }

    public static void visualizarMaisVendidas(int topN) {
        CamisetaMetodos.camisetasMaisCompradas(topN);
    }
}