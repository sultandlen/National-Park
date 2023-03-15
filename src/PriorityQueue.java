public class PriorityQueue {
    // array that removes items in ascending order
    private int maxSize;
    private NP[] priorityQueue;
    private int nItems;

    public PriorityQueue(int maxSize) { // constructor that takes one parameter
        this.maxSize = maxSize;
        this.priorityQueue = new NP[maxSize];
        this.nItems = 0;
    }

    public void insert(NP nationalPark){// put item at rear of priority queue
        if (nItems != maxSize){ // if the queue is not full;
            priorityQueue[nItems] = nationalPark; //increment rear and insert
            nItems++; // one more item
        }
        else{
            System.out.println("The queue is full!");
        }
    }

    public NP remove(){ // remove minimum item
        int minArea = -1;
        int index = 0;
        NP removed = priorityQueue[0];
        for(int i = 0; i < nItems; i++){
            if(minArea == -1){
                minArea = priorityQueue[0].getArea();
            }
            else if(priorityQueue[i].getArea() < minArea){ // searching for the minimum item
                minArea = priorityQueue[i].getArea();
                removed = priorityQueue[i];
                index = i; //index of the minimum item
            }
        }

        for (int j = index; j < nItems - 1; j++){ //shifting all elements that are after minimum item to front of queue
            priorityQueue[j] = priorityQueue[j + 1];
        }

        nItems--; // one less item
        return removed;
    }

    public boolean isEmpty(){ // true if queue is empty
        return (nItems == 0);
    }

    public boolean isFull(){ // true if queue is full
        return (nItems == maxSize);
    }

    public int size(){ // number of items in queue
        return nItems;
    }
}
