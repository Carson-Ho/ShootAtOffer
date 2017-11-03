package scut.carson_ho.shootatoffer;

/**
 * Created by Carson_Ho on 17/11/3.
 */

public class Exam_28 {

    /**
     * 测试用例
     */
    public static void main(String[] args){
        // 构造测试二叉树1
        //            8
        //       6         6
        //    5     7    7     5
        TreeNode<Integer> root1 = new TreeNode<>(8);
        root1.left = new TreeNode<>(6);
        root1.right = new TreeNode<>(6);
        root1.left.left = new TreeNode<>(5);
        root1.left.right = new TreeNode<>(7);
        root1.right.left = new TreeNode<>(7);
        root1.right.right = new TreeNode<>(5);
        System.out.println(isSymmetrical(root1));
        System.out.println(isSymmetrical2(root1));

        // 构造测试二叉树2
        //            8
        //       6         9
        //    5     7    7     5
        TreeNode<Integer> root2 = new TreeNode<>(8);
        root2.left = new TreeNode<>(6);
        root2.right = new TreeNode<>(9);
        root2.left.left = new TreeNode<>(5);
        root2.left.right = new TreeNode<>(7);
        root2.right.left = new TreeNode<>(7);
        root2.right.right = new TreeNode<>(5);

        System.out.println(isSymmetrical(root2));
        System.out.println(isSymmetrical2(root2));



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
     * 解题思路1：根据二叉树的镜像判断
     * 具体实现：递归
     */
    public static boolean isSymmetrical(TreeNode<Integer> pRoot) {

        return compare(pRoot, pRoot);
    }

    public static boolean compare(TreeNode<Integer> pRoot1, TreeNode<Integer> pRoot2) {

        if (pRoot1 == null && pRoot2 == null)
            return true;
        if (pRoot1 == null || pRoot2 == null) {
            return false;
        }
        if (pRoot1.val != pRoot2.val)
            return false;
        // 根据递归实现
        return compare(pRoot1.left, pRoot2.right) && compare(pRoot1.right, pRoot2.left);
    }

    /**
     * 解题思路2：根据二叉树的左、右子树是否对称
     * 具体实现：递归实现
     * 注：非递归实现 = 队列
     */
    public static boolean isSymmetrical2(TreeNode<Integer> root){
        if(root==null)
            return true;
        if(root.left==null && root.right==null)
            return true;
        if(root.left==null || root.right==null)
            return false;
        return isSymmetrical2(root.left,root.right);
    }
    public static boolean isSymmetrical2(TreeNode<Integer> root1,TreeNode<Integer> root2){
        if(root1==null && root2==null)
            return true;
        if(root1==null || root2==null)
            return false;
        if(!root1.val.equals(root2.val))
            return false;
        return isSymmetrical2(root1.left,root2.right) && isSymmetrical2(root1.right,root2.left);
    }



}
