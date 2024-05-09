public class Exercise_009 {
    public static void main(String[] args){
        Exercise_009 ex = new Exercise_009();
        int x = 1;
        System.out.println(ex.isPalindrome(x));
    }
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        for(int i = 0; i < str.length() / 2; i++){
            if(str.charAt(i) != str.charAt(str.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }
}
