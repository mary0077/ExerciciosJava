import java.io.*;
import java.util.*;

class Livro implements Serializable {
    String titulo;
    String autor;
    String isbn;
    boolean disponivel = true;

    Livro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return String.format("%s - %s (%s) - %s", titulo, autor, isbn, disponivel ? "Disponível" : "Emprestado");
    }
}

class Usuario implements Serializable {
    String nome;
    int id;
    List<Livro> livrosEmprestados = new ArrayList<>();

    Usuario(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    @Override
    public String toString() {
        return nome + " (ID: " + id + ")";
    }
}

public class Biblioteca implements Serializable {
    List<Livro> livros = new ArrayList<>();
    List<Usuario> usuarios = new ArrayList<>();

    void cadastrarLivro(Livro livro) {
        livros.add(livro);
    }

    void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    void emprestarLivro(String isbn, int idUsuario) {
        Optional<Livro> livroOpt = livros.stream().filter(l -> l.isbn.equals(isbn) && l.disponivel).findFirst();
        Optional<Usuario> usuarioOpt = usuarios.stream().filter(u -> u.id == idUsuario).findFirst();

        if (livroOpt.isPresent() && usuarioOpt.isPresent()) {
            Livro livro = livroOpt.get();
            Usuario usuario = usuarioOpt.get();
            livro.disponivel = false;
            usuario.livrosEmprestados.add(livro);
            System.out.println("Livro emprestado com sucesso!");
        } else {
            System.out.println("Livro não disponível ou usuário não encontrado.");
        }
    }

    void devolverLivro(String isbn, int idUsuario) {
        Usuario usuario = usuarios.stream().filter(u -> u.id == idUsuario).findFirst().orElse(null);
        if (usuario != null) {
            Livro livro = usuario.livrosEmprestados.stream().filter(l -> l.isbn.equals(isbn)).findFirst().orElse(null);
            if (livro != null) {
                livro.disponivel = true;
                usuario.livrosEmprestados.remove(livro);
                System.out.println("Livro devolvido com sucesso!");
                return;
            }
        }
        System.out.println("Erro ao devolver livro.");
    }

    void listarLivros() {
        livros.forEach(System.out::println);
    }

    void listarEmprestimos() {
        for (Usuario usuario : usuarios) {
            System.out.println(usuario + ":");
            usuario.livrosEmprestados.forEach(l -> System.out.println("  - " + l));
        }
    }

    void salvarDados(String caminho) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminho))) {
            oos.writeObject(this);
        }
    }

    static Biblioteca carregarDados(String caminho) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminho))) {
            return (Biblioteca) ois.readObject();
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca;
        File file = new File("biblioteca.dat");

        if (file.exists()) {
            biblioteca = carregarDados("biblioteca.dat");
        } else {
            biblioteca = new Biblioteca();
        }

        while (true) {
            System.out.println("\n1. Cadastrar Livro\n2. Cadastrar Usuário\n3. Emprestar Livro\n4. Devolver Livro\n5. Listar Livros\n6. Ver Empréstimos\n7. Salvar e Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                System.out.print("Título: "); String titulo = scanner.nextLine();
                System.out.print("Autor: "); String autor = scanner.nextLine();
                System.out.print("ISBN: "); String isbn = scanner.nextLine();
                biblioteca.cadastrarLivro(new Livro(titulo, autor, isbn));
            } else if (opcao == 2) {
                System.out.print("Nome: "); String nome = scanner.nextLine();
                System.out.print("ID: "); int id = scanner.nextInt();
                scanner.nextLine();
                biblioteca.cadastrarUsuario(new Usuario(nome, id));
            } else if (opcao == 3) {
                System.out.print("ISBN do livro: "); String isbn = scanner.nextLine();
                System.out.print("ID do usuário: "); int id = scanner.nextInt();
                scanner.nextLine();
                biblioteca.emprestarLivro(isbn, id);
            } else if (opcao == 4) {
                System.out.print("ISBN do livro: "); String isbn = scanner.nextLine();
                System.out.print("ID do usuário: "); int id = scanner.nextInt();
                scanner.nextLine();
                biblioteca.devolverLivro(isbn, id);
            } else if (opcao == 5) {
                biblioteca.listarLivros();
            } else if (opcao == 6) {
                biblioteca.listarEmprestimos();
            } else if (opcao == 7) {
                biblioteca.salvarDados("biblioteca.dat");
                break;
            }
        }
        scanner.close();
    }
}
