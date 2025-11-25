package com.nespapu.structures;

public class QueueDemo {

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();

        System.out.println("Is empty? " + queue.isEmpty());

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        System.out.println("Size after enqueues: " + queue.size());
        System.out.println("Queue contents (head to tail):");
        queue.printQueue();

        System.out.println("\nDequeuing one element: " + queue.dequeue());
        System.out.println("Size after dequeue: " + queue.size());
        System.out.println("Queue contents now:");
        queue.printQueue();

        System.out.println("\nPeek: " + queue.peek());
        System.out.println("Size after peek: " + queue.size());
    }
}
