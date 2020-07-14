package ch05;

public class Example5_5 {
    public static void main(String[] args) throws Exception {
        String preOrder = "ABDEGCFH";
        String inOrder = "DBGEAFHC";
        BiTree T = new BiTree(preOrder, inOrder, 0, 0, preOrder.length());


        System.out.println("后根遍历：");
        T.preRootTraverse();
    }
}
