package ch02;

public class parctice_1 {
    public static void main(String[] args) throws Exception {
        SqList L = new SqList(6);
        L.insert(0,10);
        L.insert(1,11);
        L.insert(2,12);
        System.out.println("调转前的数组元素");
        L.display();
        System.out.println("调整后的数组元素");
        L.exchange();
        L.display();
    }
}
