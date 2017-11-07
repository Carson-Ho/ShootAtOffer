package scut.carson_ho.shootatoffer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Carson_Ho on 17/11/6.
 */

public class Exam_32 {


    /**
     * 测试用例
     */

    public static void main(String[] args){
        // 功能测试
        System.out.println("功能测试");
        //             1
        //          /    \
        //         2      3
        //       /  \    / \
        //      4    5 6   7
        //     / \  / \/ \ / \
        //   8    91011121314 15
        TreeNode<Integer> root = new TreeNode<Integer>(1);

        root.leftNode = new TreeNode<Integer>(2);
        root.rightNode = new TreeNode<Integer>(3);

        root.leftNode.leftNode = new TreeNode<Integer>(4);
        root.leftNode.rightNode = new TreeNode<Integer>(5);
        root.rightNode.leftNode = new TreeNode<Integer>(6);
        root.rightNode.rightNode = new TreeNode<Integer>(7);

        root.leftNode.leftNode.leftNode = new TreeNode<Integer>(8);
        root.leftNode.leftNode.rightNode = new TreeNode<Integer>(9);

        root.leftNode.rightNode.leftNode = new TreeNode<Integer>(10);
        root.leftNode.rightNode.rightNode = new TreeNode<Integer>(11);

        root.rightNode.leftNode.leftNode = new TreeNode<Integer>(12);
        root.rightNode.leftNode.rightNode = new TreeNode<Integer>(13);

        root.rightNode.rightNode.leftNode = new TreeNode<Integer>(14);
        root.rightNode.rightNode.rightNode = new TreeNode<Integer>(15);
        levelTravel3(root);

        // 特殊输入测试：头节点为空、只有1个节点的二叉树
        System.out.println("特殊输入测试");
        levelTravel3(null);

        TreeNode<Integer> root1 = new TreeNode<Integer>(8);
        levelTravel3(root1);

//        // 功能测试
//        System.out.println("功能测试");
//        //            8
//        //          /   \
//        //         6     10
//        //       /  \   / \
//        //      5    7 9   11
//        TreeNode<Integer> root = new TreeNode<Integer>(8);
//        root.leftNode = new TreeNode<Integer>(6);
//        root.rightNode = new TreeNode<Integer>(10);
//        root.leftNode.leftNode = new TreeNode<Integer>(5);
//        root.leftNode.rightNode = new TreeNode<Integer>(7);
//        root.rightNode.leftNode = new TreeNode<Integer>(9);
//        root.rightNode.rightNode = new TreeNode<Integer>(11);
//        levelTravel2(root);
//
//        // 特殊输入测试：头节点为空、只有1个节点的二叉树
//        System.out.println("特殊输入测试");
//        levelTravel2(null);
//
//        TreeNode<Integer> root1 = new TreeNode<Integer>(8);
//        levelTravel2(root1);
    }

    /**
     * 结点结构
     */
    public static class TreeNode<T> {
        T val; // 二叉树的结点数据
        TreeNode<T> leftNode; // 二叉树的左子树（左孩子）
        TreeNode<T> rightNode; // 二叉树的右子树（右孩子）

        public TreeNode(T data) {
            this.val = data;
            this.leftNode = null;
            this.rightNode = null;
        }
    }

    /**
     * 内容：层序遍历（不分行）
     * 方式：非递归（采用队列）
     */
    public static void levelTravel(TreeNode root){
        // 创建队列
        Queue<TreeNode> q=new LinkedList<TreeNode>();

        // 步骤1：判断当前结点是否为空；若是，则返回空操作
        if(root==null) {
            System.out.println("输入的头节点为空");
            return;
        }
        // 步骤2：入队当前结点
        q.add(root);

        // 步骤3：判断当前队列是否为空，若为空则跳出循环
        while(!q.isEmpty()){

            // 步骤4：出队队首元素
            root =  q.poll();

            // 步骤5：输出 出队元素
            System.out.println(root.val);

            // 步骤5：若出队元素有左孩子，则入队其左孩子
            if(root.leftNode!=null) q.add(root.leftNode);

            // 步骤6：若出队元素有右孩子，则入队其右孩子
            if(root.rightNode!=null) q.add(root.rightNode);
        }
    }


