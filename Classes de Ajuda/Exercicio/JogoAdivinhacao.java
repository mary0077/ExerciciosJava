import java.util.Scanner;
import java.util.Random;

public class JogoAdivinhacao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numeroSecreto = random.nextInt(10) + 1; // Gera um número entre 1 e 10

        System.out.print("Tente adivinhar o número (entre 1 e 10): ");
        int tentativa = scanner.nextInt();

        if (tentativa == numeroSecreto) {
            System.out.println("Parabéns! Você acertou!");
        } else {
            System.out.println("Que pena! O número era " + numeroSecreto);
        }

        scanner.close();
    }
}
