package com.bank;

import java.util.*;

public class TPBank {

    //create an array list that contains Account objects
    List<Account> accountList = new ArrayList<Account>();

    //constructor
    public TPBank() {
        accountList.add(new Account("tuan", "tuan@gmail.com", 1000, "123456"));
        accountList.add(new Account("nam", "nam@gmail.com", 2000, "123456"));
        accountList.add(new Account("hai", "hai@gmail.com", 3000, "123456"));
    }

    public void createAccount() throws Exception {
        Account account = new Account();
        account.inputData();

        accountList.add(account);
    }

    public void displayAll() {
        for(Account item : accountList) {
            item.display();
        }
    }

    @Deprecated
    public void withdraw( ) throws Exception {
        Scanner input = new Scanner(System.in);
        Account account = this.login();

        if( account != null ) {
            System.out.println("Please enter amount: ");
            //Scanner
            int amount = input.nextInt();

            if (account.withdraw( amount )) {
                System.out.println("With draw OK");
            } else {
                System.out.println("Error: not enough money");
            }

        } else {
            System.out.println("Login failed");
        }
    }

    public void withdrawNew( ) throws Exception {
        Scanner input = new Scanner(System.in);
        Account account = this.login();

        if( account != null ) {
            System.out.println("Please enter amount: ");
            //Scanner
            int amount = input.nextInt();
            //Validate > 0
            if(amount > 0) {
                if (account.withdraw( amount )) {
                    System.out.println("With draw OK");
                } else {
                    System.out.println("Error: not enough money");
                }
            }

        } else {
            System.out.println("Login failed");
        }
    }


    public void deposit( ) throws Exception {
        try {
            Scanner input = new Scanner(System.in);
            Account account = this.login();

            if(account != null) {
                System.out.println("Please enter amount: ");
                //Scanner
                int amount = input.nextInt();
                if(amount > 0) {
                    account.deposit( amount );
                    System.out.println("Deposit OK");
                }

            } else {
                System.out.println("Login failed");
            }


        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //return type
    public int sum(int a, int b) {
        return a + b;
    }

    public Account login() {

        Scanner input = new Scanner(System.in);
        String accoutName = "";
        String pin = "";

        System.out.print("Enter name: ");
        accoutName = input.nextLine();

        System.out.print("Enter pin: ");
        pin = input.nextLine();

        for ( Account item : accountList ) {
            if(   item.getName().equals(accoutName)
                    && item.getPIN().equals(pin) ) {
                return item;
            }
        }

        return null;
    }

    public Account findAccountByName(String name) {

        for ( Account item : accountList ) {
            if(item.getName().equals(name)) {
                return item;
            }
        }

        return null;

    }
}
