import java.util.Scanner;

public class Operation {
    public static Book[] listBooks = new Book[10];

    public static void main(String[] args) {
        //  05 Programming Books
        listBooks[0] = new ProgrammingBook("p1", "Basic Java", 10, "author1", "Java", "what");
        listBooks[1] = new ProgrammingBook("p2", "Advanced Java", 11, "author2", "Java", "when");
        listBooks[2] = new ProgrammingBook("p3", "Introduce to Java", 12, "author3", "Java", "why");
        listBooks[3] = new ProgrammingBook("p4", "Introduce to PHP", 13, "author4", "PHP", "who");
        listBooks[4] = new ProgrammingBook("p5", "Python", 14, "author5", "Python", "how");

        //  05 Fiction Books
        listBooks[5] = new FictionBook("f1", "Batman", 150, "author6", "Viễn tưởng 1");
        listBooks[6] = new FictionBook("f2", "Superman", 160, "author7", "Viễn tưởng 1");
        listBooks[7] = new FictionBook("f3", "Spider-man", 170, "author8", "Viễn tưởng 1");
        listBooks[8] = new FictionBook("f4", "Ngu quai Sai Gon", 18, "Bui Chi Vinh", "Thiếu nhi");
        listBooks[9] = new FictionBook("f5", "Viec lang", 19, "Ngo Tat To", "Phóng sự");

        //  Tính tổng số tiền của 10 cuốn sách
        int totalPrice = getTotalPrice(listBooks);
        System.out.println("Tổng số tiền của 10 cuốn sách là: " + totalPrice);
        //  Đếm số sách Programming Books có language là "Java"
        int numberOfBookByLanguage = countProgrammingBooksByLanguage(listBooks, "Java");
        System.out.println("Số lượng sách Programming Books về ngôn ngữ Java là: " + numberOfBookByLanguage);

        //  Đếm số sách Fiction Books có category là "Viễn tưởng 1"
        int numberOfBookByCategory = countFictionBooksByCategory(listBooks, "Viễn tưởng 1");
        System.out.println("Số lượng sách Fiction Books thuộc thể loại 'Viễn tưởng 1' là: " + numberOfBookByCategory);

        //  Đếm số sách Fiction Books có giá nhỏ hơn 100
        int numberOfBookByPrice = countFictionBooksByPrice(listBooks, 100);
        System.out.println("Số lượng sách Fiction Books có giá nhỏ hơn 100 là: " + numberOfBookByPrice);
        //  Tìm kiếm giá của cuốn sách có tên được nhập vào từ bàn phím
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên sách muốn tìm (không dấu):");
        String inputBookName = scanner.nextLine();
        checkBook(inputBookName);
    }

    //  Tính tổng số tiền của 10 cuốn sách
    public static int getTotalPrice(Book[] books) {
        int totalPrice = 0;
        for (Book i : books
        ) {
            totalPrice += i.getPrice();
        }
        return totalPrice;
    }

    //  Đếm số sách Programming Books có language là "Java"
    public static int countProgrammingBooksByLanguage(Book[] books, String requiredLanguage) {
        int count = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] instanceof ProgrammingBook) {
                String languageOfBook = ((ProgrammingBook) books[i]).getLanguage();
                if (languageOfBook.equals(requiredLanguage)) {
                    count++;
                }
            }
        }
        return count;
    }

    //  Đếm số sách Fiction Books có category là "Viễn tưởng 1"
    public static int countFictionBooksByCategory(Book[] books, String requiredCategory) {
        int count = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] instanceof FictionBook) {
                String categoryOfBook = ((FictionBook) books[i]).getCategory();
                if (categoryOfBook.equals(requiredCategory)) {
                    count++;
                }
            }
        }
        return count;
    }

    //  Đếm số sách Fiction Books có giá nhỏ hơn 100
    public static int countFictionBooksByPrice(Book[] books, double requiredPrice) {
        int count = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] instanceof FictionBook) {
                double priceOfBook = books[i].getPrice();
                if (priceOfBook < requiredPrice) {
                    count++;
                }
            }
        }
        return count;
    }

    //  Tìm kiếm giá của cuốn sách có tên được nhập vào từ bàn phím
    public static int searchBook(Book[] books, String inputBookName) {
        int index = -1;
        for (int i = 0; i < books.length; i++) {
            String bookName = books[i].getName();
            if (inputBookName.equals(bookName)) {
                index = i;
            }
        }
        return index;
    }

    public static double getPriceOfSelectionBook(Book[] books, int index) {
        double bookPrice = books[index].getPrice();
        return bookPrice;
    }

    public static void checkBook(String inputBookName) {
        int indexOfBook = searchBook(listBooks, inputBookName);
        if (indexOfBook >= 0) {
            double bookPrice = getPriceOfSelectionBook(listBooks, indexOfBook);
            System.out.printf("Giá của sách %s là: %.2f", inputBookName, bookPrice);
        } else {
            System.out.println("Không có sách cần tìm");
        }
    }
}
