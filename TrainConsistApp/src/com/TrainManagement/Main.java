package com.TrainManagement;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        HashMap<String, Integer> bogieCapacity = new HashMap<>();//using hashmap

        System.out.println("***Bogie Capacity Mapping System***");

        System.out.println("Enter number of bogies to map:");
        int n = sc.nextInt();
        sc.nextLine();

        for(int i=0;i<n;i++)
        {
            System.out.println("Enter Bogie Name:");
            String bogieName = sc.nextLine();

            System.out.println("Enter Capacity:");
            int capacity = sc.nextInt();
            sc.nextLine();

            bogieCapacity.put(bogieName, capacity);//inserting values
        }

        System.out.println("\nBogie Capacity Details:");

        for(Map.Entry<String,Integer> entry : bogieCapacity.entrySet())
        {
            System.out.println("Bogie : " + entry.getKey() +
                               " Capacity : " + entry.getValue());
        }

        System.out.println("\nSearch Capacity of a Bogie");

        System.out.println("Enter Bogie Name:");
        String search = sc.nextLine();

        if(bogieCapacity.containsKey(search))
        {
            System.out.println("Capacity of " + search + " is "
                    + bogieCapacity.get(search));
        }
        else
        {
            System.out.println("Bogie not found.");
        }

        System.out.println("\nProgram Continues...");
    }
}