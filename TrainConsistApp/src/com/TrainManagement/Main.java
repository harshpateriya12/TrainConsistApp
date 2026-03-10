package com.TrainManagement;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LinkedHashSet<String> bogies = new LinkedHashSet<>();

        System.out.println("Enter number of bogies:");
        int n = sc.nextInt();
        sc.nextLine();

        for(int i=0;i<n;i++)
        {
            System.out.println("Enter Bogie Name:");
            bogies.add(sc.nextLine());
        }

        System.out.println("\nBogies in insertion order:");
        System.out.println(bogies);

    }
}