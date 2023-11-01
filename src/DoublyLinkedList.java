public class DoubleLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
        }
    }

    //Add element to the end of the list
    public void add(T data) {
        Node<T> newNode = new Node<>(data);

        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    // Add element at the beginning of the list
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    // Remove element from the beginning of the list
    public T removeFirst() {
        if (head == null) throw new IllegalStateException("Empty list");

        T data = head.data;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null; // list became empty
        }
        size--;

        return data;
    }

    // Remove element from the end of the list
    public T removeLast() {
        if (tail == null) throw new IllegalStateException("Empty list");

        T data = tail.data;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null; // list became empty
        }
        size--;

        return data;
    }

    // Get the size of the list
    public int size() {
        return size;
    }

    // Print the list from head to tail
    public void printForward() {
        Node<T> current = head;
        while (current != null) {
            System.out.println(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Print the list from tail to head
    public void printBackward() {
        Node<T> current = tail;
        while (current != null) {
            System.out.println(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.addFirst(0);

        list.printForward();
        list.printBackward();

        System.out.println("Removed (from head): " + list.removeFirst());
        System.out.println("Removed (from tail): " + list.removeLast());

        list.printForward();
    }
}
