public class Exercise_034 {
    public static void main(String[] args){
        Exercise_034 exercise_034 = new Exercise_034();
        int[] nums = new int[]{5,7,7,8,8,10};
        int [] res = exercise_034.searchRange(nums,8);
        System.out.println();
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        if(nums.length == 0) return result;
        boolean isFind = false;
        for (int i = 0;i < nums.length ; i ++) {
            if (nums[i] == target && !isFind){
                result[0] = i;
                isFind = true;
            }
            if (nums[i] == target){
                result[1] = i;
            }
        }
        return result;
    }
}
