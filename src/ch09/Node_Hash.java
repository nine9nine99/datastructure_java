package ch09;

public class Node_Hash {
        public String data;//存放节点值
        public Node_Hash next;//后续节点的引用
        //无参构造体
        public Node_Hash(){
            this.data = null;
            this.next = null;
        }
        //一个参数的构造体
        public Node_Hash(String data){
            this.data = data;
            this.next = null;
        }
        public Node_Hash(String data, Node_Hash next){
            this.data = data;
            this.next = next;
        }

}
