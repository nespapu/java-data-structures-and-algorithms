# Java Data Structures and Algorithms

This repository contains clean, educational implementations of classic **sorting algorithms** and fundamental **data structures**, written in Java as part of my preparation for competitive IT exams and as a technical complement to my project **OOPPS**.

All classes and methods follow standard English terminology after a full refactor focused on consistency and clarity.

---

## 🎯 Purpose

- Strengthen understanding of classical data structures and algorithms  
- Maintain a clean and readable educational codebase  
- Support my exam preparation and reinforce Java fundamentals  
- Serve as a simple, transparent reference for algorithmic concepts

---

## 🧰 Tech Stack

- **Java 17+**
- No external dependencies
- Pure Java and standard library only

---

## 🔃 Sorting Algorithms

All sorting implementations include ascending and descending variants, plus small demo `main` methods.

- **BubbleSort**
- **MergeSort**
- **QuickSort** (Lomuto partition scheme)

---

## 📦 Data Structures

Generic, ready-to-use data structures implemented from scratch:

- **Stack** (LIFO)
- **Queue** (FIFO)
- **SinglyLinkedList**
- **DoublyLinkedList**

Each structure includes:
- basic operations (push/pop, enqueue/dequeue, etc.)
- size and state checks
- console-based demo methods

---

## 🧪 Examples

### Sorting Algorithms

#### QuickSort example
```java
int[] data = { 5, 1, 4, 2, 8 };

QuickSort.sortAscending(data);

System.out.println(Arrays.toString(data)); // [1, 2, 4, 5, 8]
```

Run the demo
```bash
javac -d out src/com/nespapu/sorting/*.java
java -cp out com.nespapu.sorting.QuickSortDemo
```

---

### Data Structures

#### Doubly Linked List
```java
DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
list.addLast(10);
list.addLast(20);
list.addLast(30);

list.printList();        // [10, 20, 30]
list.printListReverse(); // [30, 20, 10]
```

#### Singly Linked List
```java
SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
list.addLast(1);
list.addLast(2);
list.addLast(3);

list.printList(); // [1, 2, 3]
```

#### Stack
```java
Stack<String> stack = new Stack<>();
stack.push("A");
stack.push("B");
stack.push("C");

System.out.println(stack.pop());   // C
System.out.println(stack.peek());  // B
System.out.println(stack.isEmpty()); // false
```

#### Queue
```java
Queue<Integer> queue = new Queue<>();
queue.enqueue(10);
queue.enqueue(20);
queue.enqueue(30);

System.out.println(queue.dequeue()); // 10
System.out.println(queue.peek());    // 20
```

Run the demo
```bash
javac -d out src/com/nespapu/structures/*.java
java -cp out com.nespapu.structures.QueueDemo
```

---

## 📌 Next Steps

Planned improvements include:

- Adding unit tests (JUnit)  
- Expanding the repository with additional algorithms and data structures  

---

## 📄 License

MIT

---
