class LinkedList {
    private Link first;

    public LinkedList() {
        first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    // Insert at beginning
    public void insertFirst(int id, int marks) {
        Link newLink = new Link(id, marks);
        newLink.next = first;
        first = newLink;
    }

    // Insert after specific node
    public boolean insertAfter(int key, int id, int marks) {
        Link current = first;

        while (current != null) {
            if (current.studentId == key) {
                Link newLink = new Link(id, marks);
                newLink.next = current.next;
                current.next = newLink;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Find node
    public Link find(int key) {
        Link current = first;

        while (current != null) {
            if (current.studentId == key) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Delete first
    public Link deleteFirst() {
        if (isEmpty()) return null;
        Link temp = first;
        first = first.next;
        return temp;
    }

    // Delete by key
    public Link delete(int key) {
        if (isEmpty()) return null;

        Link current = first;
        Link previous = null;

        while (current != null) {
            if (current.studentId == key) {

                if (current == first) {
                    first = first.next;
                } else {
                    previous.next = current.next;
                }
                return current;
            }
            previous = current;
            current = current.next;
        }
        return null;
    }

    // Display list
    public void displayList() {
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
    }
}