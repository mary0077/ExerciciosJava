import java.util.Scanner;

public class Palindromo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma palavra: ");
        String palavra = scanner.nextLine();
        String invertida = new StringBuilder(palavra).reverse().toString();

        if (palavra.equalsIgnoreCase(invertida)) {
            System.out.println("A palavra \"" + palavra + "\" é um palíndromo.");
        } else {
            System.out.println("A palavra \"" + palavra + "\" não é um palíndromo.");
        }

        scanner.close();
    }
}