    /**
     * 内容：层序遍历（分行打印）
     * 方式：非递归（采用队列）
     */
    public static void levelTravel2(TreeNode root){
        // 创建队列
        Queue<TreeNode> q=new LinkedList<TreeNode>();

        // 步骤1：判断当前结点是否为空；若是，则返回空操作
        if(root==null) {
            System.out.println("输入的头节点为空");
            return;
        }

        int toBePrinted =1; // 表示当前层还未打印的节点数
        int nextLevel = 0;  // 表示下1层的节点数

        // 步骤2：入队当前结点
        q.add(root);

        // 步骤3：判断当前队列是否为空，若为空则跳出循环
        while(!q.isEmpty()){

            // 步骤4：出队队首元素 & 输出
            root =  q.poll();
            // 注：
            // a. System.out.println = 换行：不同层输出
            // b. System.out.print = 不换行 ：同一层输出
            System.out.print(root.val + " ");
            --toBePrinted; // 每次出队时，当前层还未打印的节点数都减1

            // 步骤5：若出队元素有左孩子，则入队其左孩子
            if(root.leftNode!=null) {
                q.add(root.leftNode);
                // 每次入队子树时，下1层的节点数+1
                ++nextLevel;
            }

            // 步骤6：若出队元素有右孩子，则入队其右孩子
            if(root.rightNode!=null) {
                q.add(root.rightNode);
                // 每次入队子树时，下1层的节点数+1
                ++nextLevel;
            }

            // 步骤6：当toBePrinted = 0时，代表当前层的节点数已打完
            // 则换行、将下层节点数赋给当前层节点数、下层节点数置0
            if (toBePrinted == 0 ){
                System.out.println(" ");
                toBePrinted = nextLevel;
                nextLevel = 0 ;
            }

        }
    }


    /**
     * 内容：之字形分行打印
     * 方式：采用2个栈
     */
    public static void levelTravel3(TreeNode<Integer> root){
        // 1. 判断当前结点是否为空；若是，则返回空操作
        if(root==null) {
            System.out.println("输入的头节点为空");
            return;
        }

        // 2. 定义2个栈
        // 栈1：打印的层数 = 奇数、入栈顺序 = 右子节点 -> 左子节点
        // 栈2：打印的层数 = 偶数、入栈顺序 = 左子节点 -> 右子节点
        Stack<TreeNode<Integer>> stack1 = new Stack<>();
        Stack<TreeNode<Integer>> stack2 = new Stack<>();


        TreeNode<Integer> temp;
        // 栈1入栈根节点 = 第1层
        stack1.push(root);

        while(!stack1.isEmpty() || !stack2.isEmpty()){

            if(!stack1.isEmpty()) {
                while (!stack1.isEmpty()) {
                    // 出栈队首元素 & 输出
                    temp = stack1.pop();
                    System.out.print(temp.val);
                    System.out.print(' ');
                    // 保存下1层节点
                    // 因为本层 = 奇数，那么下层 = 偶数，即保存到栈2，入栈顺序 = 左子节点 -> 右子节点
                    if (temp.leftNode != null)
                        stack2.push(temp.leftNode);
                    if (temp.rightNode != null)
                        stack2.push(temp.rightNode);
                }
            }
            else {
                while (!stack2.isEmpty()) {
                    temp = stack2.pop();
                    System.out.print(temp.val);
                    System.out.print(' ');
                    // 保存下1层节点
                    // 因为本层 = 偶数，那么下层 = 奇数，即保存到栈1，入栈顺序 = 右子节点 -> 左子节点
                    if (temp.rightNode != null)
                        stack1.push(temp.rightNode);
                    if (temp.leftNode != null)
                        stack1.push(temp.leftNode);
                }
            }
            System.out.println();
        }
    }

}
