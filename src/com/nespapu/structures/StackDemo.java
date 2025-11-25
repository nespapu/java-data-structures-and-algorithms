package com.nespapu.structures;

public class StackDemo {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        System.out.println("Is empty? " + stack.isEmpty());

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Size after pushes: " + stack.size());
        System.out.println("Stack contents (top to bottom):");
        stack.printStack();

        System.out.println("\nPopping one element: " + stack.pop());
        System.out.println("Size after pop: " + stack.size());
        System.out.println("Top element (peek): " + stack.peek());

        System.out.println("\nStack contents now:");
        stack.printStack();
    }
}
