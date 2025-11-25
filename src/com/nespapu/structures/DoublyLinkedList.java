package com.nespapu.structures;

/**
 * Doubly linked list implementation.
 *
 * @param <T> the type of elements stored in the list; must be comparable
 */
public class DoublyLinkedList<T extends Comparable<T>> {

    /**
     * Node class representing an element in the doubly linked list.
     */
    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> previous;

        Node(T value) {
            this.value = value;
        }
    }

    // Properties
    private Node<T> head;
    private int size;

    // Constructors
    public DoublyLinkedList() {
        size = 0;
    }

    // Methods

    /**
     * Inserts a new element at the first position of the list.
     *
     * @param value the value to insert
     */
    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
        size++;
    }

    /**
     * Inserts a new element at the last position of the list.
     *
     * @param value the value to insert
     */
    public void addLast(T value) {
        if (head == null) {
            addFirst(value);
            return;
        }

        Node<T> last = getLastNode();
        Node<T> newNode = new Node<>(value);
        newNode.previous = last;
        last.next = newNode;
        size++;
    }

    /**
     * Inserts a new element at the second position of the list.
     *
     * @param value the value to insert
     */
    public void addSecond(T value) {
        if (isEmpty()) {
            return;
        }

        Node<T> second = head.next;
        Node<T> newNode = new Node<>(value);
        newNode.previous = head;
        newNode.next = second;
        head.next = newNode;

        if (second != null) { // the list had more than one element
            second.previous = newNode;
        }
        size++;
    }

    /**
     * Inserts a new element at the second-to-last position of the list.
     *
     * @param value the value to insert
     */
    public void addSecondToLast(T value) {
        if (isEmpty()) {
            addFirst(value);
            return;
        }

        Node<T> last = getLastNode();
        Node<T> secondToLast = last.previous;

        if (secondToLast == null) { // the list had only one node
            addFirst(value);
        } else {
            Node<T> newNode = new Node<>(value);
            newNode.previous = secondToLast;
            newNode.next = last;
            secondToLast.next = newNode;
            last.previous = newNode;
            size++;
        }
    }

    /**
     * Removes the first element of the list, if any.
     */
    public void removeFirst() {
        if (head != null) {
            head = head.next;
            if (head != null) {
                head.previous = null;
            }
            size--;
        }
    }

    /**
     * Removes the second element of the list, if it exists.
     */
    public void removeSecond() {
        if (size >= 2) {
            Node<T> second = head.next;
            Node<T> third = second.next;

            head.next = third;
            if (third != null) {
                third.previous = head;
            }
            size--;
        }
    }

    /**
     * Removes the last element of the list, if any.
     */
    public void removeLast() {
        if (isEmpty()) {
            return;
        }

        Node<T> last = getLastNode();
        if (last.previous == null) { // only one element
            removeFirst();
        } else {
            Node<T> secondToLast = last.previous;
            secondToLast.next = null;
            last.previous = null;
            size--;
        }
    }

    /**
     * Removes the node that contains the largest value in the list.
     */
    public void removeLargestValue() {
        if (isEmpty()) {
            return;
        }

        if (size == 1) {
            removeFirst();
            return;
        }

        Node<T> current = head;
        Node<T> largest = head;

        while (current != null) {
            if (current.value.compareTo(largest.value) > 0) {
                largest = current;
            }
            current = current.next;
        }

        if (largest == head) {
            removeFirst();
        } else if (largest.next == null) {
            removeLast();
        } else {
            Node<T> previous = largest.previous;
            Node<T> next = largest.next;
            previous.next = next;
            next.previous = previous;
            size--;
        }
    }

    /**
     * Checks whether the list is empty.
     *
     * @return {@code true} if the list has no elements; {@code false} otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return the list size
     */
    public int size() {
        return size;
    }

    /**
     * Returns the last node in the list.
     *
     * @return the last node, or {@code null} if the list is empty
     */
    private Node<T> getLastNode() {
        Node<T> last = head;
        while (last.next != null) {
            last = last.next;
        }
        return last;
    }

    public void printList() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Node<T> current = head;
        while (current != null) {
            sb.append(current.value);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }

        sb.append("]");
        System.out.println(sb);
    }

    public void printListReverse() {
        if (head == null) {
            System.out.println("[]");
            return;
        }

        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        while (current != null) {
            sb.append(current.value);
            if (current.previous != null) {
                sb.append(", ");
            }
            current = current.previous;
        }

        sb.append("]");
        System.out.println(sb);
    }

}
