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

    public boolean deleteData(Node pos) {
        if (pos == null || pos.getNext() == null) {
            return false; 
        }
        pos.setData(pos.getNext().getData());
        pos.setNext(pos.getNext().getNext());
        return true;
    }

    // NODEOFNODES

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
        // Passo 1: Obter a lista achatada
        LinkedList flattenedList = flatening();
    
        // Passo 2: Verificar se a lista está vazia
        if (flattenedList.head == null) {
            System.out.println("A lista achatada está vazia.");
            return;
        }
    
        // Passo 3: Percorrer a lista achatada e imprimir cada elemento
        Node current = flattenedList.head;
        while (current != null) {
            // Passo 4: Imprimir o valor do nó atual
            System.out.println(current.getData());
            // Avançar para o próximo nó
            current = current.getNext();
        }
    }
}
