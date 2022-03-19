import list.*;
import score.Score;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {

        //树
        TreeNode<String> myTree = new TreeNode<>("A");

        myTree.lift = new TreeNode<>("B");
        myTree.right = new TreeNode<>("C");
        myTree.lift.lift = new TreeNode<>("D");
        myTree.lift.right = new TreeNode<>("E");
        myTree.right.right = new TreeNode<>("F");
//        System.out.println(myTree);

        myTree.each(myTree);
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        linkedList.add(1);
//        linkedList.add(1);
//        linkedList.add(9);
//        linkedList.add(2);
//        linkedList.add(4);
//        linkedList.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return 0;
//            }
//        });
//
//        linkedList.sort((o1, o2) -> o2 - o1);
//        System.out.println(linkedList);
//
//        linkedList.forEach(System.out::println);

        //数组实现队列
//        MyArrayQueue<String> myArrayQueue = new MyArrayQueue<>();
//
//        myArrayQueue.offer("aaa");
//        myArrayQueue.offer("bbb");
//        myArrayQueue.offer("ccc");
//        myArrayQueue.offer("ddd");
//        System.out.println(myArrayQueue.poll());
//        System.out.println(myArrayQueue.poll());
//        myArrayQueue.offer("eee");
//        myArrayQueue.offer("fff");
//        myArrayQueue.offer("ggg");
//        myArrayQueue.offer("hhh");
//        System.out.println(myArrayQueue.poll());
//        System.out.println(myArrayQueue.poll());

        //链表实现栈
//        MyLinkStack<String> myLinkStack = new MyLinkStack<>();
//        myLinkStack.push("aaa");
//        myLinkStack.push("bbb");
//        myLinkStack.push("ccc");
//        System.out.println(myLinkStack.pop());
//        System.out.println(myLinkStack.pop());
//        System.out.println(myLinkStack.pop());
        //数组实现栈
//        MyArrayStack<String> myArrayStack = new MyArrayStack<>();
//
//        myArrayStack.push("aaa");
//        myArrayStack.push("bbb");
//        myArrayStack.push("ccc");
//        System.out.println(myArrayStack.pop());
//        System.out.println(myArrayStack.pop());
//        System.out.println(myArrayStack.pop());
        //链表实现顺序表
//        MyLinkList<String> myLinkList = new MyLinkList<>();
//
//        myLinkList.add("aaa",0);
//        myLinkList.add("bbb",1);
//        myLinkList.add("ccc",2);
//        myLinkList.add("ddd",1);
//        System.out.println(myLinkList.remove(1));
//        System.out.println(myLinkList.get(2));
//        System.out.println(myLinkList.get(1));
//        System.out.println(myLinkList.get(0));
        //数组实现顺序表
//        MyList<E> myList = new MyList[];
//        MyList<String> myList = new MyList<>();
//
//        myList.add("aaa",0);
//        myList.add("bbb",1);
//        myList.add("hhh",4);
//        myList.remove(0);


//
//            Score<?> score = new Score<>("ggg",1,222);
//
//        System.out.println(score.getScore());
//        Integer[]  arr = new Integer[]{0,14,5,4,4,564,4,56,651,7,1,477,89,5};
//        quickSort(arr,0,arr.length-1);


    }

    public static void quickSort(Integer[] arr, Integer start, Integer end) {
        if (start >= end) return;
        int mid = arr[start], low = start, high = end;
        while (low < high) {
            while (low < high && mid <= arr[high]) high--;
            arr[low] = arr[high];
            while (low < high && mid >= arr[low]) low++;
            arr[high] = arr[low];
        }

        arr[high] = mid;
        quickSort(arr, start, high - 1);
        quickSort(arr, high + 1, end);

    }

}
