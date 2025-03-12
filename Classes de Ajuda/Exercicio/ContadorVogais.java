import java.util.Scanner;

public class ContadorVogais {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite uma frase: ");
        String frase = scanner.nextLine();

        int contador = contarVogais(frase);

        System.out.println("A frase contém " + contador + " vogais.");

        scanner.close();
    }

    public static int contarVogais(String texto) {
        int contador = 0;
        String vogais = "aeiouAEIOU";

        for (char c : texto.toCharArray()) {
            if (vogais.indexOf(c) != -1) {
                contador++;
            }
        }

        return contador;
    }
}
 
