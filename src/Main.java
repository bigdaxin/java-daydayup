import list.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import score.Score;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class Main {
//    private static int value = 0;
//
//    private static synchronized void add(){
//        value++;
//    }

    public static void main(String[] args) throws FileNotFoundException {

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(new FileInputStream("mybatis-config.xml"));
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)){
            //暂时还没有业务
            List<Student> student = sqlSession.selectList("selectStudent");
            student.forEach(System.out::println);
        }

//        // 创建DocumentBuilderFactory对象
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//// 创建DocumentBuilder对象
//        try {
//            DocumentBuilder builder = factory.newDocumentBuilder();
//            Document d = builder.parse("file:test.xml");
//            // 每一个标签都作为一个节点
//            NodeList nodeList = d.getElementsByTagName("outer");  // 可能有很多个名字为test的标签
//            Node rootNode = nodeList.item(0); // 获取首个
//
//            NodeList childNodes = rootNode.getChildNodes(); // 一个节点下可能会有很多个节点，比如根节点下就囊括了所有的节点
//            //节点可以是一个带有内容的标签（它内部就还有子节点），也可以是一段文本内容
//
//            for (int i = 0; i < childNodes.getLength(); i++) {
//                Node child = childNodes.item(i);
//                if(child.getNodeType() == Node.ELEMENT_NODE)  //过滤换行符之类的内容，因为它们都被认为是一个文本节点
//                    System.out.println(child.getNodeName() + "：" +child.getFirstChild().getNodeValue());
//                // 输出节点名称，也就是标签名称，以及标签内部的文本（内部的内容都是子节点，所以要获取内部的节点）
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        Student student = new Student(1, "小明", "男");
//        System.out.println(student.sex());
        //1. 通过DriverManager来获得数据库连接
//        try (Connection connection = DriverManager.getConnection("jdbc:mysql://82.156.52.171:3306/super_test","super_test","bZksJF55wjGCrPY7");
//             //2. 创建一个用于执行SQL的Statement对象
//             Statement statement = connection.createStatement()){   //注意前两步都放在try()中，因为在最后需要释放资源！
//            //3. 执行SQL语句，并得到结果集
//            ResultSet set = statement.executeQuery("select * from users ");
//            //4. 查看结果
////            while (set.next()){
////        ...
////                statement.addBatch("insert into user values ('f', 1234)");
////                statement.addBatch("insert into user values ('e', 1234)");   //添加每一条批处理语句
////                statement.executeBatch();   //一起执行
//
////                while (set.next()){
////                    Student student = new Student(set.getInt(1), set.getString(2), set.getString(3));
////                    student.say();
////                }
//
////                System.out.println(set.getInt(1));
////            }
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//5. 释放资源，try-with-resource语法会自动帮助我们close


//        Object o1 = new Object();
//        Thread t1 = new Thread(() -> {
//            synchronized (o1){
//                try {
//                    System.out.println("开始等待");
//                    o1.wait();     //进入等待状态并释放锁
//                    System.out.println("等待结束！");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        Thread t2 = new Thread(() -> {
//            synchronized (o1){
//                System.out.println("开始唤醒！");
//                o1.notify();     //唤醒处于等待状态的线程
//                for (int i = 0; i < 50; i++) {
//                    System.out.println(i);
//                }
//                //唤醒后依然需要等待这里的锁释放之前等待的线程才能继续
//            }
//        });
//        t1.start();
//        Thread.sleep(1000);
//        t2.start();

