import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Graph {
    private int numVertices;
    private int numArestas;
    private List<List<Edge>> adjList;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        this.numArestas = 0;
        adjList = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public int getNumVertices() {
        return numVertices;
    }

    public int getNumArestas() {
        return numArestas;
    }

    public void addEdge(int origem, int destino, int peso) {
        adjList.get(origem).add(new Edge(destino, peso));
        adjList.get(destino).add(new Edge(origem, peso));
        numArestas++;
    }

    public List<Edge> getAdjacentes(int vertice) {
        return adjList.get(vertice);
    }

    public static Graph carregarGrafoDoArquivo(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        Graph graph = null;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("p")) {
                String[] parts = line.split(" ");
                int numVertices = Integer.parseInt(parts[2]);
                graph = new Graph(numVertices);
            } else if (line.startsWith("a")) {
                String[] parts = line.split(" ");
                int origem = Integer.parseInt(parts[1]) - 1;
                int destino = Integer.parseInt(parts[2]) - 1;
                int peso = Integer.parseInt(parts[3]);
                graph.addEdge(origem, destino, peso);
            }
        }
        reader.close();
        return graph;
    }

    public static class Edge {
        int destino;
        int peso;

        public Edge(int destino, int peso) {
            this.destino = destino;
            this.peso = peso;
        }

        public int getDestino() {
            return destino;
        }

        public int getPeso() {
            return peso;
        }
    }
}
