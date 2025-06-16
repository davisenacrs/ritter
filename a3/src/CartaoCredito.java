public class CartaoCredito extends Pagamento {
    private int numParcelas;

    public CartaoCredito(int numParcelas) {
        this.numParcelas = numParcelas;
        this.status = "Pendente";
    }

    @Override
    public String getTipo() {
        return "Cartão de Crédito";
    }

    public int getNumParcelas() {
        return numParcelas;
    }

    public void calculaParcelas(double valorTotal) {
        double valorParcela = valorTotal / numParcelas;
        System.out.println("Parcelamento escolhido:");
        for (int i = 1; i <= numParcelas; i++) {
            System.out.printf("Parcela %d: R$ %.2f\n", i, valorParcela);
        }
        System.out.println("\nProcessando pagamento...");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.status = "Pendente";
        System.out.println("Status atualizado para: " + this.status);
    }
}
