package list;

public class MyLinkList<E> extends AbstractList<E> {
    private Node<E> head = new Node<E>(null);
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E e, int index) {
        if (index > size) throw new IllegalArgumentException("非法插入位置");
        Node<E> node = head, temp;
        for (int i = 0; i < index; i++) node = node.next;
        temp  = node.next;

        node.next = new Node<>(e);

        node.next.next = temp;

        size++;
    }

    @Override
    public E remove(int index) {
        if (index >= size) throw new IllegalArgumentException("非法删除位置");
        Node<E> node = head, temp;
        for (int i = 0; i < index; i++) node = node.next;
        temp = node.next;
        node.next = node.next.next;

        size--;
        return temp.e;
    }

    @Override
    public E get(int index) {
        if (index >= size) throw new IllegalArgumentException("非法查询位置");
        Node<E> node = head;
        for (int i = 0; i < index; i++) node = node.next;
        return node.next.e;
    }

    private static class Node<E> {
        private E e;
        private Node<E> next;

        public Node(E e){
            this.e = e;
        }
    }
}
