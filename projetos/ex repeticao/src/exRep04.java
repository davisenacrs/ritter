import java.util.Scanner;

public class exRep04 {

    public static void main(String[] args) {

        int valor1, valor2;
        Scanner leitor = new Scanner(System.in);

        while (true) {
            System.out.println("Digite um valor: ");
            valor1 = leitor.nextInt();

            System.out.println("Digite outro valor: ");
            valor2 = leitor.nextInt();

            if (valor1 > valor2) {
                System.out.printf("Os valor digitados foramram uma ordem decrescente. \n");
            }else if (valor2 > valor1){
                System.out.printf("Os valores digitados formaram uma ordem crescente. \n");
            }else {
                System.out.printf("Os valores digitados (%d) são iguais. Fim do programa", valor1);
                break;
            }
        }
    }
}
