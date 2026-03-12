## Overview

This use case compares the **execution time of loop-based logic and stream-based logic** to understand performance differences in the Train Consist Management System.

## Goal

Measure and display execution time using `System.nanoTime()`.

## Actor

User

## Flow

1. User prepares a collection of bogies.
2. System records the start time using `System.nanoTime()`.
3. Filtering is performed using a loop or stream.
4. System records the end time.
5. Execution time is calculated and displayed.

## Key Concepts

* `System.nanoTime()`
* Performance benchmarking
* Loop-based processing
* Stream API processing
* Execution time measurement

## Example Output

**Loop Execution**

```
Loop execution time: 15000 ns
```

**Stream Execution**

```
Stream execution time: 21000 ns
```
