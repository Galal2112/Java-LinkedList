package list;

public class SinglyLinkedList<T> implements Listable<T> {

    private Node head = null;

    @Override
    public void add(T data) {
        addLast(data);
    }

    @Override
    public void add(int index, T data) {
        // Check index is available
        int size = size();
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("List size is " + size + " and you are trying to insert at " + index);
        }

        if (index == 0) {
            addFirst(data);
            return;
        }

        // Create node
        Node node = new Node(data);
        Node temp = head;
        int counter = 0;

        while (counter < index - 1) {
            temp = temp.next;
            counter ++;
        }

        if (temp.next == null) {
            temp.next = node; // insert in the last
        } else {
            // Insert at the middel, update pointers
            Node nxt = temp.next;
            temp.next = node;
            node.next = nxt;
        }
    }

    @Override
    public void addFirst(T data) {
        Node node = new Node(data);

        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    @Override
    public void addLast(T data) {
        Node node = new Node();
        node.data = data;
        node.next = null;

        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    @Override
    public T get(int index) {
        int size = size();
        if  (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("List size is " + size +" and you are trying to get at " + index);
        }
        int counter = 0;
        Node n = head;
        while (n != null && counter < index) {
            n = n.next;
            counter++;
        }
        if (n != null) return n.data;

        return null;
    }

    @Override
    public void set(int index, T data) {
        int size = size();
        if  (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("List size is " + size +" and you are trying to set at " + index);
        }
        int counter = 0;
        Node n = head;
        while (n != null && counter < index ) {
            n = n.next;
            counter++;
        }
        n.data = data;
    }

    @Override
    public void remove(int index) {
        int size = size();

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("List size is " + size + " and you are trying to get at " + index);
        }
        // index = 0
        if(index == 0) {
            head = head.next;
            return;
        }
        // del in middle
        int counter = 0;
        Node n = head;
        while (n != null && counter < index -1) {
            n = n.next;
            counter++;
        }
        n.next = n.next.next;
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public int size() {
        int counter = 0;
        Node temp = head;
        while (temp != null) {
            counter++;
            temp = temp.next;
        }
        return counter;
    }

    @Override
    public void printAll() {
        if (isEmpty()) {
            System.out.println("List is Empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    private class Node {
        T data;
        Node next;

        Node() { }

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
}

