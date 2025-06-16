package basics.stacks;

class StackUsingLinkedList {
    // Node class
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top; // top of the stack

    public StackUsingLinkedList() {
        this.top = null;
    }

    // Push an element onto the stack
    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top; // point new node to previous top
        top = newNode;       // update top to new node
    }

    // Pop an element from the stack
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow");
        }
        int popped = top.data;
        top = top.next;
        return popped;
    }

    // Peek the top element
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return top.data;
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Display stack contents
    public void printStack() {
        Node current = top;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Main method for testing
    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.printStack();         // 30 -> 20 -> 10 -> null
        System.out.println(stack.pop()); // 30
        System.out.println(stack.peek()); // 20
        stack.printStack();         // 20 -> 10 -> null
    }
}
