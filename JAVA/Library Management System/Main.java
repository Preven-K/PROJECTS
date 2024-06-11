package LIBRARY;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.io.*;
import java.util.*;



public class Main {
    private static Map<String, Book> books = new HashMap<>();  //creating a hashmap for book
    private static Map<String, Patron> patrons = new HashMap<>();  //creating a hashmap for Patron
    private static Scanner scanner = new Scanner(System.in);    //declaring scanner which is used to get input 

    public static void main(String[] args) {
        initializeData();        //function call 

        
        while (true) {
            System.out.println("\n --- Library Book Management System ---");
            System.out.println("\n**** MENU ****");
            System.out.println("1. Add Book");
            System.out.println("2. Add Patron");
            System.out.println("3. Borrow a book");
            System.out.println("4. Return a book");
            System.out.println("5. Save Data");
            System.out.println("6. List the books and Patrons");
            System.out.println("7. Exit");
            System.out.print("\nEnter your choice: ");

            int choice = scanner.nextInt();  //getting input from above choices
            scanner.nextLine();           // Clearing the buffer

            switch (choice) {            //comparing the choices with switch cases
                case 1:
					addBook();
					break;
				case 2:
					addPatron();
					break;

                case 3:
                    borrowBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
					saveData();
					break;
                case 6:
                    System.out.println("\n\t---Library List---");
                    print();
                    break;
            
                case 7:
                    saveData();
                    System.out.println("\n \n ________Exiting....bye bye have a Nice day!_______");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
    //Printing the list of books and Patrons--------------------------choice=="6"
    public static void print()
    {
        Set<Map.Entry<String,Book>> entrySetB = books.entrySet();  //using set to hold map
        System.out.println("List of Books:");
        int i=1;
        for(Map.Entry<String,Book>entry : entrySetB)               //iterating every key as entry
        {              
        System.out.println("Book "+i+": "+entry.getKey()); 
        i++;
        }                                                         //printing only the key 
        
        //doing the same for the Patrons
        Set<Map.Entry<String,Patron>> entrySetP = patrons.entrySet();  //creating set for patrons
        System.out.println("\n List of Patrons:");
        int j=1;
        for(Map.Entry<String,Patron>entry : entrySetP)
        {
        System.out.println("Patron "+j+": "+entry.getKey());
        j++;
        }
    }

     private static void initializeData()                 //Creating a BOOKS & PATRONS
     {
        // Add some books to the library
        books.put("The Great Gatsby", new Book("The Great Gatsby", "F. Scott Fitzgerald"));
        books.put("To Kill a Mockingbird", new Book("To Kill a Mockingbird", "Harper Lee"));

        // Add some patrons to the library
        patrons.put("Alice", new Patron("Alice"));
        patrons.put("Bob", new Patron("Bob"));
    }


    //method to BORROW BOOK --------------------------------choice=="3"
    private static void borrowBook() {
        System.out.print("\nEnter patron name: ");
        String patronName = scanner.nextLine();

        if (!patrons.containsKey(patronName))      //checking the patron is already present in the key of hashtable 
        { 
            System.out.println("Patron not found.");
            return;
        }

        Patron patron = patrons.get(patronName);

        System.out.print("Enter book title: ");
        String bookTitle = scanner.nextLine();

        if (!books.containsKey(bookTitle))       //checking the book is already present in the key of hashtable 
        {
            System.out.println("Book not found.");
            return;
        }

        Book book = books.get(bookTitle);        // Return the value if the key is present in mapping
        if (book.isBorrowed())                   //checking the book is borrowed or not?
        {
            System.out.println("Book is already borrowed by " + book.getBorrowedBy());
            return;
        }

        LocalDate transactionDate = LocalDate.now();                  //using the local date module allocating todays date as transaction_date
        LocalDate dueDate = transactionDate.plusDays(25);   //adding 25 days to the transaction date to know the due date
        //creating object and calling the constructor of transaction.java
        Transaction transaction = new Transaction(patron, book, transactionDate, dueDate);

        book.borrowBook(patronName);                                  //changing the book is borrowed in book.java by function call
        
        System.out.println("\n---Borrowed Successful---");
        System.out.println("\n !!! Book has to be returned after 25days !!! ");
        System.out.println("\n\t :)  Happy Learning  :) ");
        transaction.printTransaction();                               //printing the transaction by function call in transaction.java 
    }


    //method to RETURN BOOK-----------------------------------choice=="4"
    private static void returnBook() 
    {
        System.out.print("\nEnter patron name: ");
        String patronName = scanner.nextLine();             //input patron name

        if (!patrons.containsKey(patronName))              //checking the patron name exists in map
        { 
            System.out.println("Patron not found.");
            return;
        }
        Patron patron = patrons.get(patronName);        //Returns the value if the key presenet in the map

        System.out.print("Enter book title: ");
        String bookTitle = scanner.nextLine();        // input of title of the book

        if (!books.containsKey(bookTitle)) {           //checking the book title exists in map
            System.out.println("Book not found.");
            return;
        }
        Book book = books.get(bookTitle);        //geting the book title from the map
        //verifying book is borrowed and also its by this patron
        if (!book.isBorrowed() || !book.getBorrowedBy().equals(patronName))  {   
            System.out.println("Book is not borrowed by this patron.");
            return;
        }

        System.out.print("Enter return date (YYYY-MM-DD): ");  
        LocalDate returnDate;                                     //creating variable for return date in LocalDate                       
        try {
            returnDate = LocalDate.parse(scanner.nextLine());    //getting input return date
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please use YYYY-MM-DD.");
            return;
        }

        LocalDate dueDate = LocalDate.now().plusDays(25);   //calculating the actual return data to verify fine
        Transaction transaction = new Transaction(patron, book, LocalDate.now(), dueDate); //return book with setter in transaction.java
        transaction.returnBook(returnDate);                           //function call in transaction.java

        System.out.println("\n-----Book Returned Successful-----");
        transaction.printTransaction();
    }


    //ADDING BOOK -------------------------------------choice=="1"
    private static void addBook() {
		System.out.print("\nEnter book title: ");
		String title = scanner.nextLine();           // input book title for adding into library
		System.out.print("Enter book author: ");
		String author = scanner.nextLine();          // input book author for adding into library

		Book book = new Book(title, author);         // function call for setter in Book.java 
		books.put(title, book);                      //adding into hashmap
		System.out.println("-----Book added successfully-----");
	}


    //ADDING PATRON--------------------------------------choice=="2"
	private static void addPatron() {
		System.out.print("\nEnter patron name: ");
		String name = scanner.nextLine();             //input for patron name

		Patron patron = new Patron(name);
		patrons.put(name, patron);                     //adding into hashmap
		System.out.println("-----Patron added successfully-----");
	}


    //SAVE DATA-------------------------------------------choice=="7"
    private static void saveData() {
		try {
			FileOutputStream fileOut = new FileOutputStream("book_data.txt");   //opening the file to store the data
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);          //creating object 
			objectOut.writeObject(books);                                            //writing the books from hashmap
			objectOut.writeObject(patrons);                                          //writing the patrons from hashmap
			objectOut.close();
			System.out.println("---Data saved successfully!---");
		} catch (IOException e) {
			System.err.println("Error saving data :( " + e.getMessage());
		}
	}


}
