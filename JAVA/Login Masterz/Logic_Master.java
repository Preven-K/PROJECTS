import java.util.*;

public class Logic_Master
{
    static Scanner sc = new Scanner(System.in);
    static String sys_id, sys_pass , sys_mail;
    static boolean acc_exist = false;


    public static void Processing() throws Exception
    {
        System.out.print("Processing");
        System.out.print(".");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.println(".");
        Thread.sleep(500);
    }

    public static void Login() throws Exception
    {
        System.out.println("\t LOGIN");
        System.out.println("---------------------------");
        System.out.print("Enter the ID / Email : ");
        sc.nextLine();
        String u_id_mail = sc.nextLine();
        System.out.print("Enter the Password : ");
        String u_pass = sc.nextLine();

        Processing();

        if(u_pass.equals(sys_pass) && u_id_mail.equals(sys_mail) && acc_exist)
        {
            System.out.println("\t*** Login Successfull ***");
            Prog.UI();
        }
        else if (acc_exist == false)
            System.out.println("\t!!! Account Doesnot Exists!!! \n>>SignUp and Continue Login ");
        else
            System.out.println("\t!!! Invalid Login Credentials !!!\n>> Enter Correct Details");  
    }

    public static void SignUp() throws Exception
    {
        System.out.println("\t SIGNUP ");
        System.out.println("---------------------------");
        System.out.print("Enter Email : ");
        sys_mail = sc.next();
        System.out.print("Enter new ID : ");
        sys_id = sc.next();
        System.out.print("Enter new Password : ");
        sys_pass = sc.next(); 
        
        Processing();
        acc_exist = true;
        System.out.println("\t *** SIGNUP SUCESSFUL ***");
        System.out.println(">> Login Now");

    }

    public static void Forgot_Pass() throws Exception
    {
        System.out.println("FORGOT PASSWORD");
        System.out.println("---------------------------");
        System.out.print("Enter the mail : ");
        String u_mail = sc.next();

        
        if(u_mail.equals(sys_mail) && acc_exist == true)
        {
            System.out.println("Enter the OTP sent to Your mail");
            System.out.print("Mail :" + sys_mail);
            double sys_otp = Math.random()*9999+9999;
            Thread.sleep(3000);
            System.out.println("\n\n\t*** OTP NOTIFICATION ---> "+ (int)sys_otp );
            System.out.print("\nEnter OTP : ");
            int u_otp = sc.nextInt();

            Processing();

            if(u_otp == (int)sys_otp)
            {
                System.out.println("Enter NEW Password : ");
                sys_pass = sc.next();
                System.out.println("\t*** Password Changed Successfully ***");
            }
            else
            {
                System.out.println("OTP Invalid...");
            }
        }
        else
        {
            System.out.println("Invalid Credentials.....");
            System.out.println("Redirecting to Home Page");
        }

    }


    public static void main(String[] args) throws Exception
    {
        boolean Logic_exit = true;
        do
        {
            System.out.println("\tWELCOME TO LOGIC MASTER ");
            System.out.println("---------------------------");
            System.out.println("1. LogIn \n2. SignUp \n3. Forgot Password \n4. Exit");
            System.out.println("---------------------------");
            int u_in = sc.nextInt();
            switch (u_in) 
            {
                case 1: // Login
                {
                    Login();                    
                    break;
                }
                case 2: // SignUp 
                {
                    SignUp();                    
                    break;
                }
                case 3: // Forgot Pass
                {
                    Forgot_Pass();                                        
                    break;
                }
                case 4: // Exit
                {
                    System.out.println("Exiting..."); 
                    Logic_exit = false;                                       
                    break;
                }
            
                default:
                    System.out.println("\t***Enter Valid Option***");
                    break;
            }
        } while(Logic_exit);        
    }    
}
