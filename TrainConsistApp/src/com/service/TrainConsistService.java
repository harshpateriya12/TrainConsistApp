package com.service;

import com.model.Bogie;
import com.model.GoodsBogie;

import java.util.*;
import java.util.stream.Collectors;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TrainConsistService {

    Scanner sc = new Scanner(System.in);

    List<String> bogieNames = new ArrayList<>();
    Set<String> uniqueIDs = new HashSet<>();
    LinkedList<String> trainOrder = new LinkedList<>();
    LinkedHashSet<String> orderedBogies = new LinkedHashSet<>();
    HashMap<String, Integer> bogieCapacityMap = new HashMap<>();
    List<Bogie> bogieObjects = new ArrayList<>();


    // UC1 to initialize
    public void initializeTrain() {

        List<String> trainConsist = new ArrayList<>();

        System.out.println("Train initialized.");
        System.out.println("Initial Bogie Count: " + trainConsist.size());
    }

    // UC2 to add passenger Bogies
    public void addPassengerBogies() {

        System.out.println("Enter number of bogies:");
        int n = sc.nextInt();
        sc.nextLine();

        for(int i=0;i<n;i++) {
            System.out.println("Enter Bogie Name:");
            bogieNames.add(sc.nextLine());
        }

        System.out.println("Bogies: " + bogieNames);
    }

    // UC3 for giving unique Bogie IDs
    public void uniqueBogieIDs() {

        System.out.println("Enter number of Bogie IDs:");
        int n = sc.nextInt();
        sc.nextLine();

        for(int i=0;i<n;i++) {
            uniqueIDs.add(sc.nextLine());
        }

        System.out.println("Unique IDs: " + uniqueIDs);
    }

    // UC4 for ordered bogies
    public void orderedTrainConsist() {

        System.out.println("Enter number of bogies:");
        int n = sc.nextInt();
        sc.nextLine();

        for(int i=0;i<n;i++) {
            trainOrder.add(sc.nextLine());
        }

        System.out.println("Train Order: " + trainOrder);
    }

    // UC5 for maintaining insertion order
    public void insertionOrderBogies() {

        System.out.println("Enter number of bogies:");
        int n = sc.nextInt();
        sc.nextLine();

        for(int i=0;i<n;i++) {
            orderedBogies.add(sc.nextLine());
        }

        System.out.println("Bogies in insertion order: " + orderedBogies);
    }

    // UC6 for mapping bogies with capacity
    public void mapBogieCapacity() {

        System.out.println("Enter number of bogies:");
        int n = sc.nextInt();
        sc.nextLine();

        for(int i=0;i<n;i++) {

            System.out.println("Enter Bogie Name:");
            String name = sc.nextLine();

            System.out.println("Enter Capacity:");
            int cap = sc.nextInt();
            sc.nextLine();

            bogieCapacityMap.put(name,cap);
        }

        System.out.println("Bogie Capacity Map: " + bogieCapacityMap);
    }

    // UC7 for sorting based on capacity
    public void sortBogiesByCapacity() {

        System.out.println("Enter number of bogies:");
        int n = sc.nextInt();
        sc.nextLine();

        for(int i=0;i<n;i++) {

            System.out.println("Enter Bogie Name:");
            String name = sc.nextLine();

            System.out.println("Enter Type:");
            String type = sc.nextLine();

            System.out.println("Enter Capacity:");
            int cap = sc.nextInt();
            sc.nextLine();

            bogieObjects.add(new Bogie(name,type,cap));
        }

        bogieObjects.sort(Comparator.comparingInt(Bogie::getCapacity));

        bogieObjects.forEach(System.out::println);
    }

    // UC8 for filtering based on capacity
    public void filterBogies() {

        System.out.println("Enter minimum capacity:");
        int min = sc.nextInt();

        List<Bogie> filtered =
                bogieObjects.stream()
                        .filter(b -> b.getCapacity() > min)
                        .collect(Collectors.toList());

        filtered.forEach(System.out::println);
    }

    // UC9 for grouping bogies by types
    public void groupBogiesByType() {

        Map<String,List<Bogie>> grouped =
                bogieObjects.stream()
                        .collect(Collectors.groupingBy(Bogie::getType));

        grouped.forEach((type,bogies) -> {

            System.out.println("\nType: "+type);

            bogies.forEach(System.out::println);
        });
        
    }
     
     // UC10 for counting total seats
        public void countTotalSeats() {

            if(bogieObjects.isEmpty()) {
                System.out.println("No bogies available. Please add bogies first (UC7).");
                return;
            }

            int totalSeats =
                    bogieObjects.stream()
                            .map(b -> b.getCapacity())
                            .reduce(0, Integer::sum);

            System.out.println("\nTotal Seating Capacity of Train: " + totalSeats);
        }
        
     // UC11 for validatiing Train And Cargo codes
        public void validateTrainAndCargoCodes() {

            System.out.println("\n=== Train ID & Cargo Code Validation ===");

            System.out.println("Enter Train ID:");
            String trainId = sc.next();

            System.out.println("Enter Cargo Code:");
            String cargoCode = sc.next();

            // Regex patterns
            String trainRegex = "TRN-\\d{4}";
            String cargoRegex = "PET-[A-Z]{2}";

            Pattern trainPattern = Pattern.compile(trainRegex);
            Pattern cargoPattern = Pattern.compile(cargoRegex);

            Matcher trainMatcher = trainPattern.matcher(trainId);
            Matcher cargoMatcher = cargoPattern.matcher(cargoCode);

            if(trainMatcher.matches())
                System.out.println("Train ID is VALID");
            else
                System.out.println("Train ID is INVALID");

            if(cargoMatcher.matches())
                System.out.println("Cargo Code is VALID");
            else
                System.out.println("Cargo Code is INVALID");
        }
        
        
     // UC12 for safety checks
        public void safetyComplianceCheck() {

            System.out.println("\n=== Safety Compliance Check for Goods Bogies ===");

            List<GoodsBogie> goodsBogies = new ArrayList<>();

            System.out.println("Enter number of goods bogies:");
            int n = sc.nextInt();
            sc.nextLine();

            for(int i=0;i<n;i++) {

                System.out.println("Enter Bogie Type (Cylindrical / Box / Flat):");
                String type = sc.nextLine();

                System.out.println("Enter Cargo Type:");
                String cargo = sc.nextLine();

                goodsBogies.add(new GoodsBogie(type, cargo));
            }

            System.out.println("\nGoods Bogies Entered:");
            goodsBogies.forEach(System.out::println);

            boolean isSafe =
                    goodsBogies.stream()
                            .allMatch(b ->
                                    !b.getBogieType().equalsIgnoreCase("Cylindrical")
                                            || b.getCargo().equalsIgnoreCase("Petroleum")
                            );

            if(isSafe)
                System.out.println("\nTrain is SAFETY COMPLIANT");
            else
                System.out.println("\nSafety violation detected! Train is NOT compliant.");
        }
        
     // UC13 for comparing performances of loop and stream
        public void performanceComparison() {

            System.out.println("\n***Performance Comparison: Loop vs Stream***");

            List<Bogie> testBogies = new ArrayList<>();

            System.out.println("Enter number of bogies for performance test:");
            int n = sc.nextInt();
            sc.nextLine();

            for(int i = 0; i < n; i++) {

                System.out.println("Enter Bogie Name:");
                String name = sc.nextLine();

                System.out.println("Enter Type:");
                String type = sc.nextLine();

                System.out.println("Enter Capacity:");
                int capacity = sc.nextInt();
                sc.nextLine();

                testBogies.add(new Bogie(name, type, capacity));
            }

            System.out.println("\nEnter minimum capacity for filtering:");
            int minCapacity = sc.nextInt();

            //Filtering based on loops

            long loopStart = System.nanoTime();

            List<Bogie> loopResult = new ArrayList<>();

            for(Bogie b : testBogies) {
                if(b.getCapacity() > minCapacity) {
                    loopResult.add(b);
                }
            }

            long loopEnd = System.nanoTime();

            long loopTime = loopEnd - loopStart;

            //Filtering based on streams

            long streamStart = System.nanoTime();

            List<Bogie> streamResult =
                    testBogies.stream()
                            .filter(b -> b.getCapacity() > minCapacity)
                            .toList();

            long streamEnd = System.nanoTime();

            long streamTime = streamEnd - streamStart;

            //Results 

            System.out.println("\nLoop Result Size: " + loopResult.size());
            System.out.println("Stream Result Size: " + streamResult.size());

            System.out.println("\nLoop Execution Time (nanoseconds): " + loopTime);
            System.out.println("Stream Execution Time (nanoseconds): " + streamTime);
        }
    
}