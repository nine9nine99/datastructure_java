package ch09;

public class Example9_5 {
    public static void main(String[] args) throws Exception {
        String[] name = {"Wang", "Li", "Zhang", "Liu", "Chen", "Yang", "Huang", "Zhao",
        "Wu", "Zhou", "Du"};
        //int[] number = {100, 213, 443, 221};
        HashTable<String> ht = new HashTable<String>(7);
        String elem1;
        System.out.println("插入元素");
        for (int i = 0; i<name.length; i++){
            ht.insert(name[i]);
            System.out.print(name[i]+"\t");
        }
        System.out.println("\n原哈希表：");
        ht.printHashTable();
        elem1 = "Du";
        System.out.println("查找"+elem1+", "+(ht.contain(elem1)?"":"不")+"成功");
        ht.printHashTable();
    }
}
