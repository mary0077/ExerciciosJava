import java.util.Scanner;

public class CalculadoraMedia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita o nome do aluno
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();

        // Solicita as três notas do aluno
        System.out.print("Digite a primeira nota: ");
        double nota1 = scanner.nextDouble();

        System.out.print("Digite a segunda nota: ");
        double nota2 = scanner.nextDouble();

        System.out.print("Digite a terceira nota: ");
        double nota3 = scanner.nextDouble();

        // Calcula a média aritmética
        double media = (nota1 + nota2 + nota3) / 3;

        // Determina se o aluno foi aprovado ou reprovado
        String status = (media >= 7.0) ? "Aprovado" : "Reprovado";

        // Exibe o resultado
        System.out.printf("Aluno %s está %s com média %.2f%n", nome, status, media);

        // Fecha o scanner
        scanner.close();
    }
}
