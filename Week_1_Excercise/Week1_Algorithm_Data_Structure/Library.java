import java.util.Arrays;

class Book {
    String bookId;
    String title;
    String author;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }
}

class Library {

    public static Book linearSearch(Book[] books, String title) {
        for (Book book : books) {
            if (book.title.equals(title)) {
                return book;
            }
        }
        return null;
    }

    public static Book binarySearch(Book[] books, String title) {
        int low = 0, high = books.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (books[mid].title.equals(title)) {
                return books[mid];
            } else if (books[mid].title.compareTo(title) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book("1", "The Great Gatsby", "F. Scott Fitzgerald"),
            new Book("2", "To Kill a Mockingbird", "Harper Lee"),
            new Book("3", "1984", "George Orwell")
        };

        Arrays.sort(books, (a, b) -> a.title.compareTo(b.title));

        System.out.println("Linear Search Result: " + linearSearch(books, "1984").title);
        System.out.println("Binary Search Result: " + binarySearch(books, "1984").title);
    }
}
