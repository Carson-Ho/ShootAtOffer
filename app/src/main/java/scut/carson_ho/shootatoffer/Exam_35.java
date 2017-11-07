package scut.carson_ho.shootatoffer;

/**
 * Created by Carson_Ho on 17/11/7.
 */

public class Exam_35 {

    public static void main(String[] args){
        // 功能测试
        ComplexListNode head = new ComplexListNode(1);
        ComplexListNode c2 = new ComplexListNode(2);
        ComplexListNode c3 = new ComplexListNode(3);
        ComplexListNode c4 = new ComplexListNode(4);
        ComplexListNode c5 = new ComplexListNode(5);
        head.next = c2;
        head.random = c3;
        head.next.next = c3;
        head.next.random = c5;
        head.next.next.next = c4;
        head.next.next.next.next = c5;
        head.next.next.next.random = c2;

        System.out.print("原始链表如下");
        // 输出链表
        ComplexListNode head1 = head;
        while (head1 != null) {
            System.out.print(head1.val);
            head1 = head1.next;
        }

        System.out.println(" ");
        System.out.print("复制链表如下");
        ComplexListNode head2 = clone3(head);
        // 输出链表
        while (head2 != null) {
            System.out.print(head2.val);
            head2 = head2.next;
        }

        // 特殊输入测试
        System.out.println(" ");
        System.out.println("复制链表 ："+'\t'+clone3(null));
    }

    /**
     * 节点结构
     */
    public static class ComplexListNode {
        int val;
        ComplexListNode next;
        ComplexListNode random;

        public ComplexListNode(int val) {
            this.val = val;
        }

    }
    /**
     * 解题思路3
     * 核心思想：分为3步
     * 1. 复制原始链表的每个节点，将复制节点（N`）放在对应的原始节点（N）后1个位置
     * 2. 设置复制节点（N`）的m_pSibling指针
     * 3. 将该复制的长链表拆分成2个链表
     */
    public static ComplexListNode clone3(ComplexListNode head) {
        // 判断输入节点是否为空
        if(head == null) {
            System.out.println("输入的头节点为空");
            return null;
        }
        // 将3步分别封装成3个函数逐步实现
        // 1.复制原始链表的每个节点，将复制节点（N`）放在对应的原始节点（N）后1个位置
        cloneNodes(head);
        // 2.设置复制节点（N`）的m_pSibling指针
        connectRandomNodes(head);
        // 3.将该复制的长链表拆分成2个链表
        return reconnectNodes(head);
    }

    /**
     * 步骤1：复制原始链表的每个节点，将复制节点（N`）放在对应的原始节点（N）后1个位置
     * 核心思想：即添加节点到链表
     */
    public static void cloneNodes(ComplexListNode head){
        ComplexListNode cur = head;
        ComplexListNode temp = null;
        while (cur!=null){
            temp = new ComplexListNode(cur.val);
            temp.next = cur.next;
            cur.next = temp;
            cur = cur.next.next;
        }
    }

    /**
     * 步骤2：设置复制节点（N`）的m_pSibling指针
     * 核心思想：原始节点（N） 的m_pSibling指针 指向的任意节点S 的m_pNext指针 指向 复制节点（N`）的m_pSibling指针 指向的任意节点S`
     */
    public static void connectRandomNodes(ComplexListNode head){
        ComplexListNode cur = head;
        ComplexListNode curNext = head.next;
        while (true){
            if(cur.random!=null)
                curNext.random = cur.random.next;
            cur = cur.next.next;
            if(cur == null)
                break;
            curNext = curNext.next.next;
        }
    }
    /**
     * 步骤3：将该复制的长链表拆分成2个链表：
     * 核心思想：
     *  a. 原始链表：将奇数位置的节点用m_pNext指针连接起来
     *  b. 原始链表：将奇数位置的节点用m_pNext指针连接起来
     */
    public static ComplexListNode reconnectNodes(ComplexListNode head){
        ComplexListNode newHead = head.next;
        ComplexListNode cur = head;
        ComplexListNode newCur = newHead;

        while (true){
            cur.next = cur.next.next;
            cur = cur.next;
            if(cur==null){
                newCur.next = null;
                break;
            }
            newCur.next = newCur.next.next;
            newCur = newCur.next;
        }
        return newHead;
    }


}
