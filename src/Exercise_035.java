public class Exercise_035 {
    public static void main(String[] args){
        Exercise_035 exercise_035 = new Exercise_035();
        System.out.println(exercise_035.searchInsert(new int[]{1,3,5,6}, 2));
    }

    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int targetIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) return i;
            if (nums[i] < target) {
                targetIndex = i + 1;
            }
        }
        return targetIndex;
    }
}
