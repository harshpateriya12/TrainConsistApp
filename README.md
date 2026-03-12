

## Overview

This use case adds **defensive validation** before performing search operations in the Train Consist Management System. If a user tries to search when no bogies exist, the system stops the operation and informs the user.

## Goal

Prevent search operations on an empty train by throwing an exception early.

## Actor

User

## Flow

1. User initiates a search operation.
2. System checks if the bogie collection is empty.
3. If empty, an `IllegalStateException` is thrown.
4. The search operation stops and an error message is displayed.

## Key Concepts

* Defensive Programming
* `IllegalStateException`
* Fail-Fast Principle
* State Validation
* Runtime Exception Handling

## Example Output

**When no bogies exist**

```
Error: Search cannot be performed. No bogies exist in the train.
```

**When bogie exists**

```
Enter Bogie name: Sleeper
Bogie Found: Sleeper | Capacity: 72
```
