package ch05;

public class Stack {
    private int Length;
    private int top;
    private Object[] stack;

    public Stack(int length){
        this.Length = length;
        this.stack = new Object[length];
        this.top = 0;
    }

    public boolean isFull(){
        if (top==Length){
            System.out.print("栈满");
            return false;
        }else
            return true;
    }

    public boolean isEmpty(){
        if (top==0){
            return true;
        }else
            return false;
    }

    public void push(Object x){
        if (!isFull()){
            System.out.print("栈满");
        }else {
            stack[top] = x;
            top++;
        }
    }

    public Object pop(){
        Object out = null;
        if (isEmpty()){
            System.out.print("栈为空");
        }else {
            out = stack[top-1];
            --top;
        }
        return out;
    }

    public Object peek(){
        Object mid = null;
        if (isEmpty())
            System.out.print("栈为空");
        else {
            mid = stack[top-1];
        }
        return mid;
    }

    public void display(){
        if (isEmpty())
            System.out.print("栈为空");
        else {
            int begin = 0;
            while (begin<top){
                System.out.print(stack[begin]+" ");
                begin++;
            }
        }
    }

    public int getLength(){
        return Length;
    }

    public int getTop(){
        return top;
    }


}
