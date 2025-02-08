Topic : Strings & StringBuilder

**Strings in Java**

In Java, a **String** is an immutable sequence of characters, represented by the `String` class. Once a `String` object is created, its value cannot be changed. Any modification, such as concatenation or replacement, creates a new `String` object in memory.

### Key Features of Strings:
- **Immutable**: Cannot be modified after creation.
- **Stored in String Pool**: String literals are stored in a special memory area called the String Pool.
- **Memory-Intensive Modifications**: Every modification creates a new object, leading to increased memory usage.

### Common String Methods:
- `length()`: Returns the number of characters in the string.
- `charAt(index)`: Retrieves the character at the specified index.
- `toUpperCase()`, `toLowerCase()`: Converts the string to uppercase or lowercase.
- `trim()`: Removes leading and trailing spaces.
- `replace(old, new)`: Replaces characters or substrings.
- `substring(start, end)`: Extracts a part of the string.

---

**StringBuilder in Java**

`StringBuilder` is a mutable alternative to `String`, designed for efficient string manipulation. Unlike `String`, `StringBuilder` allows modifications without creating new objects, making it faster and more memory-efficient.

### Key Features of StringBuilder:
- **Mutable**: Allows modifications to the same object.
- **Efficient for Modifications**: No new object creation like `String`.
- **Not Thread-Safe**: Unlike `StringBuffer`, `StringBuilder` is not synchronized.

### Common StringBuilder Methods:
- `append(str)`: Adds a string to the end.
- `insert(index, str)`: Inserts a string at a specified index.
- `replace(start, end, str)`: Replaces part of the string.
- `delete(start, end)`: Removes characters within a range.
- `reverse()`: Reverses the string.

### When to Use?
- Use **`String`** when the value won’t change frequently.
- Use **`StringBuilder`** when modifying strings frequently (e.g., loops, concatenations).

