public class CartaoCredito extends Pagamento {
    private int numeroParcelas;
    private String numeroCartao;
    private String nomeTitular;
    private String dataValidade;
    private String codigoSeguranca;

    public CartaoCredito(int numeroParcelas, String numeroCartao, String nomeTitular, String dataValidade, String codigoSeguranca) {
        this.numeroParcelas = numeroParcelas;
        this.numeroCartao = numeroCartao;
        this.nomeTitular = nomeTitular;
        this.dataValidade = dataValidade;
        this.codigoSeguranca = codigoSeguranca;
        this.estado = "Pendente";
    }

    @Override
    public String getTipo() {
        return "Cartão de Crédito";
    }

    public int getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(int numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getCodigoSeguranca() {
        return codigoSeguranca;
    }

    public void setCodigoSeguranca(String codigoSeguranca) {
        this.codigoSeguranca = codigoSeguranca;
    }

    public void processarPagamento(double valorTotal) throws InterruptedException {
        System.out.println("Processando pagamento via cartão de crédito...");
        Thread.sleep(3000); // simula processamento
        double valorParcela = valorTotal / numeroParcelas;
        System.out.printf("Parcelamento: %d x R$ %.2f (Total: R$ %.2f)%n", numeroParcelas, valorParcela, valorTotal);
        this.estado = "Quitado";
        System.out.println("Pagamento efetuado com sucesso.");
        System.out.println("Status atualizado para: " + this.estado);
    }
}