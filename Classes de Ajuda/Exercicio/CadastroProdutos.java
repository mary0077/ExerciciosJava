import java.util.ArrayList;
import java.util.Scanner;

class Produto {
    private String nome;
    private int quantidade;
    private double preco;

    public Produto(String nome, int quantidade, double preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public void exibirDetalhes() {
        System.out.println("Nome: " + nome);
        System.out.println("Quantidade: " + quantidade);
        System.out.printf("Preço: R$ %.2f\n", preco);
        System.out.println("---------------------------");
    }

    public void atualizarEstoque(int novaQuantidade) {
        this.quantidade = novaQuantidade;
        System.out.println("Estoque atualizado com sucesso!");
    }

    public String getNome() {
        return nome;
    }
}

public class CadastroProdutos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Produto> listaProdutos = new ArrayList<>();

        System.out.println("=== Cadastro de Produtos ===");

        // Cadastro de 3 produtos
        for (int i = 1; i <= 3; i++) {
            System.out.println("Produto " + i + ":");
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Quantidade: ");
            int quantidade = Integer.parseInt(scanner.nextLine());
            System.out.print("Preço: ");
            double preco = Double.parseDouble(scanner.nextLine());

            Produto produto = new Produto(nome, quantidade, preco);
            listaProdutos.add(produto);
        }

        // Menu de opções
        int opcao;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1 - Listar todos os produtos");
            System.out.println("2 - Atualizar estoque de um produto");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    System.out.println("\n--- Lista de Produtos ---");
                    for (Produto p : listaProdutos) {
                        p.exibirDetalhes();
                    }
                    break;
                case 2:
                    System.out.print("Digite o nome do produto para atualizar: ");
                    String nomeBusca = scanner.nextLine();
                    boolean encontrado = false;

                    for (Produto p : listaProdutos) {
                        if (p.getNome().equalsIgnoreCase(nomeBusca)) {
                            System.out.print("Nova quantidade: ");
                            int novaQtd = Integer.parseInt(scanner.nextLine());
                            p.atualizarEstoque(novaQtd);
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Produto não encontrado.");
                    }
                    break;
                case 3:
                    System.out.println("Saindo... 👋");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 3);

        scanner.close();
    }
}
