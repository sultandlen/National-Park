public class Queue {
    private int maxSize; //size of queue
    private NP[] queue;
    private int rear;
    private int nItems;

    public Queue(int maxSize) { //constructor that takes one parameter
        this.maxSize = maxSize;
        this.queue = new NP[maxSize];
        this.rear = -1;
        this.nItems = 0;
    }

    public void insert (NP nationalPark){ // put item at rear of queue
        if(nItems != maxSize){ // if the queue is not full;
            queue[++rear] = nationalPark; //increment rear and insert
            nItems++; // one more item
        }else{
            System.out.println("The queue is full!");
        }
    }
    
    public NP remove(){ // take item from front of queue
        NP removed = queue[0];
        for (int i = 1; i < nItems; i++){
            queue[i - 1] = queue[i]; // shifting all elements to front of queue
        }
        nItems--; // one less item
        return removed;
    }

    public NP peek(){ // peek at front of queue
        return queue[0];
    }

    public boolean isEmpty(){ //true if stack is empty
        return (nItems == 0);
    }

    public boolean isFull(){ //true if stack is full
        return (nItems == maxSize);
    }

    public int size(){ // size of stack
        return nItems;
    }
}
