public class CircularLinkedListDemo {
    public static void main(String args[]) {
        CircularLinkedList list = new CircularLinkedList();

        list.insertFirst(1, 10);
        list.insertFirst(2, 20);
        list.insertFirst(3, 30);
        list.insertFirst(4, 1);
        list.insertFirst(5, 40);
        list.insertFirst(6, 56);

        System.out.print("\nOriginal List: ");
        list.display();
        System.out.println("");
        while (!list.isEmpty()) {
            Link temp = list.deleteFirst();
            System.out.print("Deleted value:");
            temp.display();
            System.out.println("");
        }
        System.out.print("List after deleting all items: ");
        list.display();
        System.out.println("");
    }
}