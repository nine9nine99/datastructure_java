package ch05;

public class test {
    public static void main(String[] args){
        int[] a = {1,2,3};
        int[] b = new  int[10];
        for (int i=0; i<a.length; i++)
            b[i] = a[i];
    }
}
