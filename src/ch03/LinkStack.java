package ch03;
import ch02.Node;
import javafx.scene.web.WebHistory;

import java.util.Objects;

public class LinkStack implements IStack{
    private Node top;
    public static void main(String[] args) throws Exception {
        LinkStack s = new LinkStack();
        s.push('A');
        Object a = s.peek();
        System.out.print(a);
    }

    @Override
    public void clear() {
        top = null;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public int length() {
        Node p = top;
        int length = 0;
        while (p.next!=null){
            length+=1;
            p = p.next;
        }
        return length;
    }

    @Override
    public Object peek() {
        if (!isEmpty())
            return top.data;
        else
            return null;
    }

    @Override
    public void push(Object x){
        Node p = new Node(x);
        p.next = top;
        top = p;
    }

    @Override
    public Object pop() {
        if (!isEmpty())
            return null;
        else {
            Node p = top;
            top = p.next;
            return p.data;
        }
    }


    public void display(){
        Node p = top;
        while (p!=null){
            System.out.println(p.data.toString()+" ");
            p = p.next;
        }
    }
}
