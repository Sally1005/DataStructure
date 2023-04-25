package com.lonton.leetcode.easy;
/**
 * 485. 最大连续 1 的个数 <p/>
 * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。<p/>
 * 请注意 ，nums[i] 不是 0 就是 1。 <p/>
 * 思路：<p/>
 * <li> 声明一个 两个变量，一个判断当前值是否是 1，一个记录最大值。
 *
 * @author 张利红
 */
public class Q485MaxConsecutiveOnes {
    /**
     * 最大连续 1 的个数
     *
     * @param nums 二进制数组
     * @return 最大连续 1 的个数
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0 ;
        int cur = 0;
        for(int x : nums){
            if(x == 0){
                cur = 0;
            }else{
                cur = cur+1;
            }
            max = Math.max(max,cur);
        }
        return max;
    }
}
