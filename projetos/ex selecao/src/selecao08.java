import java.util.Scanner;

public class selecao08 {
    public static void main(String[] args) {
        float ladoA, ladoB, ladoC;

        Scanner leitor = new Scanner(System.in);

        System.out.print("Digite o primeiro lado do triângulo: ");
        ladoA = leitor.nextFloat();

        System.out.print("Digite o segundo lado do triângulo: ");
        ladoB = leitor.nextFloat();

        System.out.print("Digite o terceiro lado do triângulo: ");
        ladoC = leitor.nextFloat();

        if ((ladoA < ladoB + ladoC) && (ladoB < ladoA + ladoC) && (ladoC < ladoA + ladoB)) {
            System.out.println("Os lados formam um triângulo!");

            if (ladoA == ladoB && ladoB == ladoC) {
                System.out.println("Triângulo Equilátero: todos os lados são iguais.");
            } else if (ladoA == ladoB || ladoA == ladoC || ladoB == ladoC) {
                System.out.println("Triângulo Isósceles: dois lados são iguais.");
            } else {
                System.out.println("Triângulo Escaleno: todos os lados são diferentes.");
            }
        } else {
            System.out.println("Os lados NÃO formam um triângulo.");
        }
    }
}
