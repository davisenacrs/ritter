//import java.util.HashMap;
//import java.util.Map;
//
//public class Pedido {
//
//    private String item;
//    private int quantidade;
//    private int dataPedido;
//    private String enderecoEntrega;
//
//    public Carrinho() {
//        itens = new HashMap<>();
//    }
//
//    private Map<Camiseta, Pedido> itens;
//
//    public void adicionarItem(Camiseta camiseta, int quantidade) {
//        if (itens.containsKey(camiseta)){
//            //verifica se ja existe a camiseta no carrinho
//            itens.get(camiseta).adicionarQuantidade(quantidade);
//        } else {
//            Pedido pedido = new Pedido(camiseta.getNome(), quantidade); // Vamos ajustar o Pedido depois
//            itens.put(camiseta, pedido);
//        }
//    }
//
//    public Map<Camiseta, Pedido> getItens() {
//        return itens;
//    }
//
//    public Pedido(String item, int quantidade) {
//        this.item = item;
//        this.quantidade = quantidade;
//    }
//
//    public int getQuantidade() {
//        return quantidade;
//    }
//
//    public void adicionarQuantidade(quantidade) {
//        this.quantidade += quantidade;
//    }
//
//    //criar metodo para pedir para o cliente digitar a quantidade de cada item que ele quer
//    //hash map é bom para essa situação
//    //criar metodos onde aqui eu posso pedir para o cliente informar a data do pedido e
//    //outro para pegar o endereço da classe cliente(talvez substitua o enderecoEntrega tornando ele um metodo
//}
