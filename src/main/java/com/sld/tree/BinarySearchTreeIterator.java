package com.sld.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author suilindong
 * <p>
 * leetcode 173
 * https://leetcode.com/problems/binary-search-tree-iterator/
 */
public class BinarySearchTreeIterator {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);

        TreeNode right = new TreeNode(15);
        root.right = right;

        right.left = new TreeNode(9);
        right.right = new TreeNode(20);

        BSTIterator2 iterator = new BSTIterator2(root);
        System.out.println(iterator.next()); //3
        System.out.println(iterator.next()); //7
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next()); //9
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next()); //15
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next()); //20
        System.out.println(iterator.hasNext());

    }

    static class BSTIterator {

        private List<Integer> list;
        private int index = 0;

        public BSTIterator(TreeNode root) {
            list = inorderTraversal(root);
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            return list.get(index++);
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !(index == list.size());
        }

        //递归
       public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            inOrder(root, result);
            return result;
        }

        public void inOrder(TreeNode root, List<Integer> list) {
            if (root == null) return;
            inOrder(root.left, list);
            list.add(root.val);
            inOrder(root.right, list);
        }
    }

    static class BSTIterator2 {

        Stack<TreeNode> stack;

        public BSTIterator2(TreeNode root) {
            stack = new Stack<>();
            helper(root);
        }

        private void helper(TreeNode node) {
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        public int next() {
            TreeNode node = stack.pop();
            if (node.right != null)
                helper(node.right);
            return node.val;
        }

        public boolean hasNext() {
            return stack.size() > 0;
        }
    }

}
