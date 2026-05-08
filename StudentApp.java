public class StudentApp {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        list.insertFirst(101, 75);
        list.insertFirst(102, 85);
        list.insertFirst(103, 65);

        System.out.println("Initial List:");
        list.displayList();

        list.insertAfter(102, 104, 90);

        System.out.println("\nAfter InsertAfter:");
        list.displayList();

        System.out.println("\nFind student 101:");
        Link found = list.find(101);
        if (found != null) found.displayLink();

        System.out.println("\nDelete first:");
        list.deleteFirst();
        list.displayList();

        System.out.println("\nDelete student 104:");
        list.delete(104);
        list.displayList();
    }
}