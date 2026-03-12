## Overview

This use case uses **Java Stream API** to group bogies based on their type in the Train Consist Management System.

## Goal

Organize bogies by category (such as passenger or goods) using **stream grouping operations**.

## Actor

User

## Flow

1. User provides a collection of bogies.
2. System processes the collection using **Stream API**.
3. Bogies are grouped by their type using `groupingBy()`.
4. The grouped results are displayed.

## Key Concepts

* Java Stream API
* `Collectors.groupingBy()`
* Data grouping
* Collection processing
* Functional programming style

## Example Output

**Grouped Bogies**

```
Passenger : [Sleeper, AC, General]
Goods : [Coal, Cement, Petroleum]
```
