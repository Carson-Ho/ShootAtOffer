package scut.carson_ho.shootatoffer;

import java.util.Stack;

/**
 * Created by Carson_Ho on 17/11/20.
 */

public class Exam_54 {

    /**
     * 测试用例
     */
    public static void main(String[] args){

        // 构造二叉树结构：
        //          5
        //         / \
        //       3     7
        //      / \   / \
        //     2  4  6   8
        TreeNode<Integer> root = new TreeNode<>(5);
        root.leftNode = new TreeNode<>(3);
        root.leftNode.leftNode = new TreeNode<>(2);
        root.leftNode.rightNode = new TreeNode<>(4);
        root.rightNode = new TreeNode<>(7);
        root.rightNode.leftNode = new TreeNode<>(6);
        root.rightNode.rightNode = new TreeNode<>(8);
        // 中序遍历序列为：{ 2,3,4,5,6,7,8 }
        System.out.println(InOrder_stack(root,3).val); // 求第3个
        System.out.println(InOrder_stack(root,6).val); // 求第6个

        // 特殊输入测试
        System.out.println(InOrder_stack(null,8)); //null
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
     * 内容：中序遍历
     * 方式：非递归（栈实现）
     */
    public static TreeNode<Integer> InOrder_stack(TreeNode<Integer> root, int k) {

        // 检查输入节点的合法性
        if (root == null || k < 0)
            return null;

        Stack<TreeNode<Integer>> stack = new Stack<TreeNode<Integer>>();
        TreeNode<Integer> cur = root;
        int count = 0;

        // 步骤1：直到当前结点为空 & 栈空时，循环结束
        while (root != null || stack.size() > 0) {

            // 步骤2：判断当前结点是否为空
            // a. 若不为空，执行3、4
            // b. 若为空，执行5、6
            if (root != null) {

                // 步骤3：入栈当前结点
                stack.push(root);

                // 步骤4：置当前结点的左孩子为当前节点
                // 返回步骤1
                root = root.leftNode;

            } else {

                // 步骤5：出栈栈顶结点
                root = stack.pop();
                // 步骤6：判断出栈顺序是否等于所要求顺序，若是则输出
                count++;
                if (count == k)
                    return root;

                // 步骤7：置当前结点的右孩子为当前节点
                root = root.rightNode;
                // 返回步骤1
            }
        }
        return null;

    }
}


