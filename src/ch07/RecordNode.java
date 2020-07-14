package ch07;

public class RecordNode {
    public Comparable key; //关键字
    public Object element; //数据元素

    public RecordNode(Comparable key){
        this.key = key;
    }

    public RecordNode(Comparable key, Object element){
        this.key = key;
        this.element = element;
    }
}

