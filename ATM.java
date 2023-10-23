package CBTCIP;
import java.util.*;
public class ATM {
        static Scanner sc = new Scanner(System.in);
        static ArrayList<String> history = new ArrayList<String>();

        static int balance = 50000;

        static String userid = "sdey123";
        static int userpin = 123456;


        public static void main(String[] args) {

            System.out.println("Welcome to the UCO BANK ATM:");


            while (true) {
                System.out.println("Enter your userid");
                String u = sc.next();
                System.out.println("Enter your pin");
                int p = sc.nextInt();
                if (validate(u, p)) {
                    System.out.println("Successfully Logged In");
                    System.out.println();
                    displayscreen();
                    break;
                }
            }
        }
        public static boolean validate(String user, int pin) {
            if (user.equals(userid)) {
                if (pin == userpin)
                    return true;
                else {
                    System.out.println("Enter correct pin");
                    return false;
                }
            } else {
                System.out.println("Enter correct userid");
                return false;
            }
        }

        public static void displayscreen() {

            while (true) {

                System.out.println("1. Transaction History");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. Exit");

                System.out.println("Enter your choice");
                int c = sc.nextInt();

                switch (c) {
                    case 1:
                        System.out.println("Transaction History");
                        transferHistory();
                        System.out.println();
                        break;
                    case 2:
                        System.out.println("Enter amount to be withdrawn");
                        int amt = sc.nextInt();
                        withdraw(amt);
                        System.out.println();
                        break;

                    case 3:
                        System.out.println("Enter amount to be deposited");
                        int a = sc.nextInt();
                        balance += a;
                        history.add("Deposited " + a);
                        System.out.println("Amount deposited successfully");
                        System.out.println("Balance = " + balance);
                        System.out.println();
                        break;

                    case 4:
                        System.out.println("Enter account number of the person to transfer the amount");
                        int acc = sc.nextInt();
                        System.out.println("Enter amount to be transferred");
                        int amount = sc.nextInt();
                        transfer(amount, acc);
                        System.out.println();
                        break;

                    case 5:
                        System.out.println("Thank you for using the service");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Enter correct choice");
                        break;
                }
            }
        }

        public static void withdraw(int amount) {

            if (balance < amount) {
                System.out.println("Insufficient Balance");
                return;
            } else {
                balance = balance - amount;
                System.out.println("Remaining Balance = " + balance);
                System.out.println("Collect your amount");
                history.add("Withdrawn " + amount);
                return;
            }
        }

        public static void transfer(int amt, int account) {

            if (balance < amt) {
                System.out.println("Insufficient Balance");
                return;
            } else {
                balance = balance - amt;
                System.out.println("Remaining Balance = " + balance);
                System.out.println("Amount Transferred to this account " + account + " successfully");
                history.add("Transferred to the account " + account + " a amount of " + amt);
                return;
            }
        }
        public static void transferHistory(){
            if(history.size() == 0) {
                System.out.println("No transaction in this session");
                return;
            }
            for (int i=0;i<history.size();i++)
            {
                System.out.println(history.get(i));
            }
            return;
        }
    }

