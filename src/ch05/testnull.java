package ch05;

import ch03.LinkStack;

public class testnull {
    public static void main(String[] args) throws Exception {
        BiTreeNode a = new BiTreeNode('A', null,null);
        LinkStack s = new LinkStack();
        s.push(a);
        BiTreeNode b = new BiTreeNode();
        b = (BiTreeNode) s.peek();
        System.out.print(b.data);
    }
}
