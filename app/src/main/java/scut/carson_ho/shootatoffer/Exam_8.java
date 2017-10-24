package scut.carson_ho.shootatoffer;

/**
 * Created by Carson_Ho on 17/10/24.
 */

public class Exam_8 {

    public static void main(String[] args) {
        // 定义树结构

//                a
//              /  \
//             b    c
//             / \  / \
//            d  e f   g
//              / \
//             h   i

        TreeNode root = new TreeNode("a");
        TreeNode r2 = new TreeNode("b");
        TreeNode r3 = new TreeNode("c");
        TreeNode r4 = new TreeNode("d");
        TreeNode r5 = new TreeNode("e");
        TreeNode r6 = new TreeNode("f");
        TreeNode r7 = new TreeNode("g");
        TreeNode r8 = new TreeNode("h");
        TreeNode r9 = new TreeNode("i");

        root.left = r2;
        root.right = r3;

        r2.parent = root;
        r2.left = r4;
        r2.right = r5;

        r3.parent = root;
        r3.right = r6;
        r3.left = r7;

        r4.parent = r2;
        r5.parent = r2;
        r5.right = r9;
        r5.left = r8;

        r7.parent = r3;
        r6.parent = r3;

        r8.parent = r5;
        r9.parent = r5;

        // 测试该结点有右子树的情况（b）
        System.out.println(getNextTreeNode(r2).val);

        // 测试该结点无 右子树 & 是其父结点的左子树（d）
        System.out.println(getNextTreeNode(r4).val);

        // 测试该结点无 右子树 & 是其父结点的右子树（i）
        System.out.println(getNextTreeNode(r9).val);

    }



    /**
     * 获取下1个结点算法
     */

    private static TreeNode getNextTreeNode(TreeNode targetNode) {
        // 1. 判断输入的结点的合法性
        if (targetNode == null)
            return null;
        TreeNode cur = null;
        // 2. 判断输入结点是否有右孩子
        //
        if (targetNode.right != null) {
            cur = targetNode.right;

            // 若具备右孩子，找出其右孩子节点的 最 左边孩子节点
            while (cur.left != null) {
                // 设置下1个结点 = 其右子树 的最左子结点
                cur = cur.left;
            }
            return cur;
        }

        // 3. 若该节点没有右孩子节点，则判断其是否是其父节点的左孩子
        if (targetNode.parent == null) {
            return null;
        }
        if (targetNode == targetNode.parent.left) {
            // 若是其父节点的左孩子，就设置下1个结点 = 其父结点
            return targetNode.parent;
        }

        // 3. 此时，该节点既没有右孩子节点，也不是其父节点的左孩子
        // 向上寻找其父节点，直到找到父节点是其父节点的左孩子为此，此时，下一个节点为最后那个父节点
        while (targetNode.parent != null) {
            if (targetNode == targetNode.parent.left) {
                return targetNode.parent;
            }
            // 继续寻找
            targetNode = targetNode.parent;
        }
        return null;

    }


}

/**
 * 建立二叉树节点类
 */

class TreeNode {
    String val;
    TreeNode left;
    TreeNode right;
    TreeNode parent;

    public TreeNode(String val) {
        this.val = val;
    }

}
