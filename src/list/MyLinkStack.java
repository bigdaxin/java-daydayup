package list;

public class MyLinkStack<E> extends AbstractStack<E> {
    private Node<E> head = new Node<>(null);
    private int size = 0;


    @Override
    public E pop() {
        MyLinkStack.Node<E> node = head;
        for (int i = 0; i < size; i++) node = node.next;
        size--;

        return node.e;
    }

    @Override
    public void push(E e) {
        MyLinkStack.Node<E> node = head, temp;
        for (int i = 0; i < size; i++) node = node.next;
        temp  = node.next;

        node.next = new MyLinkStack.Node<>(e);

        node.next.next = temp;

        size++;
    }

    private static class Node<E> {
        private E e;
        private Node<E> next;

        public Node(E e){
            this.e = e;
        }
    }
}
