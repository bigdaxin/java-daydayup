package list;


public class MyList<E> extends AbstractList<E> {

    private Object[] arr = new Object[2];

    private Integer size= 0;


    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E e, int index) {
        if (index > size)throw new IllegalArgumentException("非法插入位置");
        if (size >= arr.length){
            Object[] arr = new Object[this.arr.length+10];
            for (int i= 0;i<this.arr.length;i++)arr[i] = this.arr[i];
            this.arr = arr;
        }

        int i = size - 1;
        while (i >= index){
            arr[i+1] = arr[i];
            i--;
        }

        arr[index] = e;

        size++;
    }

    @Override
    public E remove(int index) {
        if (index >= size)throw new IllegalArgumentException("非法移除位置");
        int i = index;
        while (i < size-1){
            arr[i] = arr[i+1];
            i++;
        }
        size--;

        return (E) arr[index];
    }

    @Override
    public E get(int index) {
        return null;
    }
}
