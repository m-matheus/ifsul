package domain;


public class LinkedList {
    private Node head;
    private NodeOfNodes headOfNodes;

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(new Node(data));
        }
    }
    
    public void printList(LinkedList list) {
        Node current = list.head;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }

    public void deleteData(Node pos) {
        if (head == null || pos == null) {
            return;
        }
        if (pos == head) {
            head = head.getNext();
            return;
        }
        Node current = head;
        while (current.getNext() != null && current.getNext() != pos) {
            current = current.getNext();
        }
        if (current.getNext() == pos) {
            current.setNext(pos.getNext());
        }
    }

    public void deleteWithoutTraversing(Node pos) {
        if (pos == null || pos.getNext() == null) {
            throw new IllegalArgumentException("Cannot delete the last node or a null node.");
        }
        Node nextNode = pos.getNext();
        pos.setData(nextNode.getData());
        pos.setNext(nextNode.getNext());
    }

    public void orderByAsc() {
        if (head == null || head.getNext() == null) {
            return;
        }
    
        boolean wasChanged;
        do {
            Node current = head;
            Node previous = null;
            wasChanged = false;
    
            while (current != null && current.getNext() != null) {
                Node next = current.getNext();
                if (current.getData() > next.getData()) {
                    wasChanged = true;
                    
                    if (previous == null) {
                        current.setNext(next.getNext());
                        next.setNext(current);
                        head = next;
                        previous = next;
                    } else {
                        previous.setNext(next);
                        current.setNext(next.getNext());
                        next.setNext(current);
                        previous = next;
                    }
                } else {
                    previous = current;
                    current = current.getNext();
                }
            }
        } while (wasChanged);
    }

    public Node get(int index) {
        if (index < 0 || index >= this.size()) {
            return null;
        }
        Node current = head;
        int count = 0;    
        while (current != null) {
            if (count == index) {
                return current;
            }
            count++;
            current = current.getNext();
        }
        return null;
    }
    
    public int size() {
        int size = 0;
        Node current = head;
        while (current != null) {
            size++;
            current = current.getNext();
        }
        return size;
    }

    public void addNode(LinkedList data) {
        NodeOfNodes newNode = new NodeOfNodes(data);
        if(headOfNodes == null) {
            headOfNodes = newNode;
        } else {
            NodeOfNodes current = headOfNodes;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(new NodeOfNodes(data));
        }
    }

    public void printNodeOfNodes(LinkedList listOfNodes) {
        if (listOfNodes == null || listOfNodes.headOfNodes == null) {
            System.out.println("List is empty or null.");
            return;
        }
        NodeOfNodes current = listOfNodes.headOfNodes;
        while (current != null) {
            LinkedList list = current.getData();
            if (list != null && list.head != null) {
                Node currentList = list.head;
                while (currentList != null) {
                    System.out.println(currentList.getData());
                    currentList = currentList.getNext();
                }
            } else {
                System.out.println("Sub-list is empty or null.");
            }
            current = current.getNext();
        }
    }

    public LinkedList flatening() {
        if (headOfNodes == null) {
            return new LinkedList();
        }
        LinkedList flattenedList = new LinkedList();
        NodeOfNodes current = headOfNodes;
        while (current != null) {
            LinkedList list = current.getData();
            if (list != null && list.head != null) {
                Node currentList = list.head;
                while (currentList != null) {
                    flattenedList.add(currentList.getData());
                    currentList = currentList.getNext();
                }
            }
            current = current.getNext();
        }
        return flattenedList;
    }

    public void printFlattenedList() {
        LinkedList flattenedList = flatening();
        if (flattenedList.head == null) {
            System.out.println("A lista achatada está vazia.");
            return;
        }
        Node current = flattenedList.head;
        while (current != null) {
            // Passo 4: Imprimir o valor do nó atual
            System.out.println(current.getData());
            // Avançar para o próximo nó
            current = current.getNext();
        }
    }
}
