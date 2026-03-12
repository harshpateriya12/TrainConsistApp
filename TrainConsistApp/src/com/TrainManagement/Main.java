package com.TrainManagement;

import com.model.Bogie;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Bogie> bogieList = new ArrayList<>();

        System.out.println("*** Sort Bogies by Capacity ***");

        System.out.println("Enter number of bogies:");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            System.out.println("Enter Bogie Name:");
            String name = sc.nextLine();

            System.out.println("Enter Capacity:");
            int capacity = sc.nextInt();
            sc.nextLine();

            bogieList.add(new Bogie(name, capacity));
        }

        System.out.println("\nBogies Before Sorting:");
        for (Bogie b : bogieList) {
            System.out.println(b);
        }

        // Sorting using Comparator and Lambda
        bogieList.sort(Comparator.comparingInt(Bogie::getCapacity));

        System.out.println("\nBogies Sorted by Capacity (Ascending):");
        for (Bogie b : bogieList) {
            System.out.println(b);
        }

        
    }
}