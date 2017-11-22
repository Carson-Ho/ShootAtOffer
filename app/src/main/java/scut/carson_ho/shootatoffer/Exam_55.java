package scut.carson_ho.shootatoffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Carson_Ho on 17/11/21.
 */

public class Exam_55 {

    /**
     * 测试用例
     */
    public static void main(String[] args){

        // 功能测试
        TreeNode<Integer> root = new TreeNode<>(1);
        root.leftNode = new TreeNode<>(2);
        root.leftNode.leftNode = new TreeNode<>(4);
        root.leftNode.rightNode = new TreeNode<>(5);
        root.leftNode.rightNode.leftNode = new TreeNode<>(7);
        root.rightNode = new TreeNode<>(3);
        root.rightNode.rightNode = new TreeNode<>(6);

        System.out.println(treeDepth(root));
        System.out.println(treeDepth2(root));

        // 特殊输入测试：头节点为空
        System.out.println(treeDepth(null));
        System.out.println(treeDepth2(null));
    }


    /**
     * 设置结点结构
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
     * 递归实现方式
     */
    public static int treeDepth(TreeNode<Integer> root){
        // 检查输入数据的合法性
        if(root == null)
            return 0;
        // 采用递归获取左、右子树的深度
        int left = treeDepth(root.leftNode);
        int right = treeDepth(root.rightNode);

        return left > right? (left+1) : (right+1);
    }

    /**
     * 非递归实现方式（层序遍历）
     * 主要采用 队列实现
     */
    public static int treeDepth2(TreeNode<Integer> root){

        // 判断输入数据的合法性
        if(root==null)
            return 0;

        Queue<TreeNode<Integer>> q=new LinkedList<>();// 创建队列
        int depth = 0; // 用于记录深度

        // 步骤2：入队当前结点
        q.add(root);

        // 步骤3：判断当前队列是否为空，若为空则跳出循环
        while(!q.isEmpty()){

            int size = q.size();

            for(int i=0;i<size;i++){
                // 出队队首元素
                root = q.poll();

                // 若出队元素有左孩子，则入队其左孩子
                if(root.leftNode!=null) q.add(root.leftNode);
                // 若出队元素有右孩子，则入队其右孩子
                if(root.rightNode!=null) q.add(root.rightNode);
            }
            depth++;
        }
        return depth;

    }
}
