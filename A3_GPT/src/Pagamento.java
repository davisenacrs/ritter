public abstract class Pagamento {
    protected String estado; // Ex: Pendente, Quitado

    public abstract String getTipo();

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
