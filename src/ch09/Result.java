package ch09;

//B-树查找结果类型
public class Result { //查找结果类型
    public Node resultNode; //指向找到的结点
    public int i; //在结点中的关键码序号
    public boolean found; //true：找到，false：未找到
}
