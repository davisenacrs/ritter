import java.util.Scanner;

public class selecao06 {
    public static void main(String[] args) {
        float ladoA, ladoB, ladoC;

        Scanner leitor = new Scanner(System.in);

        System.out.print("Digite o primeiro segmento de reta: ");
        ladoA = leitor.nextFloat();

        System.out.print("Digite o segundo segmento de reta: ");
        ladoB = leitor.nextFloat();

        System.out.print("Digite o terceiro segmento de reta: ");
        ladoC = leitor.nextFloat();

        if ((ladoA < ladoB + ladoC) && (ladoB < ladoA + ladoC) && (ladoC < ladoA + ladoB)) {
            System.out.println("Os segmentos podem formar um triângulo!");
        } else {
            System.out.println("Os segmentos NÃO podem formar um triângulo.");
        }
    }
}

