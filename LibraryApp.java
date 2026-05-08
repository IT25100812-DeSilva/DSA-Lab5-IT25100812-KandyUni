public class LibraryApp {

    // ===== Node Class =====
    static class BookLink {
        int bookID;
        String title;
        int copies;
        BookLink next;

        BookLink(int id, String title, int copies) {
            this.bookID = id;
            this.title = title;
            this.copies = copies;
            this.next = null;
        }

        void display() {
            System.out.println("ID: " + bookID + ", Title: " + title + ", Copies: " + copies);
        }
    }

    // ===== Linked List Class =====
    static class LibraryList {
        private BookLink first;

        public boolean isEmpty() {
            return first == null;
        }

        // Insert at beginning
        public void insertFirst(int id, String title, int copies) {
            BookLink newBook = new BookLink(id, title, copies);
            newBook.next = first;
            first = newBook;
        }

        // Insert after a key
        public boolean insertAfter(int key, int id, String title, int copies) {
            BookLink current = first;

            while (current != null) {
                if (current.bookID == key) {
                    BookLink newBook = new BookLink(id, title, copies);
                    newBook.next = current.next;
                    current.next = newBook;
                    return true;
                }
                current = current.next;
            }
            return false;
        }

        // Find
        public BookLink find(int key) {
            BookLink current = first;

            while (current != null) {
                if (current.bookID == key) return current;
                current = current.next;
            }
            return null;
        }

        // Delete first
        public BookLink deleteFirst() {
            if (isEmpty()) return null;
            BookLink temp = first;
            first = first.next;
            return temp;
        }

        // Delete by key
        public BookLink delete(int key) {
            if (isEmpty()) return null;

            BookLink current = first;
            BookLink previous = null;

            while (current != null) {
                if (current.bookID == key) {
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

        // Display all books
        public void displayBooks() {
            BookLink current = first;
            while (current != null) {
                current.display();
                current = current.next;
            }
        }
    }

    // ===== Main Method =====
    public static void main(String[] args) {

        LibraryList library = new LibraryList();

        // i. Insert initial books
        library.insertFirst(1, "Java Programming", 5);
        library.insertFirst(2, "Data Structures", 3);
        library.insertFirst(3, "Algorithms", 4);

        System.out.println("Initial Books:");
        library.displayBooks();

        // ii. Insert after a book
        library.insertAfter(2, 4, "Database Systems", 2);

        System.out.println("\nAfter InsertAfter:");
        library.displayBooks();

        // iii. Find book
        System.out.println("\nFind Book ID 1:");
        BookLink found = library.find(1);
        if (found != null) found.display();

        // iv. Delete a book
        System.out.println("\nDelete Book ID 4:");
        library.delete(4);
        library.displayBooks();

        // v. Delete first book
        System.out.println("\nDelete First Book:");
        library.deleteFirst();
        library.displayBooks();

        // vi. Final list
        System.out.println("\nFinal Book List:");
        library.displayBooks();
    }
}