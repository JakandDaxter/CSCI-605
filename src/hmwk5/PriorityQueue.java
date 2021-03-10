package hmwk5;

/**
 * Priority interface
 *
 * @author Aliana Tejeda & Bem Iordaah
 *
 * The hmwk5.PriorityQueue interface is of generic type and specifies the behavior of all implementing classes
 * It extends the Comparable interface and is thus able to determine the priority of objects placed
 * in the queue in order to insert them correctly
 *
 */

public interface PriorityQueue<T extends Comparable<T>>{

        boolean isEmpty();
        void enqueue(T toInsert);
        T dequeue();

}
