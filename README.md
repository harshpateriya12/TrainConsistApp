## Overview

This use case ensures **safe cargo assignment** in the Train Consist Management System by handling unsafe operations using **try-catch-finally** blocks.

## Goal

Prevent the system from crashing when unsafe cargo (e.g., petroleum in a rectangular bogie) is assigned.

## Actor

User

## Flow

1. User attempts to assign cargo to a goods bogie.
2. System checks cargo and bogie shape compatibility.
3. If unsafe, a `CargoSafetyException` is thrown.
4. The exception is caught and an error message is displayed.
5. The `finally` block executes logging or cleanup.

## Key Concepts

* try-catch-finally
* Runtime Exception
* Custom Exception (`CargoSafetyException`)
* Graceful error handling
* Program stability

## Example Output

**Unsafe cargo assignment**

```
Error: Petroleum cannot be assigned to a rectangular bogie.
Operation completed.
```

**Safe cargo assignment**

```
Cargo assigned successfully to goods bogie.
Operation completed.
```
