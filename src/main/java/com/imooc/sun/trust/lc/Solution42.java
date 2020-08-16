package com.imooc.sun.trust.lc;

/**
 * 每日一题 20200404
 */
public class Solution42 {
    public int trap(int[] height) {
        int ans = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int l = 0, r = 0;
            for (int j = i; j >= 0; j--) {
                l = Math.max(l, height[j]);
            }
            for (int j = i; j < height.length; j++) {
                r = Math.max(r, height[j]);
            }
            ans += Math.min(l, r) - height[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        new Solution42().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
    }
}
