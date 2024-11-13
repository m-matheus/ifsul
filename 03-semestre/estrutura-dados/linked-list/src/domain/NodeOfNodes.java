package domain;

public class NodeOfNodes {
    private LinkedList data;
    private NodeOfNodes next;

    public LinkedList getData() {
        return data;
    }

    public void setData(LinkedList data) {
        this.data = data;
    }

    public NodeOfNodes getNext() {
        return next;
    }

    public void setNext(NodeOfNodes next) {
        this.next = next;
    }

    public NodeOfNodes(LinkedList data) {
        this.data = data;
    }
}