package ch02;

import java.util.Scanner;

public class LinkList implements IList {
    public Node head;

    public LinkList(){
        head = new Node();
    }

    public LinkList(int n, boolean Order) throws Exception{
        this();
        if (Order)
            created1(n);
        else
            created2(n);
    }

    //用尾插法建立单链表
    public void created1(int n) throws Exception{
        Scanner sc = new Scanner(System.in);
        for (int j=0; j<n; j++)
            insert(length(),sc.next());
    }
    //用头插法建立单链表
    public void created2(int n)throws Exception{
        Scanner sc = new Scanner(System.in);
        for (int j=0; j<n; j++)
            insert(0, sc.next());
    }

    //将一个已经存在的单链表清空
    @Override
    public void clear() {
        head.data = null;
        head.next = null;
    }

    @Override
    public boolean isEmpty() {
        return head.next == null;
    }

    //求带头节点的单链表的长度
    public int length(){
        Node p = head.next;//初始化，p指向首节点
        int length = 0;
        while(p != null){
            p = p.next;
            ++length;
        }
        return length;
    }
    //按位序号查找
    @Override
    public Object get(int i) throws Exception {
        Node p = head.next;
        int j = 0;
        while (p != null && j<i){//从首届点开始先后查找，直到p指向第i个节点或p为空
            p = p.next;
            ++j;
        }
        if (j>i||p == null){
            throw new Exception("第" + i + "个节点元素不存在");
        }
        return p.data;
    }

    @Override
    public void insert(int i, Object x) throws Exception {
        Node p = head;
        int j = -1;
        while (p != null && j<i-1){
            p = p.next;
            ++j;
        }
        if (j > i-1 || p ==null)
            throw new Exception("插入的位置不合法");
        Node s = new Node(x);
        s.next = p.next;
        p.next = s;

    }

    @Override
    public void remove(int i) throws Exception {
        Node p = head;
        int j = -1;
        while (p.next != null && j<i-1){
            p = p.next;
            ++j;
        }
        if (j>i-1 || p.next == null){
            throw new Exception("删除位置不合法");
        }
        p.next = p.next.next;
    }

    //按值查找
    @Override
    public int indexOf(Object x) {
        Node p = head.next;//初始化，p指向首节点，j为计数器
        int j = 0;
        //按值查询，直到p.data为x
        while (p != null && !p.data.equals(x)){
            p = p.next;
            ++j;
        }
        if (p != null)
            return j;
        else
            return -1;
    }

    public void display(){
        Node node = head.next;
        while (node != null){
            System.out.print(node.data + "");
            node = node.next;
        }
        System.out.println();
    }
}
