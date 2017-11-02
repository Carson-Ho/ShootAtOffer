package scut.carson_ho.shootatoffer;

/**
 * Created by Carson_Ho on 17/11/2.
 */

public class Exam_26 {

    public static void main(String[] args){
        // 树结构定义
        // 树A
        TreeNode root1 = new TreeNode (8);
        root1.leftNode = new TreeNode(8);
        root1.rightNode = new TreeNode(7);
        root1.leftNode.leftNode = new TreeNode(9);
        root1.leftNode.rightNode = new TreeNode(2);
        root1.leftNode.rightNode.leftNode = new TreeNode(4);
        root1.leftNode.rightNode.rightNode = new TreeNode(7);

        // 树B
        TreeNode root2 = new TreeNode(8);
        root2.leftNode = new TreeNode(9);
        root2.rightNode = new TreeNode(2);

        // 树C
        TreeNode root3 = new TreeNode(2);
        root3.leftNode = new TreeNode(4);
        root3.rightNode = new TreeNode(3);

        // 功能测试：树B是树A的子结构、树C是树A的子结构
        System.out.println(hasSubtree(root1,root2));
        System.out.println(hasSubtree(root1,root3));

        // 异常测试：树A、树B 任一为空 / 均为空时
        System.out.println(hasSubtree(null,root3));
        System.out.println(hasSubtree(root1,null));
        System.out.println(hasSubtree(null,null));
    }
        /**
         * 设置结点结构
         */
        public static class TreeNode {
            double val; // 二叉树的结点数据
            TreeNode leftNode; // 二叉树的左子树（左孩子）
            TreeNode rightNode; // 二叉树的右子树（右孩子）

            public TreeNode(double data) {
                this.val = data;
                this.leftNode = null;
                this.rightNode = null;
            }
        }

    /**
     * 解题算法
     * 主要步骤：
     * 1. 在树A中找到与树B的根节点值相同的节点R
     * 2. 判断 树A中以R为根节点的子树 是否 包含和树B一样的结构
     */
    public static boolean hasSubtree(TreeNode root1, TreeNode root2){

        // 注意输入的树A、树B空指针的判断
        if(root2==null)
            return false;
        if(root1==null)
            return false;

        // 1.  在树A中找到与树B的根节点值相同的节点R
        // 通过新定义的判断函数，判断2个小数（doubl）是否相等
        if(equal(root1.val,root2.val)){
            // 若相等，则继续判断 树A中以R为根节点的子树 是否 包含和树B一样的结构
            if(tree1HasTree2FromRoot(root1,root2))
                return true;
        }
        // 通过递归继续寻找 树A中与树B的根节点值相同的节点R
        return hasSubtree(root1.leftNode,root2) || hasSubtree(root1.rightNode,root2);
    }

    /**
     * 判断 树A中以R为根节点的子树 是否 包含和树B一样的结构
     */

    public static boolean tree1HasTree2FromRoot(TreeNode root1, TreeNode root2){
        // 注意输入的子树节点的空指针判断
        if(root2==null)
            return true;

        if(root1==null)
            return false;
        // 若子树节点相等，则继续往下判断
        if(equal(root1.val,root2.val) && tree1HasTree2FromRoot(root1.leftNode,root2.leftNode) && tree1HasTree2FromRoot(root1.rightNode,root2.rightNode))
            // 若根节点的左、右子树均相等，则说明 B是A的子结构

            return true;
        else
            return false;

    }
    /**
     * 判断 double值相等函数
     */
    public static boolean equal(double root1, double root2){
        if((root1 - root2 > -0.0000001) && (root1 - root2 < 0.0000001))
            return true;
        else
            return false;

    }


}
