## Overview

This use case introduces **custom exception handling** to prevent creation of passenger bogies with invalid seat capacity.

## Goal

Ensure that bogies with **zero or negative capacity** cannot be created.

## Actor

User

## Flow

1. User attempts to create a passenger bogie.
2. System validates the capacity value.
3. If capacity ≤ 0, an `InvalidCapacityException` is thrown.
4. If valid, the bogie is created successfully.

## Key Concepts

* Custom Exception (`InvalidCapacityException`)
* Exception inheritance
* `throw` and `throws` keywords
* Fail-fast validation
* Defensive programming

## Example Output

**Invalid capacity**

```
Error: Bogie capacity must be greater than 0.
```

**Valid capacity**

```
Passenger bogie created successfully with capacity 72.
```
