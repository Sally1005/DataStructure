package com.lonton.leetcode.easy;

/**
 * 645. 错误的集合 <p/>
 * 集合 s 包含从 1 到 n 的整数。<p/>
 * 不幸的是,因为数据错误,导致集合里面某一个数字复制了成了集合里面的另外一个数字的值,导致集合丢失了一个数字并且有一个数字重复。<p/>
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。<p/>
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。<p/>
 *
 * @author 张利红
 */
public class Q645SetMismatch {
    /**
     * 查找整数数组中的缺失和重复数字
     *
     * @param nums 整数数组
     * @return 包含缺失和重复数字的数组（缺失数字在前，重复数字在后），如果未发现任何不一致，则返回null
     */
    public int[] findErrorNums(int[] nums) {
        // 遍历数值数组，将每个元素移动到正确的位置上，即 nums[i] 应该等于 i + 1
        for (int i = 0; i < nums.length; i++) {
            // 只要当前元素不等于它应该处于的位置（i+1），且该元素所对应的位置上的元素不等于当前元素，则交换它们的位置
            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        // 再次遍历数值数组，查找重复和丢失的数字
        for (int i = 0; i < nums.length; i++) {
            // 如果当前元素不等于它应该处于的位置（i+1），则说明它是缺失或重复的数字
            if (nums[i] != i + 1) {
                // 返回包含缺失和重复数字的数组（缺失数字在前，重复数字在后）
                return new int[]{nums[i], i + 1};
            }
        }
        // 如果没有找到任何不一致，返回null
        return null;
    }

    /**
     * 交换数组nums中索引为i和j的元素
     *
     * @param nums 整数数组
     * @param i    要交换的元素索引
     * @param j    要交换的元素索引
     */
    protected void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
