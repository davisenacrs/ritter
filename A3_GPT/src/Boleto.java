import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Boleto extends Pagamento {
    private String dataVencimento;
    private String dataPagamento;

    public Boleto() {
        this.estado = "Pendente";
        this.dataVencimento = calcularDataVencimento();
    }

    @Override
    public String getTipo() {
        return "Boleto";
    }

    private String calcularDataVencimento() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 1); // 1 mês após a data atual
        Date vencimento = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(vencimento);
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

    public void processarPagamento() throws InterruptedException {
        System.out.println("Processando pagamento via boleto...");
        Thread.sleep(3000); // simula processamento
        this.estado = "Quitado";
        this.dataPagamento = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        System.out.println("Pagamento efetuado com sucesso.");
        System.out.println("Data de pagamento: " + dataPagamento);
        System.out.println("Status atualizado para: " + this.estado);
    }
}

