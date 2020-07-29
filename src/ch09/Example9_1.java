package ch09;

import ch07.KeyType;
import ch07.RecordNode;
import ch07.SeqList;

import java.util.Scanner;
/**
 * 二分查找测试
 * */
public class Example9_1 {
    static SeqList ST = null;

    public static void createSearchList() throws Exception{
        int Maxsize = 20;
        ST = new SeqList(Maxsize);
        int curlen=0; //数组真实长度
        try {
            System.out.println("输入数组长度：");
            Scanner scanner = new Scanner(System.in);
            curlen = scanner.nextInt();
            if (curlen>Maxsize)
                curlen=-1;
        }catch (Exception e){
            System.out.print("Maxsize为20，curlen超过长度");
        }

        Scanner scanner = new Scanner(System.in);
        KeyType[] key = new KeyType[curlen];
        System.out.println("输入key值：");
        for (int i=0; i<curlen; i++){
            key[i] = new KeyType(scanner.nextInt());
        }
        for (int i=0; i<curlen; i++){ //记录顺序表
            RecordNode r = new RecordNode(key[i]);
            ST.insert(ST.length(), r);
        }
    }

    public static void main(String[] args) throws Exception{
        createSearchList();
        System.out.println("输入查找数字");
        Scanner sc = new Scanner(System.in);
        KeyType key1 = new KeyType(sc.nextInt());
        System.out.println(key1+"搜索结果："+ST.binarySearch(key1));
    }
}
