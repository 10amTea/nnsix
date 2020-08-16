package com.imooc.sun.trust.lc;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;


/**
 * 每日一题 20200405
 */
public class Solution460 {
    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(2 /* capacity (缓存容量) */);

        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        lfuCache.get(1);       // 返回 1
        lfuCache.put(3, 3);    // 去除 key 2
        lfuCache.get(2);       // 返回 -1 (未找到key 2)
        lfuCache.get(3);       // 返回 3
        lfuCache.put(4, 4);    // 去除 key 1
        lfuCache.get(1);       // 返回 -1 (未找到 key 1)
        lfuCache.get(3);       // 返回 3
        lfuCache.get(4);
    }
}

class LFUCache {
    Map<Integer, Node> cache; // 缓存内容
    Map<Integer, LinkedHashSet<Node>> freqMap; // 每个频次对应的 Node
    int realTimeSize;
    int capacity;
    int min;

    public LFUCache(int capacity) {
        cache = new HashMap<>(capacity);
        freqMap = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        freqInc(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            freqInc(node);
        } else {
            if (realTimeSize == capacity) {
                Node deadNode = removeNode();
                cache.remove(deadNode.key);
                realTimeSize--;
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNode(newNode);
            realTimeSize++;
        }
    }

    void freqInc(Node node) {
        int freq = node.freq;
        Set<Node> set = freqMap.get(freq);
        set.remove(node);
        if (freq == min && set.size() == 0) {
            min = freq + 1;
        }
        node.freq++;
        LinkedHashSet<Node> newSet = freqMap.get(freq + 1);
        if (newSet == null) {
            newSet = new LinkedHashSet<>();
            freqMap.put(freq + 1, newSet);
        }
        newSet.add(node);
    }

    Node removeNode() {
        Node deadNode = freqMap.get(min).iterator().next();
        freqMap.get(min).remove(deadNode);
        return deadNode;
    }

    void addNode(Node node) {
        LinkedHashSet<Node> set = freqMap.get(1);
        if (set == null) {
            set = new LinkedHashSet<>();
            freqMap.put(1, set);
        }
        set.add(node);
        min = 1;
    }
}

class Node {
    int key;
    int value;
    int freq = 1;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public static void main(String[] args) {
        String str = "1234";
        String str2 = str + 5678;
        System.out.println(str2);


        float a = 1;
        Math.sqrt(a);
        long b = 1;
        Math.sqrt(b);
        byte c = 1;
        Math.sqrt(c);
    }
}