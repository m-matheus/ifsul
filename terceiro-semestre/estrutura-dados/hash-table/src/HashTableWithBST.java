import java.util.*;

class TreeNode {
    int key;
    TreeNode left, right;

    public TreeNode(int key) {
        this.key = key;
        left = right = null;
    }
}

class BinarySearchTree {
    TreeNode root;

    public void insert(int key) {
        root = insertRec(root, key);
    }

    private TreeNode insertRec(TreeNode root, int key) {
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }

        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    public void inorderTraversal() {
        inorderRec(root);
    }

    private void inorderRec(TreeNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }
}

class HashTable {
    private final int SIZE = 5;
    private BinarySearchTree[] table;

    public HashTable() {
        table = new BinarySearchTree[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new BinarySearchTree();
        }
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void insert(int key) {
        int index = hash(key);
        table[index].insert(key);
    }

    public void display() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print("Index " + i + ": ");
            table[i].inorderTraversal();
            System.out.println();
        }
    }
}

public class HashTableWithBST {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();

        int[] keys = {9, 10, 6, 20, 14, 16, 5, 40, 4, 2, 7, 3, 8};

        for (int key : keys) {
            hashTable.insert(key);
        }

        hashTable.display();
    }
}


// Vantagens de usar uma BST em vez de uma lista encadeada:
// 1. A BST mantém os elementos ordenados, enquanto a lista encadeada não.
// 2. Busca mais eficiente em uma BST, pois a complexidade é O(h), onde h é a altura da árvore.
// 3. A inserção e exclusão de elementos em uma BST são mais eficientes do que em uma lista encadeada.
