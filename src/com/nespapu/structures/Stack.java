package com.nespapu.structures;

/**
 * Simple generic stack implementation using a singly linked list.
 *
 * @param <T> the type of elements stored in the stack
 */
public class Stack<T> {

    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

    private Node<T> top = null;
    private int size = 0;

    /**
     * Pushes a new element onto the top of the stack.
     *
     * @param value the value to push
     */
    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = top;
        top = newNode;
        size++;
    }

    /**
     * Removes and returns the value at the top of the stack.
     *
     * @return the popped value, or {@code null} if the stack is empty
     */
    public T pop() {
        if (top == null) {
            return null;
        }
        T value = top.value;
        top = top.next;
        size--;
        return value;
    }

    /**
     * Returns the value at the top of the stack without removing it.
     *
     * @return the top value, or {@code null} if the stack is empty
     */
    public T peek() {
        return (top != null) ? top.value : null;
    }

    /**
     * Checks whether the stack is empty.
     *
     * @return {@code true} if the stack contains no elements; {@code false} otherwise
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return the stack size
     */
    public int size() {
        return size;
    }

    /**
     * Prints the stack from top to bottom.
     */
    public void printStack() {
        if (top == null) {
            System.out.println("Stack is empty");
            return;
        }

        Node<T> current = top;
        while (current != null) {
            System.out.println("| " + current.value + " |");
            current = current.next;
        }
    }
}
