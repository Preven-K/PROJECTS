package LIBRARY;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


class Transaction {
    private Patron patron;
    private Book book;
    private LocalDate transactionDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private double overdueFines;

    private static final double FINE_PER_DAY = 50;

    public Transaction(Patron patron, Book book, LocalDate transactionDate, LocalDate dueDate) {
        this.patron = patron;
        this.book = book;
        this.transactionDate = transactionDate;
        this.dueDate = dueDate;
        this.returnDate = null;
        this.overdueFines = 0.00;
    }

    public void returnBook(LocalDate returnDate) {
        this.returnDate = returnDate;
        book.returnBook();

        // Calculate overdue fines
        if (returnDate.isAfter(dueDate)) {
            long overdueDays = ChronoUnit.DAYS.between(dueDate, returnDate);
            overdueFines = overdueDays * FINE_PER_DAY;
        } else {
            overdueFines = 0.00;
        }
    }

    public void printTransaction() {
        System.out.println("\nTransaction Details:");
        System.out.println("Patron: " + patron.getName());
        System.out.println("Book: " + book.getTitle() + "  Author:  " + book.getAuthor());
        System.out.println("Transaction Date: " + transactionDate);
        System.out.println("Due Date: " + dueDate);
        System.out.println("Return Date: " + (returnDate != null ? returnDate.toString() : "Not returned yet"));
        System.out.println("Overdue Fines: " + overdueFines+ "Rs");
        System.out.println("Book Checkout: " + (book.isBorrowed() ? "NO" : "YES"));
    }
}
