import java.util.List;

import domain.Node;
import domain.NodeOfNodes;

public class App {
    public static void main(String[] args) throws Exception {
        
        Node node1 = new Node(5);
        node1.add(7);
        node1.add(8);
        node1.add(20);
        
        Node node2 = new Node(10);
        node2.add(20);

        Node node3 = new Node(19);
        node3.add(22);        
        node3.add(50);

        Node node4 = new Node(28);
        node4.add(35);
        node4.add(40);
        node4.add(45);

        System.out.println("Node 1:");
        node1.printList(node1);
        System.out.println("Node 2:");
        node2.printList(node2);
        System.out.println("Node 3:");
        node3.printList(node3);
        System.out.println("Node 4:");
        node4.printList(node4);
        System.out.println();

        NodeOfNodes nodeOfNodes = new NodeOfNodes(node1);
        nodeOfNodes.addNode(node2);
        nodeOfNodes.addNode(node3);
        nodeOfNodes.addNode(node4);

        System.out.println("Node of Nodes:");
        nodeOfNodes.printListOfNodeOfNodes(nodeOfNodes);
        System.out.println();

        List<Node> flatList = nodeOfNodes.flatening(nodeOfNodes);
        System.out.println("Flatened List:");
        nodeOfNodes.printFlatenedList(flatList);
    }
}
