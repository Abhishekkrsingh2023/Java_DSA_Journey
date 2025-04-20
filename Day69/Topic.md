# Unbounded and Fractional Knapsack

## Unbounded Knapsack

- **Definition**: In the Unbounded Knapsack problem, you are given a set of items, each with a weight and a value. You can take an unlimited number of each item to maximize the total value in a knapsack of capacity `W`.
- **Key Point**: Unlimited supply of each item.
- **Approach**: Dynamic Programming (DP) is commonly used.
    - **DP Formula**:  
      `dp[w] = max(dp[w], dp[w - weight[i]] + value[i])` for all `i` and `w >= weight[i]`
- **Use Case**: Coin change problem.

## Fractional Knapsack

- **Definition**: In the Fractional Knapsack problem, you can break items into smaller parts. You can take any fraction of an item to maximize the total value in a knapsack of capacity `W`.
- **Key Point**: Items can be divided; take fractions.
- **Approach**: Greedy algorithm.
    - **Steps**:
        1. Calculate value/weight ratio for each item.
        2. Sort items by this ratio in descending order.
        3. Take as much as possible of the item with the highest ratio.
        4. Repeat until the knapsack is full.
- **Use Case**: Resource allocation where partial usage is allowed.

## Comparison

| Feature                | Unbounded Knapsack | Fractional Knapsack |
|------------------------|-------------------|--------------------|
| Item supply            | Unlimited         | Single, but divisible |
| Item divisibility      | No                | Yes                |
| Solution approach      | DP                | Greedy             |
