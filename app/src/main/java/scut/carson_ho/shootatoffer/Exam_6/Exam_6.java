package scut.carson_ho.shootatoffer.Exam_6;

import java.util.Stack;

/**
 * Created by Carson_Ho on 17/10/20.
 */

public class Exam_6 {

    /**
     * 思路1：栈结构
     * @param head = 头结点
     */
    private static void reversePrint_Stack(Node head){
        // 1. 判断头结点是否为空
        if(head==null)
            return;
        Node cur = head;

        // 2. 声明用于存放 & 输出的栈
        Stack<Node> stack = new Stack<>();

        // 3. 遍历链表（所有结点），每经过1个结点，就将该结点放入到栈中并指向下1个结点
        while(cur!=null){
            stack.push(cur);
            cur = cur.next;
        }
        // 4. 遍历链表完毕后，从栈顶开始输出结点的值
        while(!stack.isEmpty()){
            System.out.print(stack.pop().data+" ");
        }

    }

    /**
     * 结点结构
     */
    class Node {
        int data;
        Node next;

    }



    /**
     * 思路2：递归
     * @param head = 头结点
     */

    private static void reversePrint_Rec(Node head){
        // 1. 判断头结点是否为空
        if(head==null)
            return;
        else{
            // 2. 遍历链表：每访问1个结点，先递归输出它后面的结点，再输出该结点本身
            reversePrint_Rec(head.next);
            System.out.print(head.data+" ");
        }

    }

}
