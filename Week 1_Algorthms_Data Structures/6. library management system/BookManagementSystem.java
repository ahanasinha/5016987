import java.util.Arrays;
import java.util.Scanner;

public class BookManagementSystem {

    private Book[] books = new Book[100];
    private int size = 0;

    public void addBook(int bookId, String title, String author) {
        if (size >= books.length) {
            books = Arrays.copyOf(books, books.length * 2);
        }
        books[size++] = new Book(bookId, title, author);
    }

    public Book linearSearch(String title) {
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    public Book binarySearch(String title) {
        int left = 0;
        int right = size - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = books[mid].getTitle().compareToIgnoreCase(title);
            if (cmp == 0) {
                return books[mid];
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public void sortBooks() {
        Arrays.sort(books, 0, size, (b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));
    }

    public void displayBooks() {
        for (int i = 0; i < size; i++) {
            System.out.println(books[i]);
        }
    }

    public static void main(String[] args) {
        BookManagementSystem system = new BookManagementSystem();
        Scanner sc = new Scanner(System.in);
        int id = 1;

        while (true) {
            System.out.print("1. Add Book\n2. Linear Search by Title\n3. Binary Search by Title\n4. Display Books\n-1 to Exit\nYour choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    system.addBook(id++, title, author);
                    system.sortBooks();
                    break;
                case 2:
                    System.out.print("Enter Title to search (Linear Search): ");
                    String linearSearchTitle = sc.nextLine();
                    Book linearSearchResult = system.linearSearch(linearSearchTitle);
                    if (linearSearchResult != null) {
                        System.out.println("Book Found: " + linearSearchResult);
                    } else {
                        System.out.println("Book with title '" + linearSearchTitle + "' not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Title to search (Binary Search): ");
                    String binarySearchTitle = sc.nextLine();
                    Book binarySearchResult = system.binarySearch(binarySearchTitle);
                    if (binarySearchResult != null) {
                        System.out.println("Book Found: " + binarySearchResult);
                    } else {
                        System.out.println("Book with title '" + binarySearchTitle + "' not found.");
                    }
                    break;
                case 4:
                    system.displayBooks();
                    break;
                case -1:
                    System.out.println("Thank you!");
                    sc.close();
                    return;
                default:
                    System.out.println("Incorrect choice, please try again.");
                    break;
            }
        }
    }
}
