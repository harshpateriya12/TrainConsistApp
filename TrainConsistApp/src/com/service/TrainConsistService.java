package com.service;

import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

import com.model.Bogie;
import com.model.GoodsBogie;
import com.exception.InvalidCapacityException;
import com.exception.CargoSafetyException;

public class TrainConsistService {

    Scanner sc = new Scanner(System.in);

    List<Bogie> bogies = new ArrayList<>();
    Set<String> bogieIds = new HashSet<>();
    LinkedList<Bogie> trainOrder = new LinkedList<>();
    LinkedHashSet<Bogie> orderedBogies = new LinkedHashSet<>();
    Map<String,Integer> bogieCapacityMap = new HashMap<>();


    // UC1 – Initialize Train
    public void initializeTrain() {

        bogies.clear();
        System.out.println("Train initialized successfully.");
    }


    // UC2 – Add Passenger Bogies
    public void addPassengerBogies() {

        try {

            System.out.println("Enter Bogie Name:");
            String name = sc.nextLine();

            System.out.println("Enter Bogie Type:");
            String type = sc.nextLine();

            System.out.println("Enter Capacity:");
            int capacity = sc.nextInt();
            sc.nextLine();

            Bogie bogie = new Bogie(name,type,capacity);

            bogies.add(bogie);

            System.out.println("Bogie added successfully.");

        } catch (InvalidCapacityException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }


    // UC3 – Unique Bogie IDs
    public void uniqueBogieIDs() {

        System.out.println("Enter Bogie ID:");
        String id = sc.nextLine();

        if(bogieIds.add(id))
            System.out.println("Bogie ID added.");
        else
            System.out.println("Duplicate Bogie ID not allowed.");
    }


    // UC4 – Ordered Train Consist
    public void orderedTrainConsist() {

        if(bogies.isEmpty()) {
            System.out.println("No bogies available.");
            return;
        }

        trainOrder.addAll(bogies);

        System.out.println("Train consist order:");

        for(Bogie b : trainOrder)
            System.out.println(b);
    }


    // UC5 – Preserve Insertion Order
    public void insertionOrderBogies() {

        orderedBogies.addAll(bogies);

        System.out.println("Bogies in insertion order:");

        for(Bogie b : orderedBogies)
            System.out.println(b);
    }


    // UC6 – Map Bogie Capacity
    public void mapBogieCapacity() {

        bogieCapacityMap.clear();

        for(Bogie b : bogies)
            bogieCapacityMap.put(b.getName(), b.getCapacity());

        System.out.println("Bogie Capacity Map:");

        for(String key : bogieCapacityMap.keySet())
            System.out.println(key + " -> " + bogieCapacityMap.get(key));
    }


    // UC7 – Sort Bogies by Capacity
    public void sortBogiesByCapacity() {

        bogies.sort(Comparator.comparingInt(Bogie::getCapacity));

        System.out.println("Bogies sorted by capacity:");

        bogies.forEach(System.out::println);
    }


    // UC8 – Filter Passenger Bogies using Streams
    public void filterBogies() {

        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        System.out.println("Filtered Bogies (capacity > 60):");

        filtered.forEach(System.out::println);
    }


    // UC9 – Group Bogies by Type
    public void groupBogiesByType() {

        Map<String,List<Bogie>> grouped =
                bogies.stream()
                        .collect(Collectors.groupingBy(Bogie::getType));

        System.out.println("Grouped Bogies:");

        grouped.forEach((type,list)->{

            System.out.println(type + ":");

            list.forEach(System.out::println);
        });
    }


    // UC10 – Count Total Seats using reduce
    public void countTotalSeats() {

        int totalSeats = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        System.out.println("Total Train Seating Capacity: " + totalSeats);
    }


    // UC11 – Regex Validation
    public void validateTrainAndCargoCodes() {

        System.out.println("Enter Train ID:");
        String trainId = sc.nextLine();

        System.out.println("Enter Cargo Code:");
        String cargoCode = sc.nextLine();

        Pattern trainPattern = Pattern.compile("TRN-\\d{4}");
        Pattern cargoPattern = Pattern.compile("PET-[A-Z]{2}");

        Matcher trainMatcher = trainPattern.matcher(trainId);
        Matcher cargoMatcher = cargoPattern.matcher(cargoCode);

        if(trainMatcher.matches())
            System.out.println("Valid Train ID");
        else
            System.out.println("Invalid Train ID");

        if(cargoMatcher.matches())
            System.out.println("Valid Cargo Code");
        else
            System.out.println("Invalid Cargo Code");
    }


    // UC12 – Safety Compliance Check
    public void safetyComplianceCheck() {

        List<GoodsBogie> goodsBogies = new ArrayList<>();

        System.out.println("Enter number of goods bogies:");
        int n = sc.nextInt();
        sc.nextLine();

        for(int i=0;i<n;i++) {

            System.out.println("Enter Bogie Type:");
            String type = sc.nextLine();

            System.out.println("Enter Cargo:");
            String cargo = sc.nextLine();

            goodsBogies.add(new GoodsBogie(type,cargo));
        }

        boolean isSafe =
                goodsBogies.stream()
                        .allMatch(b ->
                                !b.getBogieType().equalsIgnoreCase("Cylindrical")
                                        || b.getCargo().equalsIgnoreCase("Petroleum")
                        );

        if(isSafe)
            System.out.println("Train is SAFETY COMPLIANT");
        else
            System.out.println("Safety violation detected!");
    }


    // UC13 – Performance Comparison
    public void performanceComparison() {

        List<Bogie> testBogies = new ArrayList<>();

        System.out.println("Enter number of bogies:");
        int n = sc.nextInt();
        sc.nextLine();

        for(int i=0;i<n;i++) {

            System.out.println("Enter Bogie Name:");
            String name = sc.nextLine();

            System.out.println("Enter Type:");
            String type = sc.nextLine();

            System.out.println("Enter Capacity:");
            int capacity = sc.nextInt();
            sc.nextLine();

            try {
                testBogies.add(new Bogie(name,type,capacity));
            } catch (InvalidCapacityException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Enter minimum capacity:");
        int minCap = sc.nextInt();

        long loopStart = System.nanoTime();

        List<Bogie> loopResult = new ArrayList<>();

        for(Bogie b : testBogies)
            if(b.getCapacity() > minCap)
                loopResult.add(b);

        long loopEnd = System.nanoTime();

        long streamStart = System.nanoTime();

        List<Bogie> streamResult =
                testBogies.stream()
                        .filter(b -> b.getCapacity() > minCap)
                        .toList();

        long streamEnd = System.nanoTime();

        System.out.println("Loop Time: " + (loopEnd-loopStart));
        System.out.println("Stream Time: " + (streamEnd-streamStart));
    }


    // UC14 – Custom Exception Handling Demo
    public void createBogieWithValidation() {

        try {

            System.out.println("Enter Bogie Name:");
            String name = sc.nextLine();

            System.out.println("Enter Type:");
            String type = sc.nextLine();

            System.out.println("Enter Capacity:");
            int capacity = sc.nextInt();
            sc.nextLine();

            Bogie b = new Bogie(name,type,capacity);

            bogies.add(b);

            System.out.println("Bogie created successfully.");

        }
        catch(InvalidCapacityException e) {

            System.out.println("Invalid Bogie: " + e.getMessage());
        }
    }
    
 // UC15 – Safe Cargo Assignment Using try-catch-finally
    public void safeCargoAssignment() {

        try {

            System.out.println("Enter Bogie Shape (Cylindrical / Rectangular):");
            String shape = sc.nextLine();

            System.out.println("Enter Cargo Type:");
            String cargo = sc.nextLine();

            // Safety rule
            if(shape.equalsIgnoreCase("Rectangular") &&
               cargo.equalsIgnoreCase("Petroleum")) {

                throw new CargoSafetyException(
                    "Unsafe Cargo Assignment! Petroleum cannot be assigned to Rectangular bogie."
                );
            }

            System.out.println("Cargo assigned successfully.");

        }
        catch(CargoSafetyException e) {

            System.out.println("Error: " + e.getMessage());
        }
        finally {

            System.out.println("Cargo assignment process completed.");
        }
    }
    
 // UC16 – Bubble Sort for Passenger Bogie Capacities
    public void bubbleSortBogies() {

        System.out.println("\n***Bubble Sort: Passenger Bogie Capacities***");

        System.out.println("Enter number of passenger bogies:");
        int n = sc.nextInt();

        int[] capacities = new int[n];

        // Input capacities
        System.out.println("Enter capacities:");

        for(int i = 0; i < n; i++) {
            capacities[i] = sc.nextInt();
        }

        // Bubble Sort Algorithm
        for(int i = 0; i < n - 1; i++) {

            for(int j = 0; j < n - i - 1; j++) {

                if(capacities[j] > capacities[j + 1]) {

                    // Swap values
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                }
            }
        }

        // Display sorted result
        System.out.println("\nSorted Capacities:");

        for(int cap : capacities) {
            System.out.print(cap + " ");
        }

        System.out.println();
    }
    
 // UC17 – Sort Bogie Names Using Arrays.sort()
    public void sortBogieNamesUsingArrays() {

        System.out.println("\n=== Sort Bogie Names (Arrays.sort) ===");

        System.out.println("Enter number of bogie types:");
        int n = sc.nextInt();
        sc.nextLine();

        String[] bogieNames = new String[n];

        System.out.println("Enter bogie type names:");

        for(int i = 0; i < n; i++) {
            bogieNames[i] = sc.nextLine();
        }

        // Built-in sorting
        Arrays.sort(bogieNames);

        // Display result
        System.out.println("Sorted Bogie Names:");

        System.out.println(Arrays.toString(bogieNames));
    }
    
 // UC18 – Linear Search for Bogie ID
    public void linearSearchBogieID() {

        System.out.println("\n***Linear Search for Bogie ID***");

        System.out.println("Enter number of bogie IDs:");
        int n = sc.nextInt();
        sc.nextLine();

        String[] bogieIDs = new String[n];

        // Input bogie IDs
        System.out.println("Enter bogie IDs:");

        for(int i = 0; i < n; i++) {
            bogieIDs[i] = sc.nextLine();
        }

        // Search key
        System.out.println("Enter Bogie ID to search:");
        String searchKey = sc.nextLine();

        boolean found = false;

        // Linear Search
        for(int i = 0; i < n; i++) {

            if(bogieIDs[i].equals(searchKey)) {
                System.out.println("Bogie ID found at position: " + i);
                found = true;
                break;
            }
        }

        if(!found) {
            System.out.println("Bogie ID not found.");
        }
    }

}