package domain;

public class Graph {
    private int vertex; // vertices
    private int edge; // arcos
    private int[][] adjacencyMatrix; // adjacencias
    public int getVertex() {
        return vertex;
    }
    public void setVertex(int vertex) {
        this.vertex = vertex;
    }
    public int getEdge() {
        return edge;
    }
    public void setEdge(int edge) {
        this.edge = edge;
    }
    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }
    public void setAdjacencyMatrix(int[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
    }
    public Graph(int vertex) {
        this.vertex = vertex;
        this.edge = 0;
        this.adjacencyMatrix = new int[vertex][vertex];
        for(int i = 0; i < vertex; i++) {
            for(int j = 0; j < vertex; j++) {
                this.adjacencyMatrix[i][j] = 0;
            }
        }
    }

    public Graph() {
    }
}
