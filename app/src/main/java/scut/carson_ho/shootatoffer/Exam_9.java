package scut.carson_ho.shootatoffer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Carson_Ho on 17/10/24.
 */

public class Exam_9 {

    public static void main(String[] args) {
        MyQueue<String> queue = new MyQueue<>();

//        // 插入元素
//        queue.appendTail("a");
//        queue.appendTail("b");
//        queue.appendTail("c");
//
//        // 删除元素
//        System.out.println(queue.deleteHead());
//        System.out.println(queue.deleteHead());
//        System.out.println(queue.deleteHead());

        MyStack<String> stack = new MyStack<>();
        // 入栈
        stack.push("a");
        stack.push("b");
        stack.push("c");

        // 出栈
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());




    }
}

/**
 * 用2个栈实现一个队列
 */

class MyQueue<T>{
    // 1. 建立2个堆栈
    Stack<T> stack1 = new Stack<>();
    Stack<T> stack2 = new Stack<>();

    /**
     * 插入元素结点
     * 在栈1中进行
     * @param n
     */

    public void appendTail(T n){
        // 直接将元素结点插入到栈1
        stack1.push(n);
    }

    /**
     * 删除元素结点
     * 在栈2中进行
     * @return
     */
    public T deleteHead(){
        // 判断栈2是否为空（是否有结点）
        if(stack2.isEmpty()){
            // 若栈2为空 & 栈1不为空，则将栈1中的结点依次弹出 & 压入到栈2，最终直接弹出栈2元素
            // 若不为空，直接跳到最后执行弹出栈2元素
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        // 若栈2为空，则抛出异常
        if(stack2.isEmpty()){
            try {
                throw new Exception("队列中没元素啦");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return stack2.pop();
    }

}

/**
 * 用两个队列实现一个栈
 */

class MyStack<E>{
    // 1. 定义2个队列
    Queue<E> queue1 = new LinkedList<>();
    Queue<E> queue2 = new LinkedList<>();


    // 2. 入栈
    public void push(E n){
        // 直接插入到队列1
        queue1.add(n);
    }

    // 3. 出栈
    public E pop(){
        if(queue1.isEmpty()&queue2.isEmpty())
            try {
                throw new Exception("栈中没元素啦");
            } catch (Exception e) {
                e.printStackTrace();
            }

        // 若队列1不为空，将队列1的元素（除最后1个）依次出列 & 插入到队列2
        if(!queue1.isEmpty()){
            while(queue1.size()>1){
                queue2.add(queue1.remove());
            }
            // 返回队列1中的最后1个元素，即需删除的元素
            return queue1.remove();
        }

        // 当队列1为空时，操作队列2
        // 操作同上
        while(queue2.size()>1){
            queue1.add(queue2.remove());
        }
        return queue2.remove();

    }

//    public E peek(){
//        if(queue1.isEmpty()&queue2.isEmpty())
//            try {
//                throw new Exception("栈中没元素啦");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        // 若队列1不为空
//        if(!queue1.isEmpty()){
//            while(queue1.size()>1){
//                queue2.add(queue1.remove());
//            }
//            return queue1.peek();
//        }
//        // 当队列1为空时，操作队列2
//        while(queue2.size()>1){
//            queue1.add(queue2.remove());
//        }
//        return queue2.peek();
//    }
}


