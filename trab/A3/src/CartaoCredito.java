public class CartaoCredito extends Pagamento {
    private int numeroParcelas;

    public CartaoCredito(int numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
        this.estado = "Pendente";
    }

    @Override
    public String getTipo() {
        return "Cartão de Crédito";
    }

    public int getNumeroParcelas() {
        return numeroParcelas;
    }
    
    // Método simples para calcular parcelas
    public void calculaParcelas(double valorTotal) {
        System.out.println("\n=== PARCELAMENTO ===");
        double valorParcela = valorTotal / numeroParcelas;
        System.out.printf("%d x R$ %.2f = R$ %.2f%n", 
                numeroParcelas, valorParcela, valorTotal);
        
        // Simula processamento e atualiza status automaticamente
        System.out.println("Processando pagamento...");
        this.estado = "Quitado"; // Atualiza automaticamente para quitado
        System.out.println("Status atualizado para: " + this.estado);
    }
}