import domain.Graph;
import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        Graph graph = new Graph(5);

        graph.getAdjacencyMatrix()[0][1] = 1;
        graph.getAdjacencyMatrix()[0][2] = 1;
        graph.getAdjacencyMatrix()[1][3] = 1;
        graph.getAdjacencyMatrix()[2][4] = 1;
        graph.getAdjacencyMatrix()[3][4] = 1;

        int startVertex = 0;
        int valueToFind = 4;
        List<Integer> dfsPath = graph.depthFirstSearch(startVertex, valueToFind);
        System.out.println("DFS Path: " + dfsPath);

        List<Integer> bfsPath = graph.breadthFirstSearch(startVertex, valueToFind);
        System.out.println("BFS Path: " + bfsPath);
    }
}
