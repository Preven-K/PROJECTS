import java.util.*;

public class Prog
{
    static Scanner sc = new Scanner(System.in);

    public static void UI()
    {
        int choice = 0;

        do{
            System.out.println("Welcome to Main Dashboard Master ");
            System.out.println("---------------------------------");
            System.out.println("1. Factorial");
            System.out.println("2. Digital Sum");
            System.out.println("3. Right Triangle");
            System.out.println("4. Inverted Right Triangle");
            System.out.println("5. Square");
            System.out.println("6. Exit & LogOut");
            System.out.println("---------------------------------");

            System.out.println("Enter the Choice :");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Factorial();                    
                    break;
                case 2:
                    Digital_Sum();                    
                    break;
                case 3:
                    Patterns.RightTriangle();
                    break;
                case 4:
                    Patterns.InvertedRightTriangle();
                    break;
                case 5:
                    Patterns.Square();
                    break;
                case 6:
                    System.out.println("Logging Out...");
                    return;
            
                default:
                    System.out.println("Select Valid Options");
                    break;
            }
            

        }while(choice>0);

    }
    public static void Factorial()
    {
        System.out.print("Enter N:");
        int n = sc.nextInt();
        int mul = 1;
        for (int i = 1; i <= n; i++) {
            mul *= i;           
        }
        System.out.println("\n\n\t>>>Factorial of "+n+" "+mul);

    }

    public static void Digital_Sum()
    {
        System.out.print("Enter the Number: ");
        int n = sc.nextInt();
        int sum = 0;
        while(n>0){
            sum += n%10;
            n /= 10;
        }
        System.out.println("\n\n\tDigital SUm : "+sum);
    }
}
