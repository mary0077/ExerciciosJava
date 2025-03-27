import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Quantos números da sequência de Fibonacci deseja ver? ");
        int n = scanner.nextInt();
        int primeiro = 0, segundo = 1;

        System.out.print("Sequência de Fibonacci: " + primeiro + " " + segundo);
        for (int i = 2; i < n; i++) {
            int proximo = primeiro + segundo;
            System.out.print(" " + proximo);
            primeiro = segundo;
            segundo = proximo;
        }

        System.out.println();
        scanner.close();
    }
}
