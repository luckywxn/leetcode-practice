import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Exercise_015 {
    public static void main(String[] args){
        Exercise_015 ex = new Exercise_015();
        System.out.println(ex.threeSum(new int[]{-1,0,1,2,-1,-4}));

    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if (nums[i] > 0){
                break;
            }
            for(int j = i + 1; j < nums.length; j++){
                int finalI = i;
                int finalJ = j;
                int[] subarray = IntStream.range(finalJ + 1, nums.length)
                        .mapToObj(x -> nums[x]).mapToInt(x->x).toArray();
                boolean exists = Arrays.stream(subarray).anyMatch(x -> x == -(nums[finalI] + nums[finalJ]));
                if (exists){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(-(nums[finalI] + nums[finalJ]));
                    Collections.sort(temp);
                    if(!result.contains(temp)){
                        result.add(temp);
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) { // 防止重复和避免重复元素
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++; // 去重
                    while (left < right && nums[right] == nums[right - 1]) right--; // 去重
                    left++; right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
