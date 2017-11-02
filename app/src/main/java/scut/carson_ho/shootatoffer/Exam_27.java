package scut.carson_ho.shootatoffer;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Carson_Ho on 17/11/2.
 */

public class Exam_27 {

    /**
     * 测试用例
     */
    public static void main(String[] args){
        // 构造二叉树
        //            8
        //       6         10
        //    5     7    9     11
        TreeNode<Integer> root = new TreeNode<>(8);
        root.left = new TreeNode<>(6);
        root.right = new TreeNode<>(10);
        root.left.left = new TreeNode<>(5);
        root.left.right = new TreeNode<>(7);
        root.right.left = new TreeNode<>(9);
        root.right.right = new TreeNode<>(11);
        // 通过层序遍历输出二叉树结构
        System.out.println("初始二叉树结构");
        levelTravel(root);

        // 测试
        System.out.println("功能测试");
        mirrorRecursively(root);
        levelTravel(root);

    }


    /**
     * 设置结点结构
     */
    public static class TreeNode<T> {
        T val;
        TreeNode<T> left;
        TreeNode<T> right;

        public TreeNode(T data) {
            this.val = data;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * 解题算法
     */
    public static void mirrorRecursively(TreeNode<Integer> root){
        // 代码的鲁棒性：二叉树的头节点 = 空
        if(root == null)
            return;
        // 1. 判断前序遍历到的节点是否有左、右节点
        if(root.left == null && root.right == null)
            return;
        // 2. 若有，则交换2个节点
        TreeNode<Integer> temp = root.left;
        root.left = root.right;
        root.right = temp;
        // 3. 通过递归继续前序遍历节点
        mirrorRecursively(root.left);
        mirrorRecursively(root.right);
    }




    /**
     * 内容：层序遍历
     * 方式：非递归（采用队列）
     */
    public static void levelTravel(TreeNode<Integer> root){
        // 创建队列
        Queue<TreeNode> q=new LinkedList<TreeNode>();

        // 步骤1：判断当前结点是否为空；若是，则返回空操作
        if(root==null)
            return;
        // 步骤2：入队当前结点
        q.add(root);

        // 步骤3：判断当前队列是否为空，若为空则跳出循环
        while(!q.isEmpty()){

            // 步骤4：出队队首元素
            root =  q.poll();

            // 步骤5：输出 出队元素
            printNode(root);

            // 步骤5：若出队元素有左孩子，则入队其左孩子
            if(root.left!=null) q.add(root.left);

            // 步骤6：若出队元素有右孩子，则入队其右孩子
            if(root.right!=null) q.add(root.right);
        }
    }

    /**
     * 输出结点值
     */
    public static void printNode(TreeNode<Integer> node){
        System.out.print(node.val);
    }



}
