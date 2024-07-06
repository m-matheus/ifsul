import domain.BinaryTree;

public class App {
    // Método principal para testar a busca em profundidade em pós-ordem
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.add(1);
        bt.add(2, 1);
        bt.add(3, 1);
        bt.add(4, 2);
        bt.add(5, 3);
        bt.add(6, 3);
        bt.add(7, 5);
        bt.add(8, 5);
        
        System.out.println("Depth-First Search Post-Order:");
        bt.dfsPostOrder();
    }
}
