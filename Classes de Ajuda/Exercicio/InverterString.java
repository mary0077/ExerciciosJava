import java.util.Scanner;

public class InverterString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite uma palavra ou frase: ");
        String texto = scanner.nextLine();

        String invertido = inverterTexto(texto);
        System.out.println("Texto invertido: " + invertido);

        scanner.close();
    }

    public static String inverterTexto(String texto) {
        StringBuilder sb = new StringBuilder(texto);
        return sb.reverse().toString();
    }
}
