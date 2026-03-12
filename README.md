## Overview

This use case uses the **Stream `reduce()` method** to perform aggregation operations on bogie data in the Train Consist Management System.

## Goal

Calculate a combined result such as **total passenger capacity** using the `reduce()` operation.

## Actor

User

## Flow

1. User provides a collection of passenger bogies.
2. System processes the collection using **Stream API**.
3. The `reduce()` method aggregates capacity values.
4. Total capacity is displayed.

## Key Concepts

* Java Stream API
* `reduce()` operation
* Aggregation of values
* Functional programming style
* Data summarization

## Example Output

**Total capacity calculation**

```id="3xdyvr"
Total Passenger Capacity: 320
```
