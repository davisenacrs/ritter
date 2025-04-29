import java.util.Scanner;

public class selecao10 {
    public static void main(String[] args) {
        int opcaoProduto, quantidade;
        double precoUnitario = 0, valorTotal = 0;
        String produto = "";

        Scanner leitor = new Scanner(System.in);

        System.out.printf("\n--- LISTA DE PRODUTOS ---\n");
        System.out.printf("1 - Banana   (R$ 0,30 unidade | R$ 0,25 acima de 12)\n");
        System.out.printf("2 - Laranja  (R$ 0,40 unidade | R$ 0,35 acima de 12)\n");
        System.out.printf("3 - Maçã     (R$ 0,50 unidade | R$ 0,45 acima de 12)\n");
        System.out.printf("4 - Kiwi     (R$ 0,40 unidade | R$ 0,30 acima de 12)\n");
        System.out.printf("-------------------------\n");

        System.out.print("Escolha o número do produto: ");
        opcaoProduto = leitor.nextInt();

        if (opcaoProduto < 1 || opcaoProduto > 4) {
            System.out.println("Erro: Opção inválida!");
        } else {
            System.out.print("Digite a quantidade desejada: ");
            quantidade = leitor.nextInt();

            if (quantidade <= 0) {
                System.out.println("Erro: A quantidade deve ser maior que zero!");
            } else {
                switch (opcaoProduto) {
                    case 1:
                        produto = "Banana";
                        precoUnitario = (quantidade < 12) ? 0.30 : 0.25;
                        break;
                    case 2:
                        produto = "Laranja";
                        precoUnitario = (quantidade < 12) ? 0.40 : 0.35;
                        break;
                    case 3:
                        produto = "Maçã";
                        precoUnitario = (quantidade < 12) ? 0.50 : 0.45;
                        break;
                    case 4:
                        produto = "Kiwi";
                        precoUnitario = (quantidade < 12) ? 0.40 : 0.30;
                        break;
                }
                valorTotal = quantidade * precoUnitario;

                System.out.printf("\nProduto escolhido: %s\n", produto);
                System.out.printf("Quantidade: %d\n", quantidade);
                System.out.printf("Preço unitário: R$ %.2f\n", precoUnitario);
                System.out.printf("Valor total da compra: R$ %.2f\n", valorTotal);
            }
        }
    }
}