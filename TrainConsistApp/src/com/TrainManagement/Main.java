package com.TrainManagement;

import com.model.Bogie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Bogie> bogieList = new ArrayList<>();

        System.out.println("***Filter Bogies Using Streams***");

        System.out.println("Enter number of bogies:");
        int n = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < n; i++) {

            System.out.println("Enter Bogie Name:");
            String name = sc.nextLine();

            System.out.println("Enter Capacity:");
            int capacity = sc.nextInt();
            sc.nextLine();

            bogieList.add(new Bogie(name, capacity));
        }

        System.out.println("\nAll Bogies:");
        bogieList.forEach(System.out::println);

        System.out.println("\nEnter minimum capacity to filter bogies:");
        int minCapacity = sc.nextInt();

        // Stream Filtering
        List<Bogie> filteredBogies =
                bogieList.stream()
                        .filter(b -> b.getCapacity() > minCapacity)
                        .collect(Collectors.toList());

        System.out.println("\nFiltered Bogies (Capacity > " + minCapacity + "):");

        if(filteredBogies.isEmpty())
        {
            System.out.println("No bogies match the condition.");
        }
        else
        {
            filteredBogies.forEach(System.out::println);
        }

       
    }
}