import java.util.LinkedList;

// Generic Stack Interface
interface Stack<T> {
    void push(T element);
    T pop();
    T peek();
    boolean isEmpty();
}

// Linked List Implementation of Stack
class LinkedListStack<T> implements Stack<T> {
    private LinkedList<T> list = new LinkedList<>();

    @Override
    public void push(T element) {
        list.addFirst(element);
    }

    @Override
    public T pop() {
        return list.removeFirst();
    }

    @Override
    public T peek() {
        return list.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}

// Array Implementation of Stack
class ArrayStack<T> implements Stack<T> {
    private T[] array;
    private int top;

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        array = (T[]) new Object[capacity];
        top = -1;
    }

    @Override
    public void push(T element) {
        if (top == array.length - 1) {
            throw new StackOverflowError("Stack is full");
        }
        array[++top] = element;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return array[top--];
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return array[top];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }
}

// Main class to test the stack implementations
public class CombinedStack {
    public static void main(String[] args) {
        // Test LinkedListStack
        Stack<Integer> linkedListStack = new LinkedListStack<>();
        linkedListStack.push(10);
        linkedListStack.push(20);
        System.out.println("LinkedList Stack Peek: " + linkedListStack.peek());
        System.out.println("LinkedList Stack Pop: " + linkedListStack.pop());

        // Test ArrayStack
        Stack<String> arrayStack = new ArrayStack<>(5);
        arrayStack.push("Hello");
        arrayStack.push("World");
        System.out.println("Array Stack Peek: " + arrayStack.peek());
        System.out.println("Array Stack Pop: " + arrayStack.pop());
    }
}
