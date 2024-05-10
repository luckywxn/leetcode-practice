public class Exercise_012 {
    public static void main(String[] args){
        Exercise_012 ex = new Exercise_012();

        System.out.println(ex.intToRoman(3));
        System.out.println(ex.intToRoman(4));
        System.out.println(ex.intToRoman(9));
        System.out.println(ex.intToRoman(58));
        System.out.println(ex.intToRoman(1994));
    }
    public String intToRoman(int num) {
        int[] nums = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] str = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        for (int i = 0 ;i < nums.length; i++) {
            if (num >= nums[i]) {
                return str[i] + intToRoman(num -  nums[i]);
            }
        }
        return "";
    }
}
