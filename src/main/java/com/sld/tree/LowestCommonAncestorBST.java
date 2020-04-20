package com.sld.tree;

/**
 * @author sld
 *
 * leetcode 235
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class LowestCommonAncestorBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        TreeNode left = root.left = new TreeNode(2);
        TreeNode right = root.right = new TreeNode(8);

        left.left = new TreeNode(0);
        left.right = new TreeNode(4);

        right.left = new TreeNode(7);
        right.right = new TreeNode(9);
        System.out.println(lowestCommonAncestor2(root, left, right).val);
    }

    //因为BST满足所有左子树的值小于根节点，所有右子树的值大于根节点，所以比较p和q的值与根节点的值，然后递归
    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    //上述递归也可以使用循环
    private static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}
