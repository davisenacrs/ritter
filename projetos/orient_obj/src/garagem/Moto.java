package garagem;

public class Moto extends Veiculo {

    private boolean temCarrenagem;

    public Moto(String marca, String modelo, boolean temCarrenagem) {
        super(marca, modelo);
        this.temCarrenagem = temCarrenagem;
        System.out.println("Moto com carenagem " + temCarrenagem + " criada.");
    }

    public void empinar() {
        System.out.println("Moto empinando");
    }

    @Override
    public void acelerar() {
        super.acelerar();
        System.out.println("Veículo acelerando...(Moto)");
    }
}
