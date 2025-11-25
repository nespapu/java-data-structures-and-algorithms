package com.nespapu.structures;

public class DoublyLinkedListDemo {

    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        System.out.println("Is empty? " + list.isEmpty());

        list.addFirst(2);
        list.addFirst(1);      // List: 1, 2
        list.addLast(4);       // List: 1, 2, 4
        list.addSecond(10);    // List: 1, 10, 2, 4
        list.addSecondToLast(20); // List: 1, 10, 2, 20, 4

        System.out.println("Size after insertions: " + list.size());

        System.out.println("Removing largest value...");
        list.removeLargestValue();
        System.out.println("Size after removing largest: " + list.size());

        System.out.println("Removing first, second and last...");
        list.removeFirst();
        list.removeSecond();
        list.removeLast();
        System.out.println("Final size: " + list.size());

        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        
        System.out.print("Forward : ");
        list.printList();

        System.out.print("Backward: ");
        list.printListReverse();
    }
}
