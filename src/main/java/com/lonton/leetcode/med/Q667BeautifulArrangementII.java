package com.lonton.leetcode.med;

/**
 * 667. 优美的排列 II <p/>
 * 给你两个整数 n 和 k ，请你构造一个答案列表 answer ，该列表应当包含从 1 到 n 的 n 个不同正整数，并同时满足下述条件： <p/>
 * 假设该列表是 answer = [a1, a2, a3, ... , an] ，那么列表 [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|]  <p/>
 *
 * @author 张利红
 */
public class Q667BeautifulArrangementII {
    /**
     * 构造答案列表
     *
     * @param n 整数 n
     * @param k 整数 k
     * @return 答案列表 answer
     */
    public int[] constructArray(int n, int k) {
        // 创建一个大小为n的数组
        int[] answer = new int[n];
        // 左端点从1开始，右端点从n开始
        int left = 1, right = n;
        // 遍历数组
        for (int i = 0; i < n; i++) {
            // 如果k大于1，我们可以在数组的两端交替取数，直到我们只剩下一个数字
            if (k > 1) {
                // 如果k是奇数，就从左端点取数，left指针向右移动
                // 如果k是偶数，就从右端点取数，right指针向左移动
                answer[i] = (k-- % 2 != 0) ? left++ : right--;
            } else {
                // 如果k等于1，则我们只能按照顺序取数
                answer[i] = left++;
            }
        }
        // 返回答案数组
        return answer;
    }
}
