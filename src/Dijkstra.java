import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {

    public static int calcularCaminhoMinimo(Graph grafo, int origem) {
        int numVertices = grafo.getNumVertices();
        int[] dist = new int[numVertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[origem] = 0;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        minHeap.add(new int[]{origem, 0});

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int u = current[0];
            int currentDist = current[1];

            if (currentDist > dist[u]) continue;

            for (Graph.Edge edge : grafo.getAdjacentes(u)) {
                int v = edge.getDestino();
                int peso = edge.getPeso();

                if (dist[u] + peso < dist[v]) {
                    dist[v] = dist[u] + peso;
                    minHeap.add(new int[]{v, dist[v]});
                }
            }
        }

        // Soma das distâncias do vértice de origem para todos os outros (para fins de custo total)
        int totalCost = 0;
        for (int d : dist) {
            if (d != Integer.MAX_VALUE) totalCost += d;
        }
        return totalCost;
    }
}
