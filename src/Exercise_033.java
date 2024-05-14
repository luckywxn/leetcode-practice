public class Exercise_033 {
    public static void main(String[] args){
        Exercise_033 exercise_033 = new Exercise_033();
        System.out.println(exercise_033.search(new int[]{4,5,6,7,0,1,2}, 0));
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;
        if (nums[0] > target){
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] == target) return i;
            }
            return -1;
        }else {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) return i;
            }
            return -1;
        }
    }
}
