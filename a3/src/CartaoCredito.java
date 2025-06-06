public class CartaoCredito extends Pagamento {

    private int numParcelas;

    public CartaoCredito(int numParcelas) {
        this.numParcelas = numParcelas;
        this.status = "Pendente";
    }

    public String getTipo() {
        return "Boleto";
    }

    public int getNumParcelas() {
        return numParcelas;
    }

    public void calculaParcelas(double valorTotal) {
        System.out.println("Calculando todos os valores da parcela: ");
        double valorParcela = valorTotal / numParcelas;
        System.out.printf("%d x R$ %.2f = R$ %.2f%n", numParcelas, valorParcela, valorTotal);

        System.out.println("Processando pagamento...");
        //colocar sleep aqui
        this.status = "Quitado";

        System.out.println("Status atualizado para: " + this.status);
    }
    //criar metodo calculaParcelas (mostrar para o cliente as opcoes de qnts parcelas e clacular a divisao a depender do valor da peça
}
