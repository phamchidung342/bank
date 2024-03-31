package com.bank;

import java.util.Date;
import java.util.Scanner;

public class MainClass {

    //@SuppressWarnings("deprecation")
    public static void main(String[] args) {

        try {
            TPBank tpBank = new TPBank();
            Scanner input = new Scanner(System.in);

//            Scanner input = new Scanner(System.in);
//            System.out.print("Enter name to find: ");
//            String name = input.nextLine();
//
//            Account account = tpBank.findAccountByName(name);
//            if(account != null) {
//                System.out.println("FOUND");
//                account.display();
//            } else {
//                System.out.println("Not found");
//            }

            do {

                System.out.println("1. Create account");
                System.out.println("2. Display all accounts");
                System.out.println("3. Find by name");
                System.out.println("4. Withdraw with PIN");
                System.out.println("5. Withdraw PIN new");
                System.out.println("6. Deposit with PIN");
                System.out.println("7. Exit");

                System.out.print("Menu: ");
                int menu = input.nextInt();

                switch (menu) {
                    case 1:
                        tpBank.createAccount();
                        break;
                    case 2:
                        tpBank.displayAll();
                        break;
                    case 4:
                        //Old Version 2023 , please do not change
                        tpBank.withdraw();
                        break;
                    case 5:
                        tpBank.withdrawNew();
                        break;
                    default:
                        System.out.println("Wrong menu");
                        break;
                }

            } while (true);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
