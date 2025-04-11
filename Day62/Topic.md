# Minimum Coins Problem

## Overview
The minimum coins problem (also known as coin change problem) is a classic dynamic programming problem that finds the minimum number of coins needed to make a specific amount of money using given coin denominations.

## Problem Statement
- Given a set of coin denominations and a target amount
- Find the minimum number of coins required to make up that amount
- Each coin can be used unlimited times (unlimited supply)

## Example
```
Coins available: [1, 5, 10, 25]
Target amount: 67

Optimal solution: 
- Two 25¢ coins (50)
- One 10¢ coin (10)
- One 5¢ coin (5)
- Two 1¢ coins (2)
Total coins needed: 6
```

## Solution Approaches

### 1. Dynamic Programming
- Create a table to store minimum coins needed for each amount
- For each amount from 1 to target:
    - Try each coin denomination
    - Choose the minimum number of coins needed

### 2. Greedy Approach
- Only works with certain coin systems
- Start with largest denomination
- Not always optimal for all coin systems

## Time Complexity
- Dynamic Programming: O(amount * number of coin denominations)
- Space Complexity: O(amount)

## Applications
- Currency exchange systems
- Vending machines
- Payment processing systems