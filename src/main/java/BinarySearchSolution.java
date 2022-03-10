public class BinarySearchSolution {
    public int binarySolution(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearchSolution solution = new BinarySearchSolution();
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        int res = solution.binarySolution(nums, target);
        System.out.println(res);
    }
}
