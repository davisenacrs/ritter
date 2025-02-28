import java.util.Scanner;

public class ex8 {

    public static void main(String[] args) {

        int a, b, c;
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite o valor de A: ");
        a = leitor.nextInt();

        System.out.println("Digite o valor de B: ");
        b = leitor.nextInt();

        System.out.println("Digite o valor de C: ");
        c = leitor.nextInt();

        if ((a < b + c) && (b < a + c) && (c < a + b)){
            if (a == b && b == c){
                System.out.print("Os valores fornecidos dormam um triângulo equilatero.");
            } else if  (a != b && c != b && a != c) {
                System.out.print("Os valores fornecidos formam um triângulo escaleno.");
            } else if ((a == b) || (c == b) || (a == c)) {
                System.out.print("Os valores fornecidos fornjecem um triângulo isoceles.");
            }
        }else{
            System.out.println("Os valores fornecidos não formam um triângulo.");
        }
    }
}