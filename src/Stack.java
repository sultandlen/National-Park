public class Stack{
    private int maxSize; // size of stack array
    private NP[] stack;
    private int top; // top of stack

    public Stack(int maxSize) { // constructor that takes one parameter
        this.maxSize = maxSize; // set array size
        this.stack = new NP[maxSize]; // create array
        this.top = -1; // no items yet
    }

    public void push(NP nationalPark){ // put item on top of stack
        stack[++top] = nationalPark; // increment top, insert item
    }

    public NP pop(){ // take item from top of stack
        NP popped = stack[top];
        stack[top] = null;
        top--; //increase top
        return popped;
    }

    public NP peek(){ // peek at top of stack
        return stack[top];
    }

    public boolean isEmpty(){ // true if stack is empty
        return (top == -1);
    }

    public boolean isFull(){ // true if stack is full
        return (top == maxSize - 1);
    }
}