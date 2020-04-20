package com.sld.design;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sld
 * <p>
 * leetcode 146
 * https://leetcode.com/problems/lru-cache/
 */
public class LRUCache {

    private Map<Integer, LinkedNode> cache = new HashMap<>();
    private int count;
    private int capacity;
    private LinkedNode head;
    private LinkedNode tail;

    private static class LinkedNode {
        int key;
        int value;
        LinkedNode pre;
        LinkedNode post;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(5);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        System.out.println(lruCache.get(1));

    }

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        head = new LinkedNode();
        head.pre = null;
        tail = new LinkedNode();
        tail.post = null;
        head.post = tail;
        tail.pre = head;
    }

    public int get(int key) {
        LinkedNode node = cache.get(key);
        if (node == null) return -1;

        this.moveToHead(node);
        return node.value;
    }

    private void moveToHead(LinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    //插入头节点之后
    private void addNode(LinkedNode node) {
        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

    private void removeNode(LinkedNode node) {
        node.pre.post = node.post;
        node.post.pre = node.pre;
    }

    public void put(int key, int value) {
        LinkedNode node = cache.get(key);
        if (node == null) {
            LinkedNode newNode = new LinkedNode();
            newNode.key = key;
            newNode.value = value;
            this.cache.put(key, newNode);
            this.addNode(newNode);
            count++;
            if (count > capacity) {
                LinkedNode tailNode = this.popTail();
                this.cache.remove(tailNode.key);
                count--;
            }
        } else {
            node.value = value;
            this.moveToHead(node);
        }
    }

    //删除尾节点前一个节点
    private LinkedNode popTail() {
        LinkedNode node = tail.pre;
        this.removeNode(node);
        return node;
    }
}
