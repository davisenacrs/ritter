
public class ex2vetor {

    public static void main(String[] args) {

        int[] vetorX = new int[10];

        for (int i = 0, valor = 10; i < vetorX.length; i++, valor += 10) {
            vetorX[i]  = valor;
            System.out.println(vetorX[i]);
        }
    }
}
