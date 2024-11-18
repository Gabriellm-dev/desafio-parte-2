import java.util.PriorityQueue;

public class Prim {

    public static int calcularArvoreGeradoraMinima(Graph grafo, int origem) {
        boolean[] visitado = new boolean[grafo.getNumVertices()];
        PriorityQueue<Graph.Edge> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.getPeso(), b.getPeso()));
        int totalCost = 0;

        visitado[origem] = true;
        minHeap.addAll(grafo.getAdjacentes(origem));

        while (!minHeap.isEmpty()) {
            Graph.Edge edge = minHeap.poll();
            int v = edge.getDestino();

            if (!visitado[v]) {
                visitado[v] = true;
                totalCost += edge.getPeso();

                for (Graph.Edge adjEdge : grafo.getAdjacentes(v)) {
                    if (!visitado[adjEdge.getDestino()]) {
                        minHeap.add(adjEdge);
                    }
                }
            }
        }

        return totalCost;
    }
}
