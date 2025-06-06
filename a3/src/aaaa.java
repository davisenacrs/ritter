//import java.util.HashMap;
//import java.util.Map;
//
//public class aaaa {
//
//
//    ///metodo no lign para adm
//
//                if (emailLogin.equals("admin@loja.com") && senhaLogin.equals("adm123")) {
//        System.out.println("Olá Administrador!");
//        // abrir painel admin
//    } else {
//
//
//                    ///comeca classe pedido
//        private String item;
//        private int quantidade;
//        private int dataPedido;
//        private String enderecoEntrega;
//
//    public Carrinho() {
//            itens = new HashMap<>();
//        }
//
//        private Map<Camiseta, Pedido> itens;
//
//        public void adicionarItem(Camiseta camiseta, int quantidade) {
//            if (itens.containsKey(camiseta)){
//                //verifica se ja existe a camiseta no carrinho
//                itens.get(camiseta).adicionarQuantidade(quantidade);
//            } else {
//                Pedido pedido = new Pedido(camiseta.getNome(), quantidade); // Vamos ajustar o Pedido depois
//                itens.put(camiseta, pedido);
//            }
//        }
//
//        public Map<Camiseta, Pedido> getItens() {
//            return itens;
//        }
//
//    public Pedido(String item, int quantidade) {
//            this.item = item;
//            this.quantidade = quantidade;
//        }
//
//        public int getQuantidade() {
//            return quantidade;
//        }
//
//        public void adicionarQuantidade(quantidade) {
//                this.quantidade += quantidade;
//    }
//
//    }
//}
