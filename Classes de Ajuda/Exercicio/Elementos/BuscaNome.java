package Elementos;

import java.util.Scanner;

public class BuscaNome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nomes = new String[5];

        // Entrada de nomes
        System.out.println("Digite 5 nomes:");
        for (int i = 0; i < nomes.length; i++) {
            System.out.print("Nome " + (i + 1) + ": ");
            nomes[i] = scanner.nextLine();
        }

        // Busca no array
        System.out.print("\nDigite um nome para buscar: ");
        String busca = scanner.nextLine();
        boolean encontrado = false;

        for (String nome : nomes) {
            if (nome.equalsIgnoreCase(busca)) {
                encontrado = true;
                break;
            }
        }

        // Resultado
        if (encontrado) {
            System.out.println("O nome \"" + busca + "\" foi encontrado no array.");
        } else {
            System.out.println("O nome \"" + busca + "\" não está no array.");
        }

        scanner.close();
    }
}