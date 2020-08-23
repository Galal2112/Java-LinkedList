package list;

public class DoublyLinkedList<T> implements Listable<T> {
    private Node head = null;
    private Node tail = null;

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

        // update head
        if (index == 0) {
            addFirst(data);
            return;
        }

        // update tail
        if (index == size) {
            addLast(data);
            return;
        }

        // Create node
        Node node = new Node(data);

        Node n = head;
        int counter = 0;

        while (counter < index - 1) {
            n = n.next;
            counter ++;
        }

        node.prev = n;
        node.next = n.next;

        n.next.prev = node;
        n.next = node;
    }

    @Override
    public void addFirst(T data) {
        Node node = new Node(data);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    @Override
    public void addLast(T data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            tail = node;
         } else {
            tail.next = node;
            tail = node;
        }
    }

    @Override
    public T get(int index) {
        int size = size();
        if  (index < 0 || index >= size){
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
        if (n != null) n.data = data;
    }

    @Override
    public void remove(int index) {
        int size = size();

        if  (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("List size is " + size +" and you are trying to get at " + index);
        }
        int counter = 0;
        Node n;
        if (index > size / 2) {
            n = tail;
            while (n != null && counter < size - index - 1) {
                n = tail.prev;
                counter ++;
            }
        } else {
            n = head;
            while (n != null && counter < index){
                n = n.next;
                counter++;
            }
        }
        if (n == head) {
            head = n.next;
        } else if (n == tail) {
            tail = n.prev;
            tail.next = null;
        } else {
            n.prev.next = n.next;
            n.next.prev = n.prev;
        }
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
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

    private class Node{
        T data;
        Node prev;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

}
