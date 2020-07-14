package ch07;

public class ElementType {
    public String data;     //自定义qitashuju

    public ElementType(String data){
        this.data = data;
    }

    public ElementType(){

    }
    public String toString(){   //覆盖toString方法
        return data;
    }
}
