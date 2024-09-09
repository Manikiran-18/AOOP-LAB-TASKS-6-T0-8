import java.util.PriorityQueue;

// Generic Priority Queue Class
class GenericPriorityQueue<T extends Comparable<T>> {
    private PriorityQueue<T> queue;

    public GenericPriorityQueue() {
        queue = new PriorityQueue<>();
    }

    public void enqueue(T element) {
        queue.offer(element);
    }

    public T dequeue() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}

// Main class to test the priority queue implementations
public class CombinedPriorityQueue {
    public static void main(String[] args) {
        // Test Integer Priority Queue
        GenericPriorityQueue<Integer> intQueue = new GenericPriorityQueue<>();
        intQueue.enqueue(10);
        intQueue.enqueue(5);
        intQueue.enqueue(20);
        System.out.println("Dequeue from Integer Queue: " + intQueue.dequeue());

        // Test String Priority Queue
        GenericPriorityQueue<String> stringQueue = new GenericPriorityQueue<>();
        stringQueue.enqueue("Apple");
        stringQueue.enqueue("Banana");
        stringQueue.enqueue("Cherry");
        System.out.println("Dequeue from String Queue: " + stringQueue.dequeue());
    }
}
