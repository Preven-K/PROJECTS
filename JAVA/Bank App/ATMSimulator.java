import java.util.Scanner;

public class ATMSimulator {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        
        BankAccount user1 = new BankAccount(12345678,"Allen",1234);
        
        System.out.println("\tWelcome to Bank Login Page");
        System.out.println("------------------------------------------");
        
        int attempts = 1;
        do{
            System.out.print("Enter Your Account Number : ");
            long user_accNo = sc.nextLong();
            System.out.print("Enter Password : ");
            int user_pin = sc.nextInt();
            
            if(user1.getAcc_no() == user_accNo){
                if(user1.getPin() == user_pin)
                    UI(user1);
                else {
                    System.out.println("\t>>> Invalid PIN...Attempts ("+attempts+"/3)");
                    attempts++;
                }
                if(attempts == 4)
                    System.out.println("! MAX ATTEMPT REACHED.. Account Locked, Try again after 12Hrs !");
            }
            else 
                System.out.println("\t>>> Invalid Account Number");

        }while(attempts!=4);

    }

    public static void UI(BankAccount user1) throws Exception{
        
        System.out.println("---------------------------------");
        System.out.println("\tWelcome "+user1.getAcc_name().toUpperCase());
        boolean isExit = false;
        do{
            System.out.println("---------------------------------");
            System.out.println("MENU :");
            System.out.println("-----------");
            System.out.println("1. Check Balance\n2. Deposit Money\n3. Withdraw Money\n4. Exit");
            int menu = sc.nextInt();

            switch (menu) {
                case 1:
                    System.out.println("\t>>> Balance : "+user1.checkBalance());
                    break;
                case 2:
                    System.out.print("Enter The amount to be Deposited :");

                    if(user1.deposit(sc.nextDouble())){
                        System.out.print("Depositing");
                        dots(3);
                        System.out.println("\t>>> Deposited Sucessfully");
                    }
                    else {
                        System.out.print("Depositing");
                        dots(3);
                        System.out.println("\t>>> Deposit Unsucessful");
                        System.out.println("\t>>> Check the Amount and Retry");
                    }
                    break;
                case 3:
                    System.out.println("Enter Amount to be Withdrawn :");
                    // System.out.print("\tValidating");
                    // dots(3);
                    if(user1.withdraw(sc.nextDouble())){
                        System.out.print("Withdrawing");
                        dots(3);
                        System.out.println("\t>>> Withdrawn Sucessfully");
                        System.out.println("\t>>> Please Collect The Amount");
                    }
                    else {
                        System.out.print("Withdrawing");
                        dots(3);
                        System.out.println("\t>>> Withdrawn Unsucessful");
                        System.out.println("\t>>> Check the Amount and Retry");
                    }
                    break;
                case 4:
                    System.out.println(">>> Thanks For Choosing Our Bank");
                    System.out.print("\t>>> Exiting");
                    dots(3);
                    isExit = true;
                    break;
            
                default:
                    System.out.println("\t>>> Invalid Choice. Try again...");
                    break;
            }


        }while(!isExit);
    }


    public static void dots(int n) throws Exception{
        for (int i = 0; i < n; i++){
            System.out.print(".");
            Thread.sleep(1000);
        }
        System.out.println();
    }
    
}
