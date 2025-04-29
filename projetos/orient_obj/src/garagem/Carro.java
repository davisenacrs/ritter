package garagem;

public class Carro extends Veiculo {

    private int numeroPortas;

    public Carro(String marca, String modelo, int numeroPortas) {
        super(marca, modelo);
        this.numeroPortas = numeroPortas;
        System.out.println("Carro com " + numeroPortas + " portas criado.");
    }

    @Override
    public void acelerar() {
        super.acelerar();
        System.out.println("Veículo acelerando...(Carro)");
    }

    public void abrirPorta() {
        System.out.println("Porta do carro aberta.");
    }
}
