import java.util.*;

public class UI {
    static ArrayList <Books> lib = new ArrayList <>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception{
        
        int in;
        do{
            System.out.println("\n\n\tLibrary Management ");
            System.out.println("--------------------------------");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. Exit");
            System.out.println("-------------------------------");

            in = sc.nextInt();

            switch (in) {
                case 1:
                    Add_Book();
                    break;
                case 2:
                    Remove_Book();
                    break;
                case 3:
                    Search_Book();
                    break;
                case 4:
                    System.out.print("\tExiting");
                    sleeep_dots(3);
                    System.out.println("Byee Have a great Learning");
                    break;
            
                default:
                    System.out.println("\tEnter Valid Option!!");
                    break;
            }
        }while(in!=4);
    }

    public static void Add_Book() throws Exception{
        int id;
        String name,author;
        double price;
        
        System.out.println("\tADD BOOK UI");
        System.out.println("\t-------------");
        do{
            System.out.print("Enter Book ID: ");
            id = sc.nextInt();
            if(id<=0)
                System.out.println("Invalid ID. Try Again!");
        }while(id<=0);
        
        System.out.print("Enter Book Name: ");
        sc.nextLine();
        name = sc.nextLine();
        
        System.out.print("Enter Book Author : ");
        author = sc.nextLine();
        
        do{
            System.out.print("Enter Book Price: ");
            price = sc.nextDouble();
            if(price<=0)
                System.out.println("Invalid Price. Try Again!");
        }while(price<=0);

        lib.add(new Books(id,name,author,price));  /////////// adding to array list
        System.out.print("\nAdding Book to "+Books.lib_name);
        sleeep_dots(3);     
        System.out.print("\n\n\t***Sucessfully Added! ***\n\tReturning to homepage");
        sleeep_dots(3);
    }
    public static void Remove_Book() throws Exception{
        System.out.println("\tRemove Book UI");
        System.out.println("\t---------------");
        int id;
        do{
            System.out.print("Enter the Book ID: ");
            id = sc.nextInt();
            if(id <= 0)
                System.out.println("\tInvalid ID! Try Again");
        }while(id<=0);

        System.out.print("Searching for book");
        sleeep_dots(3);

        for (Books i : lib) {
            if(i.book_id == id){    // ID found
                System.out.println("\nBook Details :\n--------------------"+i);
                lib.remove(i); //////////////// removing from array list
                System.out.print("\n Removing Book from "+Books.lib_name);
                sleeep_dots(3);
                System.out.print("\n\n\tSucessfully Removed! \n\tReturning to homepage");
                sleeep_dots(3);
                return;
            }            
        } 
        // ID Not found
        System.out.println("\n\n\t***Book ID not Found***");
        System.out.print("\tReturning to homepage");
        sleeep_dots(3);

    }
    public static void Search_Book() throws Exception{
        int choice;
        System.out.println("\tSearch Book UI");
        System.out.println("\t--------------");
        do{        
            System.out.println("How Do you want to Search the Book ?");
            System.out.println("1. Book ID");
            System.out.println("2. Book Name");
            System.out.println("3. Book Author");
            System.out.println("4. Book Price");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    int id;
                    System.out.print("Enter Book ID :");
                    id = sc.nextInt();

                    if(id>0){ // id valid
                        System.out.print("\tSearching Book in library");
                        sleeep_dots(3);
                        boolean flag = false;
                        for (Books i : lib) {
                            if(i.book_id == id){
                                flag = true;
                                System.out.println("\n\t***Book found Sucessfully***"); 
                                System.out.println(i);
                                break;
                            } 
                        }
                        if(flag == false)
                            System.out.println("\n\t***Book not Found***");
                    }
                    else {
                        System.out.println("\n\t***Invalid ID***");
                    }
                    System.out.print("\n\tReturning Homepage");
                    sleeep_dots(3);
                    break;
                
                case 2:
                    String name;
                    System.out.print("Enter Book Name :");
                    sc.nextLine();
                    name = sc.nextLine();

                    System.out.print("\n\tSearching Book in library");
                    sleeep_dots(3);
                    boolean flag = false;
                    for (Books i : lib) {
                        if(i.book_name.contains(name)){
                            flag = true;
                            System.out.println("\n\t***Book found Sucessfully***"); 
                            System.out.println(i); 
                            break;
                        } 
                    }
                    if(flag == false)
                        System.out.println("\n\t***Book Name not Found***");
                    System.out.print("\n\tReturning Homepage");
                    sleeep_dots(3);                    
                    break;

                case 3:
                    
                    System.out.print("Enter Author Name:");
                    sc.nextLine();
                    String author = sc.nextLine();

                    System.out.print("\n\tSearching Book in library");
                    sleeep_dots(3);
                    boolean available = false;
                    for (Books i : lib) {
                        if(i.book_author.contains(author)){
                            available = true;
                            System.out.println("\n\t***Books Found***"); 
                            System.out.println(i); 
                        } 
                    }
                    if(available == false)
                        System.out.println("\n\t***Author Name not Found***");
                    System.out.print("\tReturning Homepage");
                    sleeep_dots(3);                    
                    break;                    

                case 4:
                    double price;
                    System.out.print("Enter Book Price :");
                    price = sc.nextDouble();

                    if(price>0){ // price valid
                        System.out.print("\tSearching Book in library");
                        sleeep_dots(3);
                        boolean avail = false;
                        for (Books i : lib) {
                            if(i.book_price == price){
                                avail = true;
                                System.out.println("\n\t***Books Found***"); 
                                System.out.println(i);
                            } 
                        }
                        if(avail == false)
                            System.out.println("\n\t***No Books Found at that price***");
                    }
                    else 
                        System.out.println("\n\t***Invalid Price***");

                    System.out.print("\n\tReturning Homepage");
                    sleeep_dots(3);
                    break;                            
            
                default:
                    System.out.println("\n\tEnter Valid Option!!!");
                    System.out.print("\n\tReturning Homepage");
                    sleeep_dots(3);
                    break;
            }
        }while(choice <= 0 && choice > 4);
    }

    public static void sleeep_dots(int n)throws Exception{
        for (int i = 0; i < n; i++) {
            Thread.sleep(500);
            System.out.print(".");          
        }
    }
    
}
