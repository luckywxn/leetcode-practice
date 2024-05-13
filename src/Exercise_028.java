public class Exercise_028 {
    public static void main(String[] args) {
        Exercise_028 exercise_028 = new Exercise_028();
//        String haystack = "sadbutsad", needle = "sad";
        String haystack = "leetcode", needle = "leeto";
        System.out.println(exercise_028.strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
