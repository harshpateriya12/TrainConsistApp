## Overview

This use case sorts bogies based on a specific attribute using a **Comparator** in the Train Consist Management System.

## Goal

Arrange bogies in a particular order (for example by capacity or name) using a **custom comparison rule**.

## Actor

User

## Flow

1. User provides a collection of bogies.
2. System defines a **Comparator** for sorting criteria.
3. Bogies are sorted using the comparator.
4. Sorted bogies are displayed.

## Key Concepts

* Comparator interface
* Custom sorting logic
* Collection sorting
* Object comparison

## Example Output

**Sorted Bogies**

```
General - Capacity: 60
Sleeper - Capacity: 72
AC - Capacity: 80
```
