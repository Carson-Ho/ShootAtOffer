package scut.carson_ho.shootatoffer;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Carson_Ho on 17/11/8.
 */

public class Exam_37 {

    public static void main(String[] args) {
        // 功能测试
        //            1
        //          /   \
        //         2     3
        //        /     / \
        //       4     5   6
        BinaryTreeNode root = new BinaryTreeNode(1);

        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);

        root.left.left = new BinaryTreeNode(4);
        root.right.left = new BinaryTreeNode(5);
        root.right.right = new BinaryTreeNode(6);

        // 序列化二叉树
        System.out.print("序列化后的二叉树：");
        List<Integer> result1 = new LinkedList<>();
        serialize(root, result1);
        System.out.println(result1);

        // 反序列化二叉树
        System.out.print("反序列化后的二叉树：");
        BinaryTreeNode root1 = new BinaryTreeNode(1);
        printTree(deserialize(root1, result1));


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
     * 序列化
     * 核心思想：采用 递归 实现前序遍历
     */
    public static void serialize(BinaryTreeNode root, List<Integer> result) {

        // 1. 判断数据的合法性
        if (root == null){
            result.add(null);
            return;
        }
        // 2. 通过递归实现前序遍历序列化二叉树
        result.add(root.val);
        serialize(root.left, result);
        serialize(root.right, result);
    }

    /**
     * 反序列化
     * 核心思想：拆分分3步反序列化：反序列化根节点、左子树、右子树
     */
    private static BinaryTreeNode deserialize(BinaryTreeNode root, List<Integer> result) {

        if (result.get(0) == null) {
            result.remove(0);
            return null;
        }
        // 1. 反序列化根节点，即读取到的第1个数字
        root = new BinaryTreeNode( result.remove(0));
        // 2. 反序列化左子树
        root.left = deserialize(root.left, result);
        // 3. 反序列化右子树
        root.right = deserialize(root.right, result);
        return root;
    }

    /**
     * 打印二叉树（中序遍历）
     */

    private static void printTree(BinaryTreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.val + " ");
            printTree(root.right);
        }
    }

}
