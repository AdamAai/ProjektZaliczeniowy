package com.adamaina;

import java.util.Scanner;
import java.util.ArrayList;


public class Account {
    private String accountName;
    private int balance = 0;
    private ArrayList<Integer> transactions;

    public Account(String accountName) {
        this.accountName = accountName;
        this.transactions = new ArrayList<Integer>();
    }

    Scanner scanner = new Scanner(System.in);

    public int getBalance() {
        return balance;
    }

    public void deposit() {
        System.out.println("Podaj kwotę wpłaty");
        int amount = scanner.nextInt();
        if(amount > 0) {
            transactions.add(amount);
            this.balance += amount;
            System.out.println(amount + " wpłacono. Saldo wynosi " + this.balance);
        } else {
            System.out.println("Nie można wpłacić ujemnej kwoty");
        }
    }

    public void withdraw() {
        System.out.println("Podaj kwotę wypłaty");
        int amount = scanner.nextInt();

        if(amount > 0 && amount <= this.balance) {
            this.transactions.add(-amount);
            this.balance -= amount;
            System.out.println(amount + " wypłacono. Saldo wynosi " + this.balance);
        } else {
            System.out.println("Nie można przeprowadzić operacji. Ujemna kwota wpłaty lub brak środków na koncie");
        }
    }

    public void printTransactions() {
        for(int i = 0;i < this.transactions.size();i++) {
            System.out.println((i + 1) + ". " + transactions.get(i));
        }
    }


    public static void printActions(){
        System.out.println("Wybierz akcję");
        System.out.println("1 - Stan konta");
        System.out.println("2 - Wpłata gotówki");
        System.out.println("3 - Wypłata gotówki");
        System.out.println("4 - Lista transakcji");
        System.out.println("5 - Wyjście");
        System.out.println();
    }

    public void chooseAction() {

        boolean exit = false;
        while(!exit) {
            printActions();
            int action = scanner.nextInt();
            switch (action) {
                case 1: {
                    System.out.println("Saldo wynosi " + this.balance);
                    break;
                }

                case 2: {
                    this.deposit();
                    break;
                }

                case 3: {
                    this.withdraw();
                    break;
                }

                case 4: {
                    this.printTransactions();
                    break;
                }

                case 5: {
                    System.out.println("Dziękujemy");
                    exit = true;
                    break;
                }

                default: {
                    System.out.println("Nie ma takiej akcji");
                    break;
                }
            }
        }
    }
}