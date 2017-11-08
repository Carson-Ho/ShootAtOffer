package scut.carson_ho.shootatoffer;

/**
 * Created by Carson_Ho on 17/11/8.
 */

public class Exam_36 {

    public static void main(String[] args) {
        // 功能测试
        //            10
        //          /   \
        //         6     14
        //        / \    / \
        //       4   8  12 16
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(6);
        root.right = new BinaryTreeNode(14);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(8);
        root.right.left = new BinaryTreeNode(12);
        root.right.right = new BinaryTreeNode(16);


        System.out.print("原始的二叉树：");
        // 输出二叉树
        printTree(root);

        System.out.println(" ");
        System.out.print("转换后的链表：");
        // 输出链表
        printList(convert(root));

        // 特殊输入测试
        System.out.println(" ");
        System.out.print("转换后的链表：" );
        printList(convert(null));
    }


    /**
     * 节点结构
     */
    public static class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;

        public BinaryTreeNode(int val) {
            this.val = val;
        }

    }

    /**
     * 解题算法
     *
     * @param root 二叉树的根结点
     * @return 双向链表的头结点
     */
    public static BinaryTreeNode convert(BinaryTreeNode root) {

        // 1. 转换过程中 双向链表的尾结点
        // 使用一个长度为1的数组存储，类似C++中的二级指针
        BinaryTreeNode[] lastNode = new BinaryTreeNode[1];

        // 2. 链表转换过程如下函数
        convertNode(root, lastNode);

        // 3. 通过链表的尾节点的前驱指针，找到双向链表的头结点
        BinaryTreeNode head = lastNode[0];
        while (head != null && head.left != null) {
            head = head.left;
        }
        return head;
    }


    /**
     * 链表转换
     *
     * @param node     当前的根结点
     * @param lastNode 当前双向链表的尾结点
     */
    public static void convertNode(BinaryTreeNode node, BinaryTreeNode[] lastNode) {
        // 结点不为空
        if (node == null) {
            System.out.print(" 输入的根节点为空");
            return;
        }

        // 1. 如果有左子树，就先转换左子树
        if (node.left != null) {
            convertNode(node.left, lastNode);
        }

        //  2. 连接 根节点 与 当前转换的链表
        //  即，连接根节点 与 当前双向链表的尾节点 ：设置根节点的前驱元素 = 尾结点、尾结点的后继 = 根节点
        // 当前双向链表 = 已排序的左子树
        // 当前双向链表的尾节点 = 左子树最大值
        node.left = lastNode[0]; // a. 设置根节点的前驱元素 = 尾结点

        if (lastNode[0] != null) {
            lastNode[0].right = node;
        } // b. 设置尾结点的后继 = 根节点

        // 3. 此时，当前链表的尾节点 = 根节点
        // 进行当前链表尾节点更新
        lastNode[0] = node;

        // 4. 通过 转换右子树 & 连接右子树的最小值 与根节点
        if (node.right != null) {
            convertNode(node.right, lastNode);
        }


    }

    /**
     * 打印二叉树
     */

    private static void printTree(BinaryTreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.val + " ");
            printTree(root.right);
        }
    }

    /**
     * 打印链表
     */
    private static void printList(BinaryTreeNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.right;
        }
    }
}
