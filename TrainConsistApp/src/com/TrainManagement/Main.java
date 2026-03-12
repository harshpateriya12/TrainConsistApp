package com.TrainManagement;

import com.service.TrainConsistService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        TrainConsistService service = new TrainConsistService();
        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n***Train Consist Management Menu***");

            System.out.println("1. Initialize Train (UC1)");
            System.out.println("2. Add Passenger Bogies (UC2)");
            System.out.println("3. Unique Bogie IDs (UC3)");
            System.out.println("4. Ordered Train Consist (UC4)");
            System.out.println("5. Preserve Insertion Order (UC5)");
            System.out.println("6. Map Bogie Capacity (UC6)");
            System.out.println("7. Sort Bogies by Capacity (UC7)");
            System.out.println("8. Filter Bogies using Streams (UC8)");
            System.out.println("9. Group Bogies by Type (UC9)");
            System.out.println("10. Count Total Seats (UC10)");
            System.out.println("0. Exit");

            System.out.println("Enter your choice:");
            choice = sc.nextInt();

            switch(choice)
            {
                case 1:
                    service.initializeTrain();
                    break;

                case 2:
                    service.addPassengerBogies();
                    break;

                case 3:
                    service.uniqueBogieIDs();
                    break;

                case 4:
                    service.orderedTrainConsist();
                    break;

                case 5:
                    service.insertionOrderBogies();
                    break;

                case 6:
                    service.mapBogieCapacity();
                    break;

                case 7:
                    service.sortBogiesByCapacity();
                    break;

                case 8:
                    service.filterBogies();
                    break;

                case 9:
                    service.groupBogiesByType();
                    break;
                    
                case 10:
                    service.countTotalSeats();
                    break;

                case 0:
                    System.out.println("Choose a Valid option");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while(choice != 0);
    }
}