package com.TrainManagement;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

public static void main(String[] args) {

Scanner sc = new Scanner(System.in);


System.out.println("***UC3 - Track Unique Bogie IDs***");


// Create Set to store unique bogie IDs
Set<String> bogieIDs = new HashSet<>();

// Take number of bogie IDs
System.out.print("\nEnter number of bogie IDs to add: ");
int n = sc.nextInt();
sc.nextLine();

// Add bogie IDs (duplicates allowed in input but ignored in HashSet)
for (int i = 0; i < n; i++) {

System.out.print("Enter Bogie ID: ");
String id = sc.nextLine();

bogieIDs.add(id);
}

// Intentionally adding duplicates to demonstrate HashSet behavior
System.out.println("\nAdding duplicate IDs (BG101, BG102) intentionally...");
bogieIDs.add("BG101");
bogieIDs.add("BG102");

// Display final unique IDs
System.out.println("\nBogie IDs After Insertion:");
System.out.println(bogieIDs);

System.out.println("\nNote:");
System.out.println("Duplicates are automatically ignored by HashSet.");

System.out.println("\nUC3 uniqueness validation completed...");


}
}