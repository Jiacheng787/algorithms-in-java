public class RemoveDuplicatesSolution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        // 初始状态下 slow 和 fast 都在头节点位置
        int slow = 0, fast = 0;
        // 使用 fast 指针遍历数组
        // 实际也可改为 for 循环
        while (fast < nums.length) {
            // 由于一开始都在头节点，必然相等，所以 fast 先前进一步
            if (nums[slow] != nums[fast]) {
                slow++;
                // 维护 nums[0..slow] 无重复
                nums[slow] = nums[fast];
            }
            fast++;
        }
        // 数组长度为索引 + 1
        return slow + 1;
    }
}
