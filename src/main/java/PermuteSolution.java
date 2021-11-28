import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode 46 全排列
 * https://leetcode-cn.com/problems/permutations/
 */
public class PermuteSolution {
    private List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            // 这边 new LinkedList<>() 作用目测是浅拷贝
            this.res.add(new LinkedList<>(track));
            return;
        }
        for (int num : nums) {
            if (track.contains(num)) {
                continue;
            }
            track.add(num);
            backtrack(nums, track);
            // 注意 removeLast 方法只有 LinkedList 接口定义，List 接口是没有的
            track.removeLast();
        }
    }

    public static void main(String[] args) {
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        System.out.println(list);
//        List<Integer> mapped = list.stream().map((n) -> n * 2).toList();
//        System.out.println(mapped);
//        List<Integer> filter = mapped.stream().filter(n -> n > 2).toList();
//        System.out.println(filter);
        int[] nums = {1, 2, 3};
        System.out.println(
            new PermuteSolution().permute(nums)
        );
    }
}
