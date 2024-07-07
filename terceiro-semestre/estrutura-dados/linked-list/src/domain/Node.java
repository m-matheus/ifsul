package domain;

public class Node {
    private int data;
    private Node next;
    
    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }

    public Node(int data) {
        this.data = data;
    }

    public void add(int data) {
        Node newNode = new Node(data);
        Node current = this;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }
    
    public void printList(Node node) {
        Node current = node;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
