package ch03;
import ch02.Node;

public class LinkQueue {
    private Node front;
    private Node rear;

    public LinkQueue(){
        front = rear = null;
    }

    public void clear(){
        front = rear = null;
    }

    public int length(){
        Node p = front;
        int length = 0;
        if (p != null){
            length += 1;
        }
        return length;
    }

    public Object peek(){
        if (front!=null)
            return front.data;
        else
            return null;
    }

    //入队
    public void offer(Object x){
        Node p = new Node(x);
        if (front != null){
            rear.next = p;
            rear = p;
        }else
            front = rear = p;
    }

    //出队
    public Object poll(){
        if (front != null){
            Node p = front;
            front = front.next;
            if (p == rear)
                rear = null;
            return p.data;
        }else
            return -1;
    }

    public  boolean isEmpty(){
        boolean iQueue = false;
        if (front == rear)
            iQueue = true;
        else
            iQueue = false;
        return iQueue;
    }
}
