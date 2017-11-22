package scut.carson_ho.shootatoffer;

/**
 * Created by Carson_Ho on 17/11/22.
 */

public class Exam_55_1 {
    /**
     * 测试用例
     */
    public static void main(String[] args){

        // 功能测试：
        // a. 是平衡二叉树
        TreeNode<Integer> root = new TreeNode<>(1);
        root.leftNode = new TreeNode<>(2);
        root.leftNode.leftNode = new TreeNode<>(4);
        root.leftNode.rightNode = new TreeNode<>(5);
        root.leftNode.rightNode.leftNode = new TreeNode<>(7);
        root.rightNode = new TreeNode<>(3);
        root.rightNode.rightNode = new TreeNode<>(6);
        System.out.println(isBalanced(root));

        // b. 不是平衡二叉树
        TreeNode<Integer> root2 = new TreeNode<>(1);
        root2.leftNode = new TreeNode<>(2);
        root2.leftNode.leftNode = new TreeNode<>(4);
        root2.leftNode.rightNode = new TreeNode<>(5);
        root2.leftNode.rightNode.leftNode = new TreeNode<>(7);
        root2.rightNode = new TreeNode<>(3);
        System.out.println(isBalanced(root2));

        // 特殊输入测试
        System.out.println(isBalanced(null));

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
     * 解题算法
     * 原理 = 后序遍历，记录每个节点的深度，从而可以通过一次遍历完成整棵树的判断
     * 返回值 : true = 是平衡二叉树，false = 不是平衡二叉树
     */
    public static boolean isBalanced(TreeNode<Integer> node){

        // 1. 判断输入数据的合法性
        // 注：空树也算 平衡二叉树
        if(node == null)
            return true;

        // 2. 传入1个表示节点深度的整型变量
        // 注：采用数组传递的原因：在Java中，基本数据类型无法使用引用传递
        int[] depth = new int[1];
        return isBalancedCore(node,depth);
    }

    /**
     * 辅助算法
     * 原理 = 对于某1子树，需给出它的是否是平衡性的判断 & 深度
     * 返回值 = 此处将平衡性的判断作为返回值，深度通过长度为1的数组传递
     * 注：采用数组传递的原因：在Java中，基本数据类型无法使用引用传递
     */

    public static boolean isBalancedCore(TreeNode<Integer> node,int[] depth){
        // 1. 判断输入数据的合法性
        if(node == null){
            depth[0] = 0;
            return true;
        }
        // 2. 定义2数组变量，用于保存节点的左、右子树深度
        // 注：采用数组传递的原因：在Java中，基本数据类型无法使用引用传递
        int[] left = new int[1];
        int[] right = new int[1];

        // 3. 使用后序遍历遍历二叉树的每个节点
        if(isBalancedCore(node.leftNode,left) && isBalancedCore(node.rightNode,right)){
            // 每遍历1个节点，即记录下节点的深度
            int diff = left[0] - right[0];

            // 判断二叉树是不是平衡的
            if(diff <=1 && diff >= -1){
                depth[0] = 1 + (left[0] > right[0] ? left[0] : right[0]);
                return true;
            }
        }
        return false;
    }

}
