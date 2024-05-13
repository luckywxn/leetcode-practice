public class Exercise_027 {
    public static void main(String[] args) {
        Exercise_027 exercise_027 = new Exercise_027();

        int[] nums = new int[]{3,2,2,3};
        System.out.println(exercise_027.removeElement(nums,3));

        for (int k : nums) {
            System.out.println(k);
        }
    }

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0){
            return 0;
        }
        int initLength = nums.length;
        int count = 0;
        int deleteCount = 0;
        int len = nums.length;
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] == val) {
                for (int j = i ; j < nums.length -1 ;j ++) {
                    nums[j] = nums[j + 1];
                }
                ++ deleteCount ;
                nums[nums.length - deleteCount] = 0;
                len--;
                i--;
            }
            count++;
            if (count == initLength){
                break;
            }
        }
        return len;

    }
}
