package ch02;

public class Example2_1 {
    public static void main(String[] args) throws Exception {
        SqList L = new SqList(10);
        L.insert(0,'a');
        L.insert(1,'b');
        L.insert(2,'c');
        L.insert(3, 'd');
        L.insert(4,'z');
        int order = L.indexOf('z');//接收indexOf函数给出的值
        if (order != -1)
            System.out.println("The position of z is " + order);
        else
            System.out.println("There is not z in this list");
    }
}
