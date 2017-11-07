package scut.carson_ho.shootatoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carson_Ho on 17/11/7.
 */

public class Exam_34 {

    /**
     * 测试用例
     */
    public static void main(String[] args) {

        // 功能测试
        //            10
        //          /   \
        //         5     12
        //       /  \
        //      4    7
        TreeNode<Integer> root = new TreeNode<Integer>(10);
        root.leftNode = new TreeNode<Integer>(5);
        root.rightNode = new TreeNode<Integer>(12);
        root.leftNode.leftNode = new TreeNode<Integer>(4);
        root.leftNode.rightNode = new TreeNode<Integer>(7);
        findPath(root,22);
        findPath(root,32);

        // 特殊输入测试
        findPath(null,12);
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
     * 解题算法
     *
     * @param root        树的根结点
     * @param exceptedSum 要求的路径和
     */
    public static void findPath(TreeNode<Integer> root,int exceptedSum){
        // 1. 判断输入数据的合法性：若二叉树的根结点为空，则结束判断
        if(root == null) {
            System.out.println("输入的二叉树节点为空");
            return;
        }
        // 2. 创建1个链表：用于 路径节点，即存放根结点到当前处理结点的所经过的结点
        List<Integer> path = new ArrayList<>();
        // 3. 调用辅助方法通过前序遍历二叉树 & 记录下路径
        findPath(root,path,exceptedSum,0);
    }

    /**
     * 辅助方法
     *
     * @param curNode     当前要处理的结点（未加入到路径中）
     * @param path        路径节点，即存放根结点到当前处理结点的所经过的结点（未包括当前结点）
     * @param exceptedSum 要求的路径和
     * @param currentSum      当前记录的和（未加上当前结点的值）
     */

    public static void findPath(TreeNode<Integer> curNode,List<Integer> path,int exceptedSum,int currentSum){
        // 1. 记录下当前节点值到路径
        path.add(curNode.val);
        // 2. 计算路径节点值的和
        currentSum += curNode.val;
        // 3. 若当前节点 ≠ 叶子结点，则遍历其子节点
        if(curNode.leftNode!=null)
            findPath(curNode.leftNode,path,exceptedSum,currentSum);
        if(curNode.rightNode!=null)
            findPath(curNode.rightNode,path,exceptedSum,currentSum);
        // 4. 若当前节点 = 叶节点 & 路径节点值的和 = 期望值，则认为该路径符合要求，直接输出
        if(curNode.leftNode == null && curNode.rightNode == null && currentSum==exceptedSum)
            System.out.println(path);

        // 5. 若遍历的结点 = 叶结点 & 路径中节点值的和  ≠ 输入的整数
        // 自动回到其父结点 & 继续遍历其他子节点
        // 注：函数退出前，要在路径上删除当前结点 & 减去当前结点的值，以确保返回父结点时，路径 = 从根结点 -> 父结点的路径
        path.remove(path.size()-1) ;
    }

}
