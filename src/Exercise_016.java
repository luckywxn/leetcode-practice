import java.util.Arrays;

public class Exercise_016 {
    public static void main(String[] args){

        Exercise_016 ex = new Exercise_016();
        System.out.println(ex.threeSumClosest(new int[]{0,0,0},1));
    }

    public int threeSumClosest(int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        if (nums == null || nums.length < 3) return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2 ; i++) {
            int left = i + 1, right = nums.length - 1;
            int first = nums[i];
            while (left < right) {
                int sum = first + nums[left] + nums[right];
                if (Math.abs(target - result) > Math.abs(target - sum)) {
                    result = sum;
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
