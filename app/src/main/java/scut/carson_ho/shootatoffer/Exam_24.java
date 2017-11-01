package scut.carson_ho.shootatoffer;

/**
 * Created by Carson_Ho on 17/11/1.
 */

public class Exam_24 {

    /**
     * 测试用例
     */
    public static void main(String[] args) {
        // 功能测试：输入链表有多个节点
        // 链表 = 1->2->3->4->5->6
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

        reverseList(head);

        // 异常情况测试1：输入链表有1个节点
        // 链表 = 1
        ListNode<Integer> head2 = new ListNode<Integer>(1);
        reverseList(head2);

        // 异常情况测试2：输入链表为空
        ListNode<Integer> head3 = null;
        reverseList(head3);

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
     * 反转链表
     * 解题思路：反转链表中节点的指针方向
     */

    public static ListNode<Integer> reverseList(ListNode<Integer> head) {

        // 1. 异常情况判断
        // a. 若链表头节点为空 返回空
        if (head == null) {
            System.out.println("链表头节点为空");
            return null;
        }
        // b. 若链表只有1个节点的情况，就返回头结点
        if (head.next == null) {
            System.out.println(head.val);
            return head;
        }

        // 2. 定义3个指针：当前节点、当前节点的前1节点、当前节点的后1节点
        ListNode<Integer> pre = null;
        ListNode<Integer> cur = head;
        ListNode<Integer> post = head.next;

        // 3. 通过3个指针配合，反转链表节点的指针方向
        while (true) {

            cur.next = pre;// 将 当前结点 的下1个指针设置为 前1节点
            pre = cur; // 将 前1节点 设置为当前结点
            cur = post;// 将 当前节点 设置为后1节点
            // 判断已反转到最后节点：后1节点是否为空
            if (post != null)
                post = post.next;// 将 后后1节点 设置为后1节点
            else {
                // 返回最后1个节点
                System.out.println(pre.val);
                return pre;
            }
        }
    }
}


