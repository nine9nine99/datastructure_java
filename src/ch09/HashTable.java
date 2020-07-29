package ch09;



public class HashTable<E> { //采用链地址法的哈希表类
    public LinkList[] table;

    public HashTable(int size){//哈希表对象数组
        this.table = new LinkList[size];
        for (int i=0; i<table.length; i++){
            table[i] = new LinkList(); //制造空单链表
        }
    }

    public int hash(int key){ //除留余数法哈希函数， 除数为哈希表长度
        return key%table.length;
    }

    public void insert(String element) throws Exception{
        int key = element.hashCode();
        int i = hash(key); //计算哈希地址
        table[i].insert(0 ,element);
    }

    public void printHashTable(){
        for (int i = 0; i<table.length; i++){
            System.out.print("table["+i+"]=");
            table[i].display();
        }
    }

    public Node_Hash search(String element) throws Exception{
        //在哈希表中搜索指定对象，查找成功，返回结点，否则返回null
        int key = element.hashCode(); //element的哈希码
        int i = hash(key);
        int index = table[i].indexOf(element); //返回数据元素在单链表中的位置
        if (index>=0){
            return (Node_Hash) table[i].get(index); //返回在单链表中找到的结点
        }else {
            return null;
        }
    }

    public boolean contain(String element) throws Exception{
        //假如搜索到对应的哈希值就返回true， 不包含就返回false
        return this.search( element) != null;
    }

    public boolean remove(String element) throws Exception{
        //删除指定对象，若删除成功，返回true，失败返回false
        int key = element.hashCode();
        int i = hash(key);
        int index = table[i].indexOf(element);
        if (index>=0){
            table[i].remove(index); //单链表中删除
            return true;
        }else {
            return false;
        }
    }
}
