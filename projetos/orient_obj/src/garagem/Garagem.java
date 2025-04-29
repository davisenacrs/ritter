package garagem;

public class Garagem {

    public static void main(String[] args) {

        Carro meuCarro = new Carro("Fiat", "Uno", 4);
        meuCarro.acelerar();
        meuCarro.abrirPorta();

        Moto minhaMoto = new Moto("Honda", "CG Titan", true);  // Passando booleano para Moto
        minhaMoto.acelerar();
        minhaMoto.empinar();

        Veiculo veiculoGenerico = new Carro("Vw", "Gol", 2);
        veiculoGenerico.acelerar();
    }
}
