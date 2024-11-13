package domain;

import java.util.*;

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

    public List<Integer> depthFirstSearch(int startVertex, int value) {
        boolean[] visited = new boolean[vertex];
        Stack<Integer> stack = new Stack<>();
        List<Integer> path = new ArrayList<>();

        stack.push(startVertex);
        visited[startVertex] = true;

        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();
            path.add(currentVertex);

            if (currentVertex == value) {
                return path;
            }

            for (int i = 0; i < vertex; i++) {
                if (adjacencyMatrix[currentVertex][i] != 0 && !visited[i]) {
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
        return path;
    }

    public List<Integer> breadthFirstSearch(int startVertex, int value) {
        boolean[] visited = new boolean[vertex];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> path = new ArrayList<>();

        queue.add(startVertex);
        visited[startVertex] = true;

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            path.add(currentVertex);

            if (currentVertex == value) {
                return path;
            }

            for (int i = 0; i < vertex; i++) {
                if (adjacencyMatrix[currentVertex][i] != 0 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        return path;
    }
}
