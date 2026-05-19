package artmuseum;

import java.util.Scanner;

public class ArtMuseum {

    private Scanner sc;

    public ArtMuseum() {
        sc = new Scanner(System.in);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArtMuseum am = new ArtMuseum();

        int total = 0;
        String std = null;

        System.out.println("===Welcome To Art Museum===");
        System.out.print("Enter name : ");
        String name = sc.next();

        System.out.print("Enter Total Number Of Visitor : ");
        int visitor = sc.nextInt();

        for (int i = 0; i < visitor; i++) {

            System.out.print("Enter Visitor Type (1=Local, 2=International) : ");
            int type = sc.nextInt();

            System.out.print("Enter visitor Age : ");
            int age = sc.nextInt();

            if (age > 12 && age <= 59) {
                System.out.print("Are you Student (Yes, No) : ");
                std = sc.next();

                System.out.print("Student ID : ");
                String ID = sc.next();
            }

            int price = am.calcTicket(type, age, std);

            total = am.totalPrice(total, price);
        }

        System.out.print("Add-On Services Tour Guide ? (1=Yes, 2=No) : ");
        int add = sc.nextInt();

        total = am.addOn(total, add);

        double tax = am.calcTax(total);

        double finalTotal = am.finalTotal(total, tax);

        System.out.println("\n===== RECEIPT =====");
        System.out.println("Billing Name: " + name);
        System.out.println("Is Student ? : " + std);
        System.out.println("---Breakdown---");
        System.out.println("\nTicket Subtotal: RM " + total);
        System.out.printf("SST (6%%): RM %.2f%n", tax);
        System.out.printf("Total Price: RM %.2f%n", finalTotal);
    }

    public int calcTicket(int type, int age, String std) {

        int price = 0;

        if (type == 1) {
            if (age <= 12) {
                price = 6;
            } else if (age <= 59) {

                if (std.equalsIgnoreCase("yes")) {
                    price = 12;
                } else {
                    price = 15;
                }

            } else {
                price = 8;
            }

        } else if (type == 2) {

            if (age <= 12) {
                price = 12;
            } else if (age <= 59) {

                if (std.equalsIgnoreCase("yes")) {
                    price = 15;
                } else {
                    price = 20;
                }

            } else {
                price = 16;
            }
        }

        return price;
    }

    public int totalPrice(int total, int price) {
        return total + price;
    }

    public int addOn(int total, int add) {

        if (add == 1) {
            total += 50;
        }

        return total;
    }

    public double calcTax(int total) {
        return total * 0.06;
    }

    public double finalTotal(int total, double tax) {
        return total + tax;
    }
}