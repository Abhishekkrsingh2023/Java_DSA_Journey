# HashSet and HashMap in Java
## HashSet
A **`HashSet`** in Java is a part of the Java Collections Framework and is used to store a collection of unique elements. It provides fast access and does not allow duplicate values.

### **Basic Characteristics of HashSet**
- Stores only unique elements.
- Does not maintain insertion order.
- Provides O(1) time complexity for basic operations like `add()`, `remove()`, and `contains()`.

### **Common Methods of HashSet**
- `add(E e)`: Adds the specified element to the set if it is not already present.
- `remove(Object o)`: Removes the specified element from the set.
- `contains(Object o)`: Checks if the set contains the specified element.
- `size()`: Returns the number of elements in the set.
- `isEmpty()`: Checks if the set is empty.
- `clear()`: Removes all elements from the set.
- `iterator()`: Returns an iterator for traversing the elements.

## HashMap
A **`HashMap`** in Java is a part of the Java Collections Framework and is used to store key-value pairs. It allows fast retrieval, insertion, and deletion of elements using hashing.

### **Basic Characteristics of HashMap**
- Stores elements as key-value pairs.
- Keys must be unique, but values can be duplicated.
- Does not maintain insertion order.
- Provides O(1) time complexity for basic operations like `put()`, `get()`, and `remove()`.

### **Common Methods of HashMap**
- `put(K key, V value)`: Inserts a key-value pair into the HashMap.
- `get(Object key)`: Retrieves the value associated with the specified key.
- `remove(Object key)`: Removes the key-value pair for the given key.
- `containsKey(Object key)`: Checks if the key exists in the map.
- `containsValue(Object value)`: Checks if the value exists in the map.
- `size()`: Returns the number of key-value pairs in the map.
- `isEmpty()`: Checks if the map is empty.
- `clear()`: Removes all key-value pairs from the map.
- `keySet()`: Returns a set of all keys in the map.
- `values()`: Returns a collection of all values in the map.





