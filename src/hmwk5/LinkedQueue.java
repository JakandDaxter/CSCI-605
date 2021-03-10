package hmwk5;

/**
 * LinkedQueue class
 *
 * @author Aliana Tejeda & Bem Iordaah
 *
 * The hmwk5.LinkedQueue class extends the Comparable class and implements the
 * PriorityQueue interface. It queues patrons using a first-in first-out approach
 * i.e. each new patron goes to the front of the line
 *
 */

public class LinkedQueue <T extends Comparable<T>> implements PriorityQueue<T> {

    class Node{
        T val;
        Node next;
        Node previous;
        public Node(T val){
            this.val = val;
        }
    }

    /**
     * Create head and tail nodes
     */

    private Node head;
    private Node tail;

    public LinkedQueue(){

    }

    /**
     * Set head node to null
     */

    @Override
    public boolean isEmpty() {
        return head==null;
    }

    /**
     * Method to insert higher priority patrons in front of queue
     * Check first to see if queue is empty
     */

    @Override
    public void enqueue(T toInsert) {
        if(isEmpty()){
            head = new Node(toInsert);
            tail = head;
            return;
        }
        Node newNode = new Node(toInsert);
        newNode.previous = tail;
        tail.next = newNode;
        tail = newNode;
    }

    /**
     * Method to remove highest priority patron from queue
     * Check first to see if queue is empty before proceeding
     */

    @Override
    public T dequeue() {
        if(isEmpty()) return null;

        if(tail == head) {
            Node toSend = tail;
            head = null;
            tail = null;
            return toSend.val;
        }

        Node toSend = tail;
        tail = tail.previous;
        tail.next = null;
        toSend.previous = null;
        return toSend.val;
    }
}
