import java.util.Arrays;

public class Exercise_014 {
    public static void main(String[] args)
    {
        Exercise_014 exercise_014 = new Exercise_014();
//        String[] strs = new String[]{"flower","flow","flight"};
        String[] strs = new String[]{"dog","racecar","car"};
        System.out.println(exercise_014.longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        String result = "";
        int minLength = Arrays.stream(strs)
                .mapToInt(String::length)
                .min()
                .orElse(Integer.MAX_VALUE);
        for (int i = 0 ;i < minLength; i ++ ) {
            for (String str : strs) {
                if (str.charAt(i) != strs[0].charAt(i)){
                    return result;
                }
            }
            result += strs[0].charAt(i);
        }
        return result;
    }
}
