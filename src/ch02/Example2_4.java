package ch02;

public class Example2_4 {
    public static void main(String[] args) throws Exception{
        System.out.println("请输入单链表中的10个节点值:");
        LinkList L = new LinkList(10, true);
        System.out.println("删除重复节点前单链表中的各个节点值为:");
        L.display();
        removeRepearElem(L);//删除重复节点值
        System.out.println("删除重复节点后单链表中的各个节点值为:");//输出
        L.display();
    }

    public static void removeRepearElem(LinkList L) throws Exception{
        Node p = L.head.next, q;
        while (p != null){
            int order = L.indexOf(p.data);
            q = p.next;//下一个值
            while (q != null){
                if ((p.data).equals(q.data))
                    L.remove(order + 1);//删除重复点
                else
                    ++order;
                q = q.next;
            }
            p = p.next;//进入下一个节点进行比对
        }
    }
}
