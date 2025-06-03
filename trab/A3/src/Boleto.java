public class Boleto extends Pagamento {
    private String dataVencimento;
    private String dataPagamento;

    public Boleto(String dataVencimento, String dataPagamento) {
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
        this.estado = "Pendente";
    }

    @Override
    public String getTipo() {
        return "Boleto";
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public void processarPagamento() {
        System.out.println("Processando boleto...");
        this.estado = "Quitado";
        System.out.println("Status atualizado para: " + this.estado);
    }
}

