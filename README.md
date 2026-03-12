
## Overview

This use case sorts **bogie type names alphabetically** using Java’s built-in `Arrays.sort()` method in the Train Consist Management System.

## Goal

Organize bogie names efficiently using Java’s optimized sorting library.

## Actor

User

## Flow

1. User provides bogie type names.
2. System calls `Arrays.sort()` on the array.
3. Java sorts the bogie names automatically.
4. Sorted bogie names are displayed.

## Key Concepts

* `Arrays.sort()` method
* Natural ordering of strings
* Efficient sorting (O(n log n))
* Use of Java standard libraries

## Example Output

**Before Sorting**

```
[BogieAC, Sleeper, General, Pantry]
```

**After Sorting**

```
[General, BogieAC, Pantry, Sleeper]
```
