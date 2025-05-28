public class BankAccount {

    private long acc_no;
    private String acc_name;
    private double balance = 0.0;
    private int pin;

    public BankAccount() {}

    public BankAccount(long acc_no, String acc_name, int pin){
        this.acc_no = acc_no;
        this.acc_name = acc_name;
        this.pin = pin;
    }
    
    public double checkBalance(){
        return balance;
    }

    public boolean deposit(double amount){
        if(amount > 0){
            balance += amount;
            return true;
        }
        else
            return false;
    }

    public boolean withdraw(double amount){
        if(amount > 0 && balance-amount >= 500){
            balance -= amount;
            return true;
        }
        else 
            return false;
    }

    public void setPin(int pin){
        this.pin = pin;
    }
    public void setAcc_no(long acc_no){
        this.acc_no = acc_no;
    }
    public void setAcc_name(String acc_name){
        this.acc_name = acc_name;
    }

    public int getPin(){
        return pin;
    }
    public String getAcc_name(){
        return acc_name;
    }
    public long getAcc_no(){
        return acc_no;
    }
}
