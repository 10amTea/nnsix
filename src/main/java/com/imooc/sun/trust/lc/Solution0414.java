package com.imooc.sun.trust.lc;

import java.util.ArrayList;
import java.util.List;

public class Solution0414 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> l1List = getNumList(l1);
        List<Integer> l2List = getNumList(l2);
        // 进位问题
        List<Integer> ans = new ArrayList<>();
        int ansInt = list2Int(l1List) + list2Int(l2List);

        if (ansInt != 0) {
            while (ansInt % 10 != 0) {
                ans.add(ansInt / 10);
                ansInt = ansInt % 10;
            }
        }
        // 遍历还原
        ListNode[] listNodes = new ListNode[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            listNodes[i] = new ListNode(ans.get(i));
        }
        for (int i = 0; i < listNodes.length; i++) {
            if (i == listNodes.length - 1) {
                listNodes[i].next = null;
            } else {
                listNodes[i].next = listNodes[i + 1];
            }
        }
        if (listNodes.length == 0) {
            return null;
        } else {
            return listNodes[0];
        }
    }

    private int list2Int(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (Integer integer : list) {
            sb.append(integer);
        }
        return new Integer(sb.toString());
    }

    private List<Integer> getNumList(ListNode listNode) {
        List<Integer> result = new ArrayList<>();
        while (listNode.next != null) {
            result.add(listNode.val);
            listNode = listNode.next;
        }
        return result;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}