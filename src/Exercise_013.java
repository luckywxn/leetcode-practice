public class Exercise_013 {
    public static void main(String[] args)
    {
        Exercise_013 ex = new Exercise_013();
        System.out.println(ex.romanToInt("III"));
        System.out.println(ex.romanToInt("IV"));
        System.out.println(ex.romanToInt("IX"));
        System.out.println(ex.romanToInt("LVIII"));
        System.out.println(ex.romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        int[] nums = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] str = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int result = 0;
        while (s.length() > 0){
            for (int j = 0; j < str.length; j++) {
                if (s.startsWith(str[j])) {
                    result += nums[j];
                    s = s.replaceFirst(str[j],"");
                    break;
                }
            }
        }
        return result;
    }
}
