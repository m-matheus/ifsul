import domain.LinkedList;
import domain.Node;

public class App {
    public static void main(String[] args) throws Exception {
        
        LinkedList list1 = new LinkedList();
        list1.add(5);
        list1.add(20);
        list1.add(8);
        list1.add(7);
        
        LinkedList list2 = new LinkedList();
        list2.add(10);
        list2.add(20);

        LinkedList list3 = new LinkedList();
        list3.add(19);        
        list3.add(22);        
        list3.add(50);

        LinkedList list4 = new LinkedList();
        list4.add(28);
        list4.add(35);
        list4.add(40);
        list4.add(45);

        Node nodeToDelete = list1.get(1);
        list1.deleteWithoutTraversing(nodeToDelete);

        list1.orderByAsc();
        
        System.out.println("Linked Lists:");
        System.out.println("List 1:");
        list1.printList(list1);
        System.out.println("List 2:");
        list2.printList(list2);
        System.out.println("List 3:");
        list3.printList(list3);
        System.out.println("List 4:");
        list4.printList(list4);
        System.out.println();

        // LinkedList listOfnodes = new LinkedList();
        // listOfnodes.addNode(list1);
        // listOfnodes.addNode(list2);
        // listOfnodes.addNode(list3);
        // listOfnodes.addNode(list4);

        // System.out.println("List of Nodes:");
        // listOfnodes.printNodeOfNodes(listOfnodes);
        // System.out.println();

        // listOfnodes.flatening();
        // System.out.println("Flattened List:");
        // listOfnodes.printFlattenedList();

        System.out.println("Get previous node:");
        Node node = list2.get(1);
        System.out.println(list2.getPreviousNode(node));
    }
}
