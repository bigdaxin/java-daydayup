package list;


/**
 * 抽象类型队列，待实现
 * @param <E> 元素类型
 */
abstract public class AbstractQueue<E> {
    /**
     * 入栈操作
     * @param e 元素
     */
    public abstract void offer(E e);

    /**
     * 出栈操作
     * @return e
     */
    public abstract E poll();
}
