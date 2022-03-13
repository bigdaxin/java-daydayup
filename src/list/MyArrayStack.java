package list;

public class MyArrayStack<T> extends AbstractStack<T> {
    private Object[] arr = new Object[2];

    private Integer size= 0;

    @Override
    public T pop() {
        return (T) arr[--size];
    }

    @Override
    public void push(T t) {
        if (size >= arr.length){
            Object[] arr = new Object[this.arr.length+10];
            for (int i= 0;i<this.arr.length;i++)arr[i] = this.arr[i];
            this.arr = arr;
        }
        arr[size++] = t;
    }
}
