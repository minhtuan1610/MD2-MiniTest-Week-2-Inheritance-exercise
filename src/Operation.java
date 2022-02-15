public class Operation {
    public static Book[] programmingBooks = new ProgrammingBook[5];
    public static Book[] fictionBooks = new FictionBook[5];

    public static void main(String[] args) {
        programmingBooks[0] = new ProgrammingBook("p1", "Basic Java", 10, "author1", "Java", "what");
        programmingBooks[1] = new ProgrammingBook("p2", "Advanced Java", 11, "author2", "Java", "when");
        programmingBooks[2] = new ProgrammingBook();
    }
}
