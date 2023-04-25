package com.lonton.leetcode.easy;

/**
 * 283. 移动零 <p/>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。<p/>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作 <p/>
 * 思路：<p/>
 * <ol>
 * <li> 声明一个 数组下标 idx；
 * <li> 遍历数组，对于不等于 0 的值 从左至右进行下标赋值；
 * <li> 将0都挪到后面（终止条件： idx < nums.length )；
 * <li> 踩坑：“非零元素的相对顺序” 并不是指递增或递减顺序，是指除去0之后本来的顺序。
 * </ol>
 *
 * @author 张利红
 */
public class Q283MoveZeroes {
    /**
     * 移动零
     *
     * @param nums int数组
     */
    public void moveZeroes(int[] nums) {
        int idx = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[idx++] = num;
            }
        }
        while (idx < nums.length) {
            nums[idx++] = 0;
        }
    }
}
