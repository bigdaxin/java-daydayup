package list;

public class MyArrayQueue<E> extends AbstractQueue<E> {
    private Object[] arr = new Object[2];

    private Integer size = 0;

    @Override
    public E pop() {
        if (size == 0) return null;
        Object res = arr[0];
        for (int i = 0; i < size; i++) {
            arr[i] = arr[i+1];
        }
        size--;
        return (E) res;
    }

    @Override
    public void push(E e) {
        if (size >= arr.length) {
            Object[] arr = new Object[this.arr.length + 10];
            for (int i = 0; i < this.arr.length; i++) arr[i] = this.arr[i];
            this.arr = arr;
        }
        arr[size++] = e;
    }
}
