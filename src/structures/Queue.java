package com.nespapu.structures;

/**
 * Simple generic queue implementation using a singly linked list.
 *
 * @param <T> the type of elements stored in the queue
 */
public class Queue<T> {

    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    /**
     * Adds an element to the end of the queue.
     *
     * @param value the value to enqueue
     */
    public void enqueue(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /**
     * Removes and returns the element at the head of the queue.
     *
     * @return the dequeued value, or {@code null} if the queue is empty
     */
    public T dequeue() {
        T value = null;
        if (head != null) {
            value = head.value;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            size--;
        }
        return value;
    }

    /**
     * Returns the value at the head of the queue without removing it.
     *
     * @return the value at the head, or {@code null} if the queue is empty
     */
    public T peek() {
        return (head != null) ? head.value : null;
    }

    /**
     * Checks whether the queue is empty.
     *
     * @return {@code true} if the queue contains no elements; {@code false} otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of elements in the queue.
     *
     * @return the queue size
     */
    public int size() {
        return size;
    }

    /**
     * Prints the contents of the queue from head to tail.
     */
    public void printQueue() {
        if (head == null) {
            System.out.println("The queue is empty");
            return;
        }

        Node<T> current = head;
        while (current != null) {
            if (current.next != null) {
                System.out.print(current.value + " -> ");
            } else {
                System.out.print(current.value);
            }
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        assert queue.isEmpty();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.printQueue();
        assert queue.size() == 4;

        assert queue.dequeue().equals(1);
        assert queue.size() == 3;
        queue.printQueue();

        assert queue.peek().equals(2);
        assert queue.size() == 3;
    }
}
