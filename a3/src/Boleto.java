public class Boleto extends Pagamento{

    private int dataVencimento;
    private int dataPagamento; //talvez transorme para date vá aprender!!!

    public Boleto(int dataVencimento, int dataPagamento) {
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
        this.status = "Pendente";
    }

    public String getTipo() {
        return "Boleto";
    }

    public int getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(int dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public int getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(int dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    private static void gerarBoleto(){

    }

}