//        Object o1 = new Object();
//        Object o2 = new Object();
//        Thread t1 = new Thread(() -> {
//            synchronized (o1){
//                try {
//                    Thread.sleep(1000);
//                    synchronized (o2){
//                        System.out.println("线程1");
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        Thread t2 = new Thread(() -> {
//            synchronized (o2){
//                try {
//                    Thread.sleep(1000);
//                    synchronized (o1){
//                        System.out.println("线程2");
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        t1.start();
//        t2.start();


//        Thread t1 = new Thread(() -> {
//            for (int i = 0; i < 10000; i++) add();
//            System.out.println("线程1完成");
//        });
//        Thread t2 = new Thread(() -> {
//            for (int i = 0; i < 10000; i++) add();
//            System.out.println("线程2完成");
//        });
//        t1.start();
//        t2.start();
//        Thread.sleep(1000);  //主线程停止1秒，保证两个线程执行完成
//        System.out.println(value);

//        Thread t1 = new Thread(() -> {
//            for (int i = 0; i < 10000; i++) {
//                synchronized (Main.class){
//                    value++;
//                }
//            }
//            System.out.println("线程1完成");
//        });
//        Thread t2 = new Thread(() -> {
//            for (int i = 0; i < 10000; i++) {
//                synchronized (Main.class){
//                    value++;
//                }
//            }
//            System.out.println("线程2完成");
//        });
//        t1.start();
//        t2.start();
//        Thread.sleep(1000);  //主线程停止1秒，保证两个线程执行完成
//        System.out.println(value);

//        Thread t1 = new Thread(() -> {
//            System.out.println("线程1开始运行！");
//            for (int i = 0; i < 50; i++) {
//                System.out.println("1打印："+i);
//            }
//            System.out.println("线程1结束！");
//        });
//        Thread t2 = new Thread(() -> {
//            System.out.println("线程2开始运行！");
//            for (int i = 0; i < 50; i++) {
//                System.out.println("2打印："+i);
//                if(i == 10){
//                    try {
//                        System.out.println("线程1加入到此线程！");
//                        t1.join();    //在i==10时，让线程1加入，先完成线程1的内容，在继续当前内容
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//        t1.start();
//        t2.start();

//        Thread t1 = new Thread(() -> {
//            System.out.println("线程1开始运行！");
//            for (int i = 0; i < 50; i++) {
//                if(i % 5 == 0) {
//                    System.out.println("让位！");
//                    Thread.yield();
//                }
//                System.out.println("1打印："+i);
//            }
//            System.out.println("线程1结束！");
//        });
//        Thread t2 = new Thread(() -> {
//            System.out.println("线程2开始运行！");
//            for (int i = 0; i < 50; i++) {
//                System.out.println("2打印："+i);
//            }
//        });
//        t1.start();
//        t2.start();

//        Thread t = new Thread(() -> {
//            System.out.println("线程开始运行！");
//        });
//        t.start();
//        t.setPriority(Thread.MIN_PRIORITY);  //通过使用setPriority方法来设定优先级

//        Thread t = new Thread(() -> {
//            System.out.println("线程开始运行！");
//            Thread.currentThread().suspend();   //暂停此线程
//            System.out.println("线程继续运行！");
//        });
//        t.start();
//        try {
//            Thread.sleep(3000);   //休眠3秒，一定比线程t先醒来
//            t.resume();   //恢复此线程
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        Thread t = new Thread(() -> {
//            System.out.println("线程开始运行！");
//            while (true){   //无限循环
//                if(Thread.currentThread().isInterrupted()){   //判断是否存在中断标志
//                    break;   //响应中断
//                }
//            }
//            System.out.println("线程被中断了！");
//        });
//        t.start();
//        try {
//            Thread.sleep(3000);   //休眠3秒，一定比线程t先醒来
//            t.interrupt();   //调用t的interrupt方法
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        Thread t = new Thread(() -> {
//            try {
//                Thread.sleep(10000);  //休眠10秒
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        t.start();
//        try {
//            Thread.sleep(3000);   //休眠3秒，一定比线程t先醒来
//            t.interrupt();   //调用t的interrupt方法
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        Thread t = new Thread(() -> {
//            try {
//                System.out.println("l");
//                Thread.sleep(1000);   //sleep方法是Thread的静态方法，它只作用于当前线程（它知道当前线程是哪个）
//                System.out.println("b");    //调用sleep后，线程会直接进入到等待状态，直到时间结束
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        t.start();

//        Thread t1 = new Thread(() -> {
//            for (int i = 0; i < 10000; i++) value++;
//            System.out.println("线程1完成");
//        });
//        Thread t2 = new Thread(() -> {
//            for (int i = 0; i < 10000; i++) value++;
//            System.out.println("线程2完成");
//        });
//        t1.start();
//        t2.start();
//        Thread.sleep(3000);  //主线程停止1秒，保证两个线程执行完成
//        System.out.println(value);

//        Thread t = new Thread(() -> {
//            Thread me = Thread.currentThread();   //获取当前线程对象
//            for (int i = 0; i < 50; i++) {
//                System.out.println("打印:"+i);
//                if(i == 20) me.stop();  //此方法会直接终止此线程
//            }
//        });
//        t.start();

//        Thread t1 = new Thread(() -> {
//            for (int i = 0; i < 50; i++) {
//                System.out.println("我是一号线程："+i);
//            }
//        });
//        Thread t2 = new Thread(() -> {
//            for (int i = 0; i < 50; i++) {
//                System.out.println("我是二号线程："+i);
//            }
//        });
//        t1.start();
//        t2.start();
//        Thread t = new Thread(() -> {
//            System.out.println("我是线程："+Thread.currentThread().getName());
//            System.out.println("我正在计算 0-10000 之间所有数的和...");
//            int sum = 0;
//            for (int i = 0; i <= 10000; i++) {
//                sum += i;
//            }
//            System.out.println("结果："+sum);
//        });
//        t.start();
//        System.out.println("我是主线程！");


//        //树
//        TreeNode<String> myTree = new TreeNode<>("A");
//
//        myTree.lift = new TreeNode<>("B");
//        myTree.right = new TreeNode<>("C");
//        myTree.lift.lift = new TreeNode<>("D");
//        myTree.lift.right = new TreeNode<>("E");
//        myTree.right.right = new TreeNode<>("F");
////        System.out.println(myTree);
//
//        myTree.each(myTree);
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


    private static <T> T convert(ResultSet set, Class<T> clazz){
        try {
            Constructor<T> constructor = clazz.getConstructor(clazz.getConstructors()[0].getParameterTypes());   //默认获取第一个构造方法
            Class<?>[] param = constructor.getParameterTypes();  //获取参数列表
            Object[] object = new Object[param.length];  //存放参数
            for (int i = 0; i < param.length; i++) {   //是从1开始的
                object[i] = set.getObject(i+1);
                if(object[i].getClass() != param[i])
                    throw new SQLException("错误的类型转换："+object[i].getClass()+" -> "+param[i]);
            }
            return constructor.newInstance(object);
        } catch (ReflectiveOperationException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
