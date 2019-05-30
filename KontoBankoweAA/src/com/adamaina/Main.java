package com.adamaina;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwę konta");
        String name = scanner.nextLine();
        Account bankAccount = new Account(name);
        bankAccount.chooseAction();
    }
}