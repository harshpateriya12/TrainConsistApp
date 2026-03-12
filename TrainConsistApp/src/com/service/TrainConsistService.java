package com.service;

import com.model.Bogie;

import java.util.*;
import java.util.stream.Collectors;

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

    // UC9
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
    
}