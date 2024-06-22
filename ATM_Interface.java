import java.util.Scanner;

class BankAccount 
{
    private double balance;

    public BankAccount(double initialBalance)
    {
        this.balance = initialBalance;
    }

    public double getBalance() 
    {
        return balance;
    }

    public void deposit(double amount)
    {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount)
    {
        if (amount > 0 && amount <= balance)
        {
            balance -= amount;
            return true;
        }
        return false;
    }
}

class ATM 
{
    private BankAccount account;

    public ATM(BankAccount account) 
    {
        this.account = account;
    }

    public void withdraw(double amount) 
    {
        if (account.withdraw(amount)) 
        {
            System.out.println("Withdrawal successful! Your new balance is: $" + account.getBalance());
        } 
        else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void deposit(double amount) 
    {
        account.deposit(amount);
        System.out.println("Deposit successful! Your new balance is: $" + account.getBalance());
    }

    public void checkBalance()
    {
        System.out.println("Your current balance is: $" + account.getBalance());
    }

    public void start()
    {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit)
        {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice)
            {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

public class ATM_Interface
{
    public static void main(String[] args) 
    {
        BankAccount account = new BankAccount(100);
        ATM atm = new ATM(account);
        atm.start();
    }
}
