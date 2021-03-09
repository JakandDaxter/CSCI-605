public interface PriorityQueue<T extends Comparable<T>>{

        int maxChild(int index);
        boolean isEmpty();
        void enqueue(T toInsert);
        T dequeue();

}
