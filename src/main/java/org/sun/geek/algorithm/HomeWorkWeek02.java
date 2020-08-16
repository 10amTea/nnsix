package org.sun.geek.algorithm;

import java.util.*;

public class HomeWorkWeek02 {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && i != map.get(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    // N 叉树前序遍历
    public List<Integer> preorder(Node root) {
        // 根左右
        return null;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return null;
        }
        // 1、key 排完序的字符串
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] strArray = str.toCharArray();
            Arrays.sort(strArray);
            String key = String.valueOf(strArray);
            List<String> list = map.getOrDefault(key, new ArrayList<>()); // 不含 key 也会返回一个 ArrayList<>()
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size(); // 每一层的个数
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                level.add(node.val);
                queue.addAll(node.children);
            }
            result.add(level);
        }
        return result;
    }

    // 1、HashMap key=num, value=次数，排序 value
    public int[] topKFrequent(int[] nums, int k) {
        Queue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return -(o1.getValue() - o2.getValue());
            }
        });
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.add(entry);
        }
        List<Integer> temp = new ArrayList<>();
        while (temp.size() < k) {
            temp.add(maxHeap.poll().getKey());
        }
        int[] res = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            res[i] = temp.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        twoSum(new int[]{2, 2, 4}, 4);
        groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
