import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            // Caminhos dos arquivos
            String[] filePaths = {
                "/home/glm/Workspace/desafio-parte-2/USA-road-d.NY.gr",
                "/home/glm/Workspace/desafio-parte-2/USA-road-d.COL.gr",
                "/home/glm/Workspace/desafio-parte-2/USA-road-d.BAY.gr"
            };

            System.out.println("Carregando os grafos dos arquivos:");
            System.out.println();
            System.out.println("|--------------------|-----------|-----------|-------------|-------------|-------------|-------------|-------------|-------------|");
            System.out.printf("| %-18s | %-9s | %-9s | %-12s | %-12s | %-12s | %-12s | %-12s | %-12s |%n",
                              "Grafo", "Vértices", "Arestas", "Custo_CM", "Tempo_CM", "Custo_AGM", "Tempo_AGM", "Custo_FM", "Tempo_FM");
            System.out.println("|--------------------|-----------|-----------|-------------|-------------|-------------|-------------|-------------|-------------|");

            for (String filePath : filePaths) {                
                Graph grafo = Graph.carregarGrafoDoArquivo(filePath);

                // Número de vértices e arestas
                int numVertices = grafo.getNumVertices();
                int numArestas = grafo.getNumArestas();

                // Executar Dijkstra para o Caminho Mínimo (CM)
                long startTimeDijkstra = System.nanoTime();
                int custoDijkstra = Dijkstra.calcularCaminhoMinimo(grafo, 0);
                long endTimeDijkstra = System.nanoTime();
                double tempoDijkstra = (endTimeDijkstra - startTimeDijkstra) / 1_000_000_000.0;

                // Executar Kruskal para a Árvore Geradora Mínima (AGM)
                long startTimeKruskal = System.nanoTime();
                int custoKruskal = Kruskal.calcularArvoreGeradoraMinima(grafo);
                long endTimeKruskal = System.nanoTime();
                double tempoKruskal = (endTimeKruskal - startTimeKruskal) / 1_000_000_000.0;

                // Executar Prim para a Árvore Geradora Mínima (AGM)
                long startTimePrim = System.nanoTime();
                int custoPrim = Prim.calcularArvoreGeradoraMinima(grafo, 0);
                long endTimePrim = System.nanoTime();
                double tempoPrim = (endTimePrim - startTimePrim) / 1_000_000_000.0;

                // Nome do grafo (extraído do caminho do arquivo)
                String grafoNome = filePath.substring(filePath.lastIndexOf('/') + 1);

                // Exibir linha da tabela com resultados formatados
                System.out.printf("| %-18s | %-9d | %-9d | %-12d | %-12.4f | %-12d | %-12.4f | %-12d | %-12.4f |%n",
                                  grafoNome, numVertices, numArestas, custoDijkstra, tempoDijkstra, custoKruskal, tempoKruskal, custoPrim, tempoPrim);
            }

            System.out.println("|--------------------|-----------|-----------|-------------|-------------|-------------|-------------|-------------|-------------|");

        } catch (IOException e) {
            System.err.println("Erro ao carregar o grafo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
