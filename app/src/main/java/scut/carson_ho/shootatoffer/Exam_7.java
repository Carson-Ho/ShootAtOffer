package scut.carson_ho.shootatoffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Carson_Ho on 17/10/22.
 */

public class Exam_7 {

//
//                1
//              /  \
//              2    3
//             / \  / \
//            4  5 7   6
    /**
     * 思路：使用递归的思路解决问题，分别在左右子树中进行操作
     *
     * @param preOrderList
     * @param inOrderList
     * @return
     */
    private static TreeNode reBuildTree(List<Integer> preOrderList, List<Integer> inOrderList) {
        // 1. 判断输入的序列合法性
        if (preOrderList == null || inOrderList == null)
            return null;


        TreeNode root = null; // 根结点
        List<Integer> leftPreOrderList; // 左子树的前序遍历序列
        List<Integer> rightPreOrderList;// 右子树的前序遍历序列
        List<Integer> leftInOrderList;// 左子树的中序遍历序列
        List<Integer> rightInOrderList;// 左子树的前序遍历序列

        int inOrderPos;
        int preOrderPos;


        if (preOrderList.size() != 0 && inOrderList.size() != 0) {
            // 2. 把前序遍历序列的第1个结点设置为根结点
            root = new TreeNode(preOrderList.get(0));
            // 3. 根据根结点，找出 前序遍历 & 中序遍历的左、右子树序列
            // a. 找出中序遍历的左、右子树序列
            inOrderPos = inOrderList.indexOf(preOrderList.get(0));   // 中序遍历序列的分割点 = 根节点 = 前序遍历序列的第1个
            leftInOrderList = inOrderList.subList(0, inOrderPos); // 左子树 = 中序遍历序列的前部分
            rightInOrderList = inOrderList.subList(inOrderPos + 1, inOrderList.size());// 右子树 = 中序遍历序列的后部分

            // a. 找出前序遍历的左、右子树序列
            preOrderPos = leftInOrderList.size();  // 前序遍历序列的分割点 = 左子树的数目 = 中序遍历序列的前部分长度
            leftPreOrderList = preOrderList.subList(1, preOrderPos + 1);// 左子树 = 第2位 - 分割点（第1位是根结点）
            rightPreOrderList = preOrderList.subList(preOrderPos + 1, preOrderList.size()); // 右子树 = 分割点后1位 - 末尾

            // 4. 将上述找出的2个左子树遍历顺序序列（前序 、中序）、2个右子树 分别作为递归的输入，构建出 二叉树的左&右子树
            // a. 左子树 = 前序遍历、中序遍历的左子树序列作为输入，调用本函数进行递归而形成的树
            root.left = reBuildTree(leftPreOrderList, leftInOrderList);
            // b. 右子树 = 前序遍历、中序遍历的右子树序列作为输入，调用本函数进行递归而形成的树
            root.right = reBuildTree(rightPreOrderList, rightInOrderList);

        }
        return root;

    }

    // 建立二叉树节点类
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }


    }

    /**
     * 分层遍历二叉树，使用一个队列，也就是宽度优先遍历
     * @param root
     */
    public static void levelTraversal(TreeNode root){
        if(root==null)
            return ;

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.remove();
            System.out.print(cur.val+" ");
            if(cur.left!=null)
                queue.add(cur.left);
            if(cur.right!=null)
                queue.add(cur.right);

        }
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        TreeNode r6 = new TreeNode(6);
        TreeNode r7 = new TreeNode(7);

        root.left = r2;
        root.right = r3;
        r2.left = r4;
        r2.right = r5;
        r3.right = r6;
        r3.left = r7;
        List<Integer> preList = new ArrayList<>();
        preList.add(1);
        preList.add(2);
        preList.add(4);
        preList.add(5);
        preList.add(3);
        preList.add(7);
        preList.add(6);

        List<Integer> inList = new ArrayList<>();
        inList.add(4);
        inList.add(2);
        inList.add(5);
        inList.add(1);
        inList.add(7);
        inList.add(3);
        inList.add(6);


        TreeNode reBuildTree = reBuildTree(preList, inList);
        levelTraversal(reBuildTree);

    }
}
