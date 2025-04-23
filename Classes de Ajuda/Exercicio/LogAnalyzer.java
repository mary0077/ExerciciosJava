import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.*;

public class LogAnalyzer {
    private Map<String, List<LocalDateTime>> acessosPorUsuario = new HashMap<>();
    private DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    public void carregarAcessos(String caminhoArquivo) throws IOException {
        List<String> linhas = Files.readAllLines(Paths.get(caminhoArquivo));

        for (String linha : linhas) {
            String[] partes = linha.split("\\s+");
            if (partes.length == 2) {
                String usuario = partes[0];
                LocalDateTime dataHora = LocalDateTime.parse(partes[1], formatter);
                acessosPorUsuario.computeIfAbsent(usuario, k -> new ArrayList<>()).add(dataHora);
            }
        }
    }

    public String usuarioMaisAtivo() {
        return acessosPorUsuario.entrySet()
                .stream()
                .max(Comparator.comparingInt(e -> e.getValue().size()))
                .map(Map.Entry::getKey)
                .orElse("Nenhum usuário encontrado");
    }

    public Map<LocalDate, Long> acessosPorDia() {
        return acessosPorUsuario.values()
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(LocalDateTime::toLocalDate, Collectors.counting()));
    }

    public void salvarResumo(String caminhoSaida) throws IOException {
        StringBuilder resumo = new StringBuilder();
        resumo.append("Usuário mais ativo: ").append(usuarioMaisAtivo()).append("\n\n");
        resumo.append("Acessos por dia:\n");

        for (Map.Entry<LocalDate, Long> entry : acessosPorDia().entrySet()) {
            resumo.append(entry.getKey()).append(" - ").append(entry.getValue()).append(" acessos\n");
        }

        Files.write(Paths.get(caminhoSaida), resumo.toString().getBytes());
    }

    public static void main(String[] args) {
        LogAnalyzer analyzer = new LogAnalyzer();
        try {
            analyzer.carregarAcessos("acessos.txt");
            analyzer.salvarResumo("resumo.txt");
            System.out.println("Resumo gerado com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
        }
    }
}  
