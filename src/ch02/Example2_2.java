package ch02;

import java.util.Scanner;

public class Example2_2 {
    public static void main(String[] args) throws Exception{
        int n  = 10;
        SqList L = new SqList(80);
        for (int i = 0; i < n; i++)
            L.insert(i,i);
        System.out.println("请输入i的值");
        int i = new Scanner(System.in).nextInt();
        if (0<i&&i<=n){
            System.out.println("i的前驱节点是"+L.get(i-1));
        }else {
            System.out.println("第"+ i +"个前驱节点不存在");
        }
    }
}
