import java.util.Scanner;

public class SomaDigitos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número inteiro positivo: ");
        int numero = scanner.nextInt();

        if (numero < 0) {
            System.out.println("Por favor, insira um número positivo.");
        } else {
            int soma = calcularSomaDigitos(numero);
            System.out.println("A soma dos dígitos é: " + soma);
        }

        scanner.close();
    }

    public static int calcularSomaDigitos(int num) {
        int soma = 0;   

        while (num > 0) {
            soma += num % 10; // Obtém o último dígito e adiciona à soma
            num /= 10; // Remove o último dígito
        }

        return soma;
    }
}
