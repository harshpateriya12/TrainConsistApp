package com.TrainManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

public static void main(String[] args) {

Scanner sc = new Scanner(System.in);


System.out.println("***UC2 - Add Passenger Bogies to Train***");


// Create ArrayList
List<String> passengerBogies = new ArrayList<>();//using arrayList

// ADD BOGIES
System.out.println("\nEnter number of bogies to add:");
int n = sc.nextInt();
sc.nextLine();

for(int i = 0; i < n; i++) {
System.out.println("Enter bogie name:");
String bogie = sc.nextLine();
passengerBogies.add(bogie);
}

// Display bogies
System.out.println("\nPassenger Bogies after adding:");
System.out.println(passengerBogies);

// REMOVE BOGIE
System.out.println("\nEnter bogie to remove:");
String removeBogie = sc.nextLine();

if(passengerBogies.remove(removeBogie)) {
System.out.println("Bogie removed successfully.");
}
else {
System.out.println("Bogie not found.");
}

System.out.println("\nPassenger Bogies after removal:");
System.out.println(passengerBogies);

//CHECK EXISTENCE
System.out.println("\nEnter bogie name to check:");
String checkBogie = sc.nextLine();

if(passengerBogies.contains(checkBogie)) {
System.out.println(checkBogie + " exists in the train.");
}
else {
System.out.println(checkBogie + " does not exist.");
}

// FINAL LIST
System.out.println("\nFinal Train Passenger Consist:");
System.out.println(passengerBogies);

System.out.println("\nUC2 operations completed successfully.");

sc.close();
}
}