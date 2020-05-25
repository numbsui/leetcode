package com.sld.tree;

/**
 * @author sld
 * <p>
 * leetcode 450
 * https://leetcode.com/problems/delete-node-in-a-bst/
 */
public class DeleteNodeinaBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left = root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        TreeNode left2 = left.left = new TreeNode(2);
        left.right = new TreeNode(4);

        left2.left = new TreeNode(1);

        int k = 3;
        System.out.println(deleteNode(root, k));
    }

    private static int findLeft(TreeNode root) {
        root = root.right;
        while (root.left != null)
            root = root.left;
        return root.val;
    }

    private static int findRight(TreeNode root) {
        root = root.left;
        while (root.right != null)
            root = root.right;
        return root.val;
    }

    private static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null && root.right == null)
                root = null;
            else if (root.left != null) {
                root.val = findRight(root);
                root.left = deleteNode(root.left, root.val);
            } else {
                root.val = findLeft(root);
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }



    class Solution {
        /*
        One step right and then always left
        */
        public int successor(TreeNode root) {
            root = root.right;
            while (root.left != null) root = root.left;
            return root.val;
        }

        /*
        One step left and then always right
        */
        public int predecessor(TreeNode root) {
            root = root.left;
            while (root.right != null) root = root.right;
            return root.val;
        }

        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) return null;

            // delete from the right subtree
            if (key > root.val) root.right = deleteNode(root.right, key);
                // delete from the left subtree
            else if (key < root.val) root.left = deleteNode(root.left, key);
                // delete the current node
            else {
                // the node is a leaf
                if (root.left == null && root.right == null) root = null;
                    // the node is not a leaf and has a right child
                else if (root.right != null) {
                    root.val = successor(root);
                    root.right = deleteNode(root.right, root.val);
                }
                // the node is not a leaf, has no right child, and has a left child
                else {
                    root.val = predecessor(root);
                    root.left = deleteNode(root.left, root.val);
                }
            }
            return root;
        }
    }

}
