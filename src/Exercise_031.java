import java.util.Arrays;

public class Exercise_031 {
    public static void main(String[] args){
        Exercise_031 exercise_031 = new Exercise_031();
        int [] nums = new int[]{1,2,3};
        exercise_031.nextPermutation(nums);
        System.out.println();
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //1、从后向前遍历数组，找到第一个比它后面的元素小的数字nums[i]。
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        //2、如果找到了这样的数字，从后向前遍历数组，找到第一个比nums[i]大的数字nums[j]，并交换这两个数字。
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        //
        /**3、对nums[i+1:]部分进行反转，使其变为升序。
         * 如果原始数组已经是降序，那么在第一步就找不到符合条件的nums[i]，所以会直接反转整个数组，得到最小的排列。
         */
        reverse(nums, i + 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
