class Link {
    public int studentId;
    public int marks;
    public Link next;

    public Link(int id, int marks) {
        this.studentId = id;
        this.marks = marks;
        this.next = null;
    }

    public void displayLink() {
        System.out.println("ID: " + studentId + ", Marks: " + marks);
    }
}