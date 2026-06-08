package Stack;

class Stack {
    private int[] stack;
    private int top;
    private int size;

  
    Stack(int size) {
        this.size = size;
        stack = new int[size];
        top = -1;
    }

    void push(int value) {
        if (top == size - 1) {
            System.out.println("Stack Overflow! Cannot push " + value);
        } else {
            top++;
            stack[top] = value;
            System.out.println(value + " pushed into stack.");
        }
    }


    int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow! Stack is empty.");
            return -1;
        } else {
            int value = stack[top];
            top--;
            return value;
        }
    }


    void display() {
        if (top == -1) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Stack elements:");
            for (int i = top; i >= 0; i--) {
                System.out.println(stack[i]);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {

     
        Stack s = new Stack(5);

   
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);

        s.display();

        System.out.println("\nPopped Element: " + s.pop());
        System.out.println("Popped Element: " + s.pop());

        System.out.println();
        s.display();
    }
}