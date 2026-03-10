package com.TrainManagement;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LinkedList<String> train = new LinkedList<>();

        System.out.println("Enter number of bogies:");
        int n = sc.nextInt();
        sc.nextLine();

        for(int i=0;i<n;i++)
        {
            System.out.println("Enter Bogie:");
            train.add(sc.nextLine());
        }

        System.out.println("Current Train Consist:");
        System.out.println(train);

        System.out.println("Enter bogie to insert:");
        String bogie = sc.nextLine();

        System.out.println("Enter position to insert:");
        int pos = sc.nextInt();

        train.add(pos, bogie);

        System.out.println("After insertion:");
        System.out.println(train);

        train.removeFirst();
        train.removeLast();

        System.out.println("After removing first and last bogie:");
        System.out.println(train);
    }
}