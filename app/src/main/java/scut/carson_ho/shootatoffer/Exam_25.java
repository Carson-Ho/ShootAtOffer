package scut.carson_ho.shootatoffer;

/**
 * Created by Carson_Ho on 17/11/2.
 */

public class Exam_25 {

    /**
     * 测试用例
     */
    public static void main(String[] args) {
        // 功能测试：输入链表有多个节点
        // 链表1 = 1->3->5->7
        ListNode<Integer> head1 = new ListNode<Integer>(1);
        ListNode<Integer> node3 = new ListNode<Integer>(3);
        ListNode<Integer> node5 = new ListNode<Integer>(5);
        ListNode<Integer> node7 = new ListNode<Integer>(7);
        head1.next = node3;
        node3.next = node5;
        node5.next = node7;

        // 链表2 = 2->4->6->8
        ListNode<Integer> head2 = new ListNode<Integer>(2);
        ListNode<Integer> node4 = new ListNode<Integer>(4);
        ListNode<Integer> node6 = new ListNode<Integer>(6);
        ListNode<Integer> node8 = new ListNode<Integer>(8);

        head2.next = node4;
        node4.next = node6;
        node6.next = node8;

        ListNode<Integer> newHead1 = merge(head1,head2);
        // 输出链表
        while (newHead1 != null) {
            System.out.print(newHead1.val);
            newHead1 = newHead1.next;
        }

        // 异常情况测试1：二链表中，随意1个链表的头节点为空，合并结果 = 另外1个链表
        System.out.println("异常情况测试1：二链表中，随意1个链表的头节点为空，合并结果 = 另外1个链表");
        ListNode<Integer> newHead2 = merge(head1,null);
        while (newHead2 != null) {
            System.out.print(newHead2.val);
            newHead2 = newHead2.next;
        }

        System.out.println("异常情况测试1：二链表中，随意1个链表的头节点为空，合并结果 = 另外1个链表");
        ListNode<Integer> newHead3 =  merge(null,head2);
        while (newHead3 != null) {
            System.out.print(newHead3.val);
            newHead3 = newHead3.next;
        }


        // 异常情况测试2：二链表的头节点同时为空，合并结果 = 1空链表
        System.out.println("异常情况测试2：二链表的头节点同时为空，合并结果 = 1空链表");
        merge(null,null);

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
     * 合并链表
     * 解题思路：比较指针结点大小
     * 注：鲁棒性
     */
    public static ListNode<Integer> merge(ListNode<Integer> head1,ListNode<Integer> head2){
        // 鲁棒性判断：
        // a. 二链表中，随意1个链表的头节点为空，合并结果 = 另外1个链表
        // b. 二链表的头节点同时为空，合并结果 = 1空链表
        if(head1 == null) {
            return head2;
        }

        if(head2 == null) {
            return head1;
        }

        // 1. 定义2指针，初始分别指向2链表的头节点
        // 第3个指针指向合并的新链表
        ListNode<Integer> index1 = head1;
        ListNode<Integer> index2 = head2;
        ListNode<Integer> indexMerge = null;

        // 2. 比较2指针上的节点值，将小的值合并到新链表的尾节点后
        if(index1.val<index2.val) {
            indexMerge = index1;
            indexMerge.next = merge(index1.next,index2);

        }
        else {
            indexMerge = index2;
            indexMerge.next = merge(index1,index2.next);
        }


        return indexMerge;
    }

}
