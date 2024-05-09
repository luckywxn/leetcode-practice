public class Exercise_007 {
    public static void main(String[] args) {
        Exercise_007 exercise_007 = new Exercise_007();
        int x = 1534236469;
        System.out.println(exercise_007.reverse(x));
    }
    public int reverse(int x) {
        String str = String.valueOf(x);
        StringBuilder builder = new StringBuilder();
        if (str.charAt(0) == '-') {
            str = str.substring(1);
            builder.append('-');
        }
        for (int i = str.length() - 1; i >= 0; i--) {
            builder.append(str.charAt(i));
        }
        try {
            return Integer.valueOf(builder.toString());
        }catch (Exception e){
            return 0;
        }
    }

}
