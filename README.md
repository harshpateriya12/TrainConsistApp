## Overview

This use case uses **Java Stream API** to validate safety rules for bogies in the Train Consist Management System.

## Goal

Filter and identify bogies that violate safety rules using **stream operations**.

## Actor

User

## Flow

1. User provides a collection of bogies.
2. System processes the bogies using **Stream API**.
3. Bogies violating safety rules are filtered.
4. The results are displayed.

## Key Concepts

* Java Stream API
* `filter()` operation
* Functional programming style
* Collection processing
* Safety rule validation

## Example Output

**Unsafe bogies detected**

```id="1r1co8"
Unsafe Bogie Found: Petroleum cargo in rectangular bogie
```

**No violations**

```id="dy3b2k"
All bogies satisfy safety rules
```
