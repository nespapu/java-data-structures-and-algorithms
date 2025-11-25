package com.nespapu.structures;

public class SinglyLinkedListDemo {

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        System.out.println("Is empty? " + list.isEmpty());

        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1); // List: 1 -> 2 -> 3

        list.addLast(4);  // List: 1 -> 2 -> 3 -> 4

        System.out.println("Size after insertions: " + list.size());
        System.out.println("List contents:");
        list.printElements();

        System.out.println("\nRemoving first element...");
        list.removeFirst();
        System.out.println("Size after removal: " + list.size());
        System.out.println("List contents now:");
        list.printElements();
    }
}
