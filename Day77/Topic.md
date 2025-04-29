# Bit Manipulation Operations

## 1️⃣ Set a Specific Bit

Set the `i`th bit of number `n`:
```java
n = n | (1 << i);
```

## 2️⃣ Remove (Clear) a Bit

Clear the `i`th bit of number `n`:
```java
n = n & ~(1 << i);
```

## 3️⃣ Toggle a Bit

Toggle the `i`th bit of number `n`:
```java
n = n ^ (1 << i);
```

## 4️⃣ Count Bits to Convert One Number to Another

Count the number of bits to change `a` to `b`:
```java
    int num = x ^ y;
    int cnt = 0;
    while (num != 0) {
        cnt++;
        num = num & (num - 1);
    }
    return cnt;
// 'count' is the number of differing bits
```