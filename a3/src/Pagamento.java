public abstract class Pagamento {

    public String status;

    public abstract String getTipo();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // tipo serve para o cliente informar o meio de pagamento escolhido
}
