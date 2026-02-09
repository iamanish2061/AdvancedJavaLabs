package lab5;

import java.rmi.Naming;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Operation calc = (Operation) Naming.lookup("rmi://localhost/operation");

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter first number: ");
            int num1 = sc.nextInt();
            System.out.print("Enter second number: ");
            int num2 = sc.nextInt();

            System.out.println("Sum: " + calc.add(num1, num2));
            System.out.println("Difference: " + calc.sub(num1, num2));
            System.out.println("Product: " + calc.mul(num1, num2));

        } catch (Exception e) {
            System.out.println("Client Error: " + e.getMessage());
        }
    }
}