import java.util.Scanner;

public class ex4    {

    public static void main(String[] args) {

        int num1, num2;
        Scanner leitor = new Scanner(System.in);

        System.out.print("Digite um valor: ");
        num1 = leitor.nextInt();

        System.out.print("Digite outro valor: ");
        num2 = leitor.nextInt();

        if (num1 > num2){
            System.out.printf("O primeiro valor digitado (%d) é o maior entre eles.", num1);
        }else{
            System.out.printf("O segundo valor digitado (%d) é o maior entre eles.", num2);
        }
    }
}
