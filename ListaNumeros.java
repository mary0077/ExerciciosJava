import java.util.ArrayList;

import java.util.Scanner;

public class ListaNumeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numeros = new ArrayList<>();
        int soma = 0;

        System.out.println("Digite números inteiros (digite 0 para sair):");

        while (true) {
            int numero = scanner.nextInt();
            if (numero == 0) {
                break;
            }
            numeros.add(numero);
            soma += numero;
        }

        System.out.println("Números armazenados: " + numeros);
        System.out.println("Soma total: " + soma);

        scanner.close();
    }
}
