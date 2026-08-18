class MyCircularQueue {
    private int[] queue;
    private int head;
    private int tail;
    private int count;
    private int capacity;

    public MyCircularQueue(int k) {
        this.capacity = k;
        this.queue = new int[k];
        this.head = 0;
        this.tail = -1;
        this.count = 0;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        // Move tail forward circularly using modulo operator
        this.tail = (this.tail + 1) % this.capacity;
        this.queue[this.tail] = value;
        this.count++;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        // Move head forward circularly to remove the front element
        this.head = (this.head + 1) % this.capacity;
        this.count--;
        return true;
    }
    
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return this.queue[this.head];
    }
    
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return this.queue[this.tail];
    }
    
    public boolean isEmpty() {
        return this.count == 0;
    }
    
    public boolean isFull() {
        return this.count == this.capacity;
    }
}
