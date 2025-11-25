package structures;

/**
 * Simple singly linked list implementation.
 *
 * @param <T> the type of elements stored in the list
 */
public class SinglyLinkedList<T> {

    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

    private Node<T> head = null;
    private int size = 0;

    /**
     * Inserts a new element at the beginning of the list.
     *
     * @param value the value to insert
     */
    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    /**
     * Inserts a new element at the end of the list.
     *
     * @param value the value to insert
     */
    public void addLast(T value) {
        if (head == null) {
            head = new Node<>(value);
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node<>(value);
        }
        size++;
    }

    /**
     * Removes the first element of the list, if any.
     */
    public void removeFirst() {
        if (head != null) {
            head = head.next;
            size--;
        }
    }

    /**
     * Returns whether the list is empty.
     *
     * @return {@code true} if the list contains no elements; {@code false} otherwise
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
     * Prints the elements of the list to the standard output.
     * Elements are printed in order, separated by " -> ".
     */
    public void printElements() {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }

        Node<T> current = head;
        while (current.next != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println(current.value);
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addFirst(1);
        list.addLast(2);
        list.printElements();
    }
}
