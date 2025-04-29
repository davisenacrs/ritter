public class exRep08 {
    public static void main(String[] args) {
        int count = 0, num = 101;

        while (count < 50) {
            if (primo(num)) {
                System.out.print(num + " ");
                count++;
            }
            num++;
        }
    }
    public static boolean primo(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
