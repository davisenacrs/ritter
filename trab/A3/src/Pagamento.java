// tipo serve para o cliente informar o meio de pagamento escolhido

public abstract class Pagamento {
    protected String estado;

    public abstract String getTipo();

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
