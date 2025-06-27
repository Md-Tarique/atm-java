
import java.util.Scanner;

class Atm {
    double balance = 0;
    int count = 3;

    private int[] Pins = { 1234, 2345, 3456, 4567, 5678, 6789, 7890 };

    void ChechPin() {
        System.out.println("                          Welcome ot Our Bank ATM");
        System.out.println("          ______________________________________________________________     ");
        while (count > 0) {
            System.out.println("Enter your PIN:");
            Scanner scanner = new Scanner(System.in);
            int pin = scanner.nextInt();
            // Check if pin is valid
            for (int i = 0; i < Pins.length; i++) {
                if (pin == Pins[i]) {
                    menu();
                    break;
                }

                else {
                    count--;
                    System.out.println("Incorrect PIN. You have " + count + " attempt(s) left.");
                    break;
                }
            }

            if (count == 0) {
                System.out.println("Your card has been blocked due to multiple incorrect attempts.");
            }
        }

    }

    void menu() {
        System.out.println("enter our option");
        System.out.println("1 for balance check\n2 for deposit\n3 for withdraw\n4 for exit");
        Scanner s1 = new Scanner(System.in);
        int opt = s1.nextInt();
        switch (opt) {

            case 1:
                checkBalance();
                break;
            case 2:
                Deposit();
                break;

            case 3:
                withdraw();
                break;

            case 4:
                System.out.println("Exiting. Thank you for using the ATM.");
                System.exit(0);
                break;
            default:
                System.out.println("Wrong input. Try again.");
                menu();
        }

    }

    void Deposit() {
        System.out.println("enter amount to deposit Rs=");
        Scanner s2 = new Scanner(System.in);
        double depAmt = s2.nextInt();
        balance += depAmt;
        System.out.println("Available balance in your account Rs=" + balance);
        menu();
    }

    void checkBalance() {
        System.out.println("Available balance in your account Rs=" + balance);
        menu();

    }

    void withdraw() {
        System.out.println("enter amount to withdraw");
        Scanner s3 = new Scanner(System.in);
        double withdrawAmt = s3.nextInt();
        if (withdrawAmt > balance) {
            System.out.println("insuffucient balance ...!!!");
        } else {
            System.out.println("your are succesfully withdraw Rs=" + withdrawAmt + "\n"
                    + "" + "Available balance in your account Rs=" + (balance - withdrawAmt));
        }
        menu();

    }

}

public class Atmmachine {

    public static void main(String[] args) {
        Atm a = new Atm();
        a.ChechPin();

    }

}
