import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {

    public static int calcularArvoreGeradoraMinima(Graph grafo) {
        List<Edge> arestas = new ArrayList<>();
        for (int u = 0; u < grafo.getNumVertices(); u++) {
            for (Graph.Edge edge : grafo.getAdjacentes(u)) {
                arestas.add(new Edge(u, edge.getDestino(), edge.getPeso()));
            }
        }

        Collections.sort(arestas);

        UnionFind uf = new UnionFind(grafo.getNumVertices());
        int totalCost = 0;

        for (Edge edge : arestas) {
            if (uf.union(edge.origem, edge.destino)) {
                totalCost += edge.peso;
            }
        }

        return totalCost;
    }

    private static class Edge implements Comparable<Edge> {
        int origem, destino, peso;

        public Edge(int origem, int destino, int peso) {
            this.origem = origem;
            this.destino = destino;
            this.peso = peso;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.peso, o.peso);
        }
    }

    private static class UnionFind {
        int[] parent, rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int u) {
            if (parent[u] != u) parent[u] = find(parent[u]);
            return parent[u];
        }

        public boolean union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);

            if (rootU == rootV) return false;

            if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
            return true;
        }
    }
}
