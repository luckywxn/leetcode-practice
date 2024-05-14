import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise_018 {
    public static void main(String[] args){
        Exercise_018 ex = new Exercise_018();
//        System.out.println(ex.fourSum(new int[]{1,0,-1,0,-2,2},0));
//        System.out.println(ex.fourSum(new int[]{2,2,2,2,2},8));
        System.out.println(ex.fourSum(new int[]{1000000000,1000000000,1000000000,1000000000},-294967296));
    }

    public List<List<Integer>> fourSum(int[] nums, int target){
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2 ; i++) {
            int first = nums[i];
            for (int j = nums.length - 1 ;j > i + 1 ;j --){
                int last = j;
                int left = i + 1, right = last - 1;
                while (left < right && right < j) {
                    long sum = (long)first + nums[left] + nums[right] + nums[last];
                    if (sum == target) {
                        result.add(Arrays.asList(first, nums[left], nums[right],nums[last]));
                        left++; right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result.stream().distinct().collect(Collectors.toList());
    }
}
