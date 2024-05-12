import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise_026 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0,0,0};


        System.out.println(new Exercise_026().removeDuplicates(nums));

        for (int k : nums) {
            System.out.println(k);
        }
    }

    public int removeDuplicates2(int[] nums) {
        List<Integer> list = new ArrayList<>(Arrays.stream(nums).boxed().distinct().collect(Collectors.toList()));
        nums = list.stream().mapToInt(i -> i).toArray();
        return list.size();
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int initLength = nums.length;
        int count = 0;
        int len = nums.length;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                for (int j = i + 1; j < nums.length -1 ;j ++) {
                    nums[j] = nums[j + 1];
                }
                nums[nums.length - 1] = 0;
                len--;
                i--;
            }else if (nums[i] > nums[i + 1]){
                break;
            }
            count++;
            if (count == initLength - 1){
                break;
            }
        }
        return len;
    }
}
