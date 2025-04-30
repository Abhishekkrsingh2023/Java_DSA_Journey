# Bit Manipulation Programs

## 1. Generate All Possible Subsets

```java
public static List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    int n = nums.length;
    int total = 1 << n;
    for (int mask = 0; mask < total; mask++) {
        List<Integer> subset = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) != 0) {
                subset.add(nums[i]);
            }
        }
        result.add(subset);
    }
    return result;
}
```

---

## 2. Find the Single Element (Every other element appears twice)

```java
public static int singleNumber(int[] nums) {
    int result = 0;
    for (int num : nums) {
        result ^= num;
    }
    return result;
}
```

---

## 3. XOR of Numbers from 1 to N

```java
public static int xor1ToN(int n) {
    int[] pattern = {n, 1, n + 1, 0};
    return pattern[n % 4];
}
```

---

## 4. XOR of Numbers from X to Y

```java
public static int xorRange(int x, int y) {
    return xor1ToN(y) ^ xor1ToN(x - 1);
}
```