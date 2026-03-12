

## Overview

This use case implements **Linear Search** to find a bogie ID from an **unsorted list of bogies** in the Train Consist Management System.

## Goal

Locate a bogie ID by checking each element sequentially until a match is found.

## Actor

User

## Flow

1. User provides a list of bogie IDs.
2. User enters the bogie ID to search.
3. System checks each ID one by one.
4. If a match is found, the search stops.
5. Result is displayed.

## Key Concepts

* Linear Search
* Sequential Traversal
* `equals()` for String comparison
* Early Termination
* O(n) search complexity

## Example Output

**When bogie is found**

```
Enter Bogie ID to search: BG103
Bogie ID found in the list
```

**When bogie is not found**

```
Enter Bogie ID to search: BG200
Bogie ID not found
```
