package domain;

public class BinaryTree {
    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    // Método para iniciar a busca em profundidade em pós-ordem
    public void dfsPostOrder() {
        dfsPostOrder(this.root);
    }

    // Método recursivo para busca em profundidade em pós-ordem
    private void dfsPostOrder(Node node) {
        if (node != null) {
            dfsPostOrder(node.getLeft()); // Visita o filho à esquerda
            dfsPostOrder(node.getRight()); // Visita o filho à direita
            System.out.println(node.getData()); // Visita o nó atual
        }
    }

    // Método para adicionar elementos (simplificado para focar na DFS)
    public void add(int data) {
        this.root = addRecursive(this.root, data, null);
    }

    private Node addRecursive(Node current, int data, Node parent) {
        if (current == null) {
            Node newNode = new Node(data);
            if(parent != null) {
                newNode.setParent(parent);
            }
            return newNode;
        }

        if (data < current.getData()) {
            current.setLeft(addRecursive(current.getLeft(), data, current));
        } else if (data > current.getData()) {
            current.setRight(addRecursive(current.getRight(), data, current));
        }
        return current;
    }

    // Overloaded add method to specify parent
    public void add(int data, int parentData) {
        Node parentNode = findNode(this.root, parentData);
        if (parentNode != null) {
            if (parentNode.getLeft() == null) {
                parentNode.setLeft(new Node(data));
            } else if (parentNode.getRight() == null) {
                parentNode.setRight(new Node(data));
            } else {
                System.out.println("Parent node already has two children.");
            }
        } else {
            System.out.println("Parent node not found");
        }
    }

    // Method to find a node by its data
    private Node findNode(Node current, int data) {
        if (current == null) {
            return null;
        }
        if (data == current.getData()) {
            return current;
        }
        Node leftFound = findNode(current.getLeft(), data);
        if (leftFound != null) {
            return leftFound;
        }
        return findNode(current.getRight(), data);
    }

}