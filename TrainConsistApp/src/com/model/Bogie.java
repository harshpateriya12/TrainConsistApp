package com.model;

import com.exception.InvalidCapacityException;

public class Bogie {

    private String name;
    private String type;
    private int capacity;

    public Bogie(String name, String type, int capacity) throws InvalidCapacityException {

        if(capacity <= 0) {
            throw new InvalidCapacityException("Invalid Bogie Capacity! Capacity must be greater than 0.");
        }

        this.name = name;
        this.type = type;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return name + " | " + type + " | Capacity: " + capacity;
    }
}