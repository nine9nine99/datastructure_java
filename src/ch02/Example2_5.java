package ch02;

import java.util.Scanner;

public class Example2_5 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int m = 0, n = 0;           //LA中的数据为m，LB中的数据为B
        System.out.println("请输入LA中的结点个数：");
        m = sc.nextInt();
        System.out.println("请按递增的方式输入" + m + "个数字：");
        LinkList LA = new LinkList(m, true);
        System.out.println("请输入LB中的结点个数：");
        n = sc.nextInt();
        System.out.println("请按递增的方式输入" + n + "个数字：");
        LinkList LB = new LinkList(n, true);
        System.out.println("将单链表LA和LB归并后新的单链表LA中的各个数据元素：");
        mergeList_L(LA,LB).display();
    }

    public static LinkList mergeList_L(LinkList LA, LinkList LB){
        Node pa = LA.head.next;     //  初始化LA的首节点pa
        Node pb = LB.head.next;     //  初始化LB的首节点pb
        Node pc = LA.head;          //  初始化LA的头节点pc
        int da, db;
        while (pa != null&&pb != null){
            da = Integer.valueOf(pa.data.toString());   //把字符串转化成整数
            db = Integer.valueOf(pb.data.toString());   //把字符串转化成整数
            if (da <= db){
                pc.next = pa;
                pc = pa;
                pa = pa.next;
            }else {
                pc.next = pb;
                pc = pb;
                pb = pb.next;
            }
        }
        pc.next = (pa != null ? pa:pb);//插入剩余点数。有限pa
        return LA;
    }
}
