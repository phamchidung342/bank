package com.bank;

import java.util.Scanner;

public class Account {
    String name;
    String email;
    int balance;
    String pin;

    public Account() {
        this.name = "";
        this.email = "";
        this.balance = 0;
        this.pin = "123456";
    }

    public Account(String name, String email, int balance, String pin) {
        this.name = name;
        this.email = email;
        this.balance = balance;
        this.pin = pin;
    }

    public void display() {
        System.out.println("---- Account information----");
        System.out.println("Name: " + this.name);
        System.out.println("Email: " + this.email);
        System.out.println("Balance: " + this.balance);
        System.out.println("PIN: *******");
    }

    public void inputData() throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter name: ");
        String s = input.nextLine();

        if(s.isEmpty()) {
            throw new Exception("Name can not be empty");
        }
        this.name = s;

        System.out.print("Enter email: ");
        s = input.nextLine();

        if(s.isEmpty()) {
            throw new Exception("Email can not be empty");
        }
        this.email = s;

        System.out.print("Enter pin: ");
        s = input.nextLine();

        if(s.isEmpty()) {
            throw new Exception("PIN can not be empty");
        }
        this.pin = s;

        try {
            System.out.print("Enter balance : ");
            s = input.nextLine();

            int amount = Integer.parseInt( s );
            if( amount < 0 ) {
                throw new Exception("Amount can not be < 0");
            }

            this.balance = amount;

        } catch(Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    public boolean withdraw(int amount) {
        if(this.balance >= amount) {
            System.out.println();
            this.balance -= amount;

            return true;
        }

        return false;

    }

    //Overload method
    public void deposit(int amount) {
        this.balance += amount;
    }

    //Overload method
    public void deposit(double amount) {
        this.balance += (int) amount;
    }

    public void deposit(String sAmout) {
        this.balance += Integer.parseInt(sAmout);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getPIN() {
        return pin;
    }
}
