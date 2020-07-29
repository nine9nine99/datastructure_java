package ch09;

import ch05.BiTreeNode;
import ch07.ElementType;
import ch07.KeyType;
import ch07.RecordNode;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class Example9_2 {
    public static void main(String[] args){
        BSTree bsTree = new BSTree();
        int[] k = {50, 13, 63, 8, 36, 90, 5, 10, 18, 70};
        String[] item = {"Wang", "Li", "Zhang", "Liu", "Chen", "Yang", "Huang", "Zhao", "Wu", "Zhou"};
        KeyType[] key = new KeyType[k.length];
        ElementType[] elem = new ElementType[k.length];
        System.out.println("原序列：");
        for (int i = 0; i<k.length; i++){
            key[i] = new KeyType(k[i]); //创建关键字对象
            elem[i] = new ElementType(item[i]); //创建记录数据对象
            if (bsTree.insertBST(key[i], elem[i])){ //插入对象成功
                System.out.print("["+key[i]+","+elem[i]+"]");
            }
        }
        System.out.println("\n中序遍历二叉排序树");
        bsTree.inOrderTraverse(bsTree.root);//遍历
        System.out.println();
        KeyType keyvalue = new KeyType();
        keyvalue.key = 63;
        RecordNode found = (RecordNode) bsTree.searchBST(keyvalue);
        if (found!=null){
            System.out.println(found.element);
        }else {
            System.out.println("失败");
        }
    }
}
