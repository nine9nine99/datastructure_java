package ch02;

public interface IList {
    public void clear();
    public boolean isEmpty();
    public Object get(int i) throws Exception;
    public void insert(int i, Object x) throws Exception;
    public void remove(int i) throws Exception;
    public int indexOf(Object x);
}
