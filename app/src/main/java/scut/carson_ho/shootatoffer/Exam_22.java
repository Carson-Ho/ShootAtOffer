package scut.carson_ho.shootatoffer;

/**
 * Created by Carson_Ho on 17/10/31.
 */

public class Exam_22 {

    /**
     * 测试用例
     */
    public static void main(String[] args){
        // 创建链表：1->2->3->4
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

        // 功能测试：倒数第1个节点（尾结点）、倒数第6个节点（头节点）、中间节点
        System.out.println(findKthToTail(head,1).val);
        System.out.println(findKthToTail(head,3).val);
        System.out.println(findKthToTail(head,6).val);

        // 异常情况测试：链表头节点 为空、、链表长度＜ k、k< 0
        findKthToTail(null,1);
        findKthToTail(head,8);
        findKthToTail(head,0);

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
     * 解题思路：采用2指针，仅用1次遍历找到倒数第k个节点
     * 注意 代码的鲁棒性，即要考虑：输入头节点是否为空、链表长度是否＜ k、k是否< 0
     * @param head 链表头节点
     * @param k 倒数第k个节点
     */
    public static ListNode<Integer> findKthToTail(ListNode<Integer> head,int k){
        // 异常情况1、3：输入头节点是否为空、k是否< 0
        // 均返回 null
        if(head == null||k <= 0) {
            System.out.println("出现异常情况输入头节点为空 / k是< 0");
            return null;
        }
        // 1. 定义2个指针
        ListNode<Integer> slow=head;
        ListNode<Integer> fast=head;

        // 2. p1 向前移动 （k-1）步，p2保持不动
        for(int i=0;i < k-1;i++){
            // 异常情况2：链表长度是否＜ k
            if(fast.next!=null)
                fast = fast.next;
            else {
                System.out.println("链表长度＜ k");
                return null;
            }
        }
        // 3. 从 第k步 开始，2指针同时往前移动（二指针始终保持距离 = k-1）
        // 直到p1移动到链表尾节点，p2刚好移动到倒数第k个节点位置
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        // 最终返回的第2个指针指向的元素 = 倒数第k个元素
        return slow;
    }

}
