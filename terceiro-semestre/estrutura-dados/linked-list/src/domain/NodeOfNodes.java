package domain;

import java.util.ArrayList;
import java.util.List;

public class NodeOfNodes {
    private Node data;
    private NodeOfNodes next;

    public Node getData() {
        return data;
    }

    public void setData(Node data) {
        this.data = data;
    }

    public NodeOfNodes getNext() {
        return next;
    }

    public void setNext(NodeOfNodes next) {
        this.next = next;
    }

    public NodeOfNodes(Node data) {
        this.data = data;
    }

    public void addNode(Node data) {
        NodeOfNodes newNode = new NodeOfNodes(data);
        NodeOfNodes current = this;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void printListOfNodeOfNodes(NodeOfNodes nodeOfNodes) {
        NodeOfNodes current = nodeOfNodes;
        while (current != null) {
            Node node = current.getData();
            while (node != null) {
                System.out.println(node);
                node = node.getNext();
            }
            current = current.getNext();
        }
    }

    public List<Node> flatening(NodeOfNodes nodeOfNodes) {
        List<Node> resultList = new ArrayList<>();
        NodeOfNodes current = nodeOfNodes;
        while (current != null) {
            Node node = current.getData();
            while (node != null) {
                resultList.add(node);
                node = node.getNext();
            }
            current = current.getNext();
        }
        return resultList;
    }

    public void printFlatenedList(List<Node> nodeList) {
        for (Node node : nodeList) {
            System.out.println(node);
        }
    }
}