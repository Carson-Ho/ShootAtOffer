package scut.carson_ho.shootatoffer;

/**
 * Created by Carson_Ho on 17/11/1.
 */

public class Exam_23 {

    /**
     * 测试用例
     */
    public static void main(String[] args){
        // 创建链表：
        // 1->2->3->4->5->6
        //       ^        |
        //       |        |
        //       +--------+
        ListNode<Integer> head = new ListNode<Integer>(1);
        ListNode<Integer> node2 = new ListNode<Integer>(2);
        ListNode<Integer> node3 = new ListNode<Integer>(3);
        ListNode<Integer> node4 = new ListNode<Integer>(4);
        ListNode<Integer> node5 = new ListNode<Integer>(5);
        ListNode<Integer> node6 = new ListNode<Integer>(6);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node3;

        // 功能测试：倒数第1个节点（尾结点）、倒数第6个节点（头节点）、中间节点
        System.out.println(meetingNode(head).val);

        // 异常测试：链表中没环
        // 创建链表：
        // 1->2->3->4->5->6
//        ListNode<Integer> head = new ListNode<Integer>(1);
//        ListNode<Integer> node2 = new ListNode<Integer>(2);
//        ListNode<Integer> node3 = new ListNode<Integer>(3);
//        ListNode<Integer> node4 = new ListNode<Integer>(4);
//        ListNode<Integer> node5 = new ListNode<Integer>(5);
//        ListNode<Integer> node6 = new ListNode<Integer>(6);
//        head.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//
//        System.out.println(meetingNode(head).val);


        // 异常测试：头节点为空
//        System.out.println(meetingNode(null).val);


    }


    /**
     * 设置结点结构
     */
    public static class ListNode<T> {
        T val;
        ListNode<T> next;

        public ListNode(T data) {
            this.val = data;
            this.next = null;
        }
    }


    /**
     * 解题算法
     * 分为3个步骤：1.判断链表中是否有环；2.获得环中节点；3.找到环的入口节点
     */
    public static ListNode<Integer> meetingNode(ListNode<Integer> head) {

        // 判断输入头节点的合法性
        if(head == null) {
            System.out.println("头节点为空");
            return null;
        }

        /**
         * 步骤1：判断链表中是否有环
         */

        // 定义2个指针，同时从链表头节点出发
        ListNode<Integer> fast = head;
        ListNode<Integer> slow = head;

        // p1移动1步/次，p2移动2步/次
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            // 若2者相遇，则代表有环，跳出循环
            if (fast == slow) {
                System.out.println("链表中有环");
                break;
            }

        }

        // 链表中没有环
        // 若p2走到了链表的尾端依然未遇到p1，则代表无环，返回空
        if (fast == null || fast.next == null) {
            System.out.println("链表中无环");
            return null;
        }

        /**
         * 步骤2：获得环中节点
         * a. 从上述2指针相遇的节点出发（该节点在环内）
         * b. 一直往前移动 & 计数
         * c. 当指针再次回到该相遇节点时，计数器即为环的数量
         */

        int nodesLoop =1 ;
        while(fast.next!= slow){
            fast = fast.next;
            ++ nodesLoop;
        }


        /**
         * 步骤3：找到环的入口节点
         */
        // 将2个指针p1、p2重新回到链表头节点出发
        fast = head;
        slow = head;

        // p1先移动n步（n= 环的节点数量，此处n=4）,p2不动
        for (int i = 0;i < nodesLoop;++i){
            fast = fast.next;
        }

        // 2指针同时往前移动
        // 当2指针相遇时，相遇节点 = 环的入口节点
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
