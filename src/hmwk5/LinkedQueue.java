package hmwk5;

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
     * underlying heap storage
     */
    private Node head;
    private Node tail;

    public LinkedQueue(){

    }

    @Override
    public boolean isEmpty() {
        return head==null;
    }

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
